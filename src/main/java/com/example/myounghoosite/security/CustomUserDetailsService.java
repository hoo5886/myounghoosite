package com.example.myounghoosite.security;

import com.example.myounghoosite.data.entity.Member;
import com.example.myounghoosite.data.repository.MemberRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email)
        throws UsernameNotFoundException {

        Member member = memberRepository.findByEmail(email)
            .orElseThrow(
                () -> new UsernameNotFoundException("Cannot found the user")
            );

        List<GrantedAuthority> authorities = new ArrayList<>();

        return new User(member.getEmail(), member.getPassword(), authorities);
    }
}
