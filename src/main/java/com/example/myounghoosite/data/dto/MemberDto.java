package com.example.myounghoosite.data.dto;

import com.example.myounghoosite.data.entity.Board;
import com.example.myounghoosite.data.entity.Comment;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MemberDto {

    private Long memberId;
    private String email;
    private String name;
    private String password;

    private List<Comment> comments = new ArrayList<>();
    private List<Board> boards = new ArrayList<>();

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime regDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime chgDate;

}
