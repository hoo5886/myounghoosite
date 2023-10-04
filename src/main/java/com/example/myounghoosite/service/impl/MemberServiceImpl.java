package com.example.myounghoosite.service.impl;

import com.example.myounghoosite.data.dao.MemberDao;
import com.example.myounghoosite.data.entity.Member;
import com.example.myounghoosite.service.MemberService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);
    private final MemberDao memberDao;

    @Override
    public List<com.example.myounghoosite.data.dto.MemberDto> getMembers() {

        return null;
    }

    @Override
    public com.example.myounghoosite.data.dto.MemberDto getMember(Long memberId) {
        /**
         * 유저정보를 조회할 때 그 유저가 쓴 게시글과 댓글을 조회?
         */
        LOGGER.info("[getUser] input memberId : {}", memberId);
        Optional<Member> member = Optional.of(memberDao.selectMember(memberId).get());

        LOGGER.info("[getUser] memberId : {}, name : {}", member.get().getMemberId(), member.get().getName());
        com.example.myounghoosite.data.dto.MemberDto response = com.example.myounghoosite.data.dto.MemberDto.builder()
                            .memberId(member.get().getMemberId())
                            .email(member.get().getEmail())
                            .name(member.get().getName())
                            .regDate(member.get().getRegDate())
                            .chgDate(member.get().getChgDate())
                            .build();

        return response;
    }

    @Override
    public com.example.myounghoosite.data.dto.MemberDto saveMember(
        com.example.myounghoosite.data.dto.MemberDto memberDto) {
        LOGGER.info("[savedUser] memberDto : {}", memberDto.toString());
        Member member = Member.builder()
            .memberId(memberDto.getMemberId())
            .email(memberDto.getEmail())
            .name(memberDto.getName())
            .regDate(memberDto.getRegDate())
            .chgDate(memberDto.getChgDate())
            .build();

        Member savedMember = memberDao.insertMember(member);
        LOGGER.info("[savedUser] userDto : {}", savedMember);

        com.example.myounghoosite.data.dto.MemberDto response = com.example.myounghoosite.data.dto.MemberDto.builder()
            .memberId(savedMember.getMemberId())
            .email(savedMember.getEmail())
            .name(savedMember.getName())
            .regDate(savedMember.getRegDate())
            .chgDate(savedMember.getChgDate())
            .build();

        return response;
    }

    @Override
    public com.example.myounghoosite.data.dto.MemberDto updateMember(Long memberId, com.example.myounghoosite.data.dto.MemberDto memberDto) throws Exception {
        Member changedMember = memberDao.updateMember(memberId, memberDto);

        com.example.myounghoosite.data.dto.MemberDto response = com.example.myounghoosite.data.dto.MemberDto.builder()
            .memberId(changedMember.getMemberId())
            .email(changedMember.getEmail())
            .name(changedMember.getName())
            .regDate(changedMember.getRegDate())
            .chgDate(LocalDateTime.now())
            .build();

        return response;
    }

    @Override
    public void deleteMember(Long memberId) throws Exception {
        memberDao.deleteMember(memberId);
    }
}
