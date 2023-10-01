package com.example.myounghoosite.data.dao.impl;

import com.example.myounghoosite.data.dao.MemberDao;
import com.example.myounghoosite.data.dto.MemberDto;
import com.example.myounghoosite.data.entity.Member;
import com.example.myounghoosite.data.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberDaoImpl implements MemberDao {

    private final MemberRepository memberRepository;

    @Override
    public Member insertMember(Member member) {
        Member savedMember = memberRepository.save(member);

        return savedMember;
    }

    @Override
    public Optional<Member> selectMember(Long id) {
        return Optional.empty();
    }

    @Override
    public Member updateMember(Long id, MemberDto changeDto) throws Exception {
        return null;
    }

    @Override
    public void deleteMember(Long id) throws Exception {

    }
}
