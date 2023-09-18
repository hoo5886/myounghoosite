package com.example.myounghoosite.data.repository;

import com.example.myounghoosite.data.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
