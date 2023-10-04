package com.example.myounghoosite.data.dao;

import com.example.myounghoosite.data.entity.Member;
import java.util.Optional;

public interface MemberDao {

    Member insertMember(Member member);

    Optional<Member> selectMember(Long id);

    Member updateMember(Long id, com.example.myounghoosite.data.dto.MemberDto changeDto) throws Exception;

    void deleteMember(Long id) throws Exception;

}
