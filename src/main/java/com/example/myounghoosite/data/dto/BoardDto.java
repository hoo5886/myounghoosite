package com.example.myounghoosite.data.dto;

import com.example.myounghoosite.data.entity.Comment;
import com.example.myounghoosite.data.entity.Member;
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
public class BoardDto {

    private Long boardId;
    private String title;
    private String content;
    private String boardType;

    private Member member;
    private List<Comment> comments = new ArrayList<>();

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime regDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime chgDate;
}
