package com.example.myounghoosite.controller;

import com.example.myounghoosite.data.dto.MemberDto;
import com.example.myounghoosite.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<MemberDto> getUser(Long memberId) {
        MemberDto memberDto = memberService.getMember(memberId);

        return ResponseEntity.status(HttpStatus.OK).body(memberDto);
    }

    @PostMapping()
    public ResponseEntity<MemberDto> createUser(@RequestBody MemberDto memberDto) {
        MemberDto response = memberService.saveMember(memberDto);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping
    public ResponseEntity<MemberDto> updateUser(@RequestBody MemberDto memberDto)  throws Exception {
        MemberDto response = memberService.updateMember(memberDto.getMemberId(), memberDto);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(Long memberId) throws Exception {
        memberService.deleteMember(memberId);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}
