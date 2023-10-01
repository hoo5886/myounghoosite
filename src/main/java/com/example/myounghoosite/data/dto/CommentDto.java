package com.example.myounghoosite.data.dto;

import com.example.myounghoosite.data.entity.Board;
import com.example.myounghoosite.data.entity.Member;
import java.time.LocalDateTime;
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
public class CommentDto {

    private Long commentId;
    private String content;
    private Member member;
    private Board board;
    private Long like;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime regDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime chgDate;
}
