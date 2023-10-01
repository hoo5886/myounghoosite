package com.example.myounghoosite.service;

import com.example.myounghoosite.data.dto.MemberDto;
import java.util.List;

public interface MemberService {

    List<MemberDto> getMembers();

    MemberDto getMember(Long userId);
    MemberDto saveMember(MemberDto memberDto);
    MemberDto updateMember(Long userId, MemberDto memberDto) throws Exception;
    void deleteMember(Long userId) throws Exception;
}
