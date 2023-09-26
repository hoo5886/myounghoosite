package com.example.myounghoosite.service.impl;

import com.example.myounghoosite.data.dao.CommentDao;
import com.example.myounghoosite.data.dto.CommentDto;
import com.example.myounghoosite.data.entity.Comment;
import com.example.myounghoosite.service.CommentService;

import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final Logger LOGGER = LoggerFactory.getLogger(CommentServiceImpl.class);
    private final CommentDao commentDao;

    @Override
    public CommentDto getComment(Long commentId) {
        LOGGER.info("[getComment] input commentId : {}", commentId);
        Optional<Comment> comment = Optional.of(commentDao.selectComment(commentId).get());

        LOGGER.info("[getComment] commentId : {}, comment content : {}",
            comment.get().getCommentId(), comment.get().getContent());

        CommentDto response = CommentDto
                                .builder()
            .commentId(comment.get().getCommentId())
            .content(comment.get().getContent())
            .member(comment.get().getMember())
            .board(comment.get().getBoard())
            .like(comment.get().getLikes())
            .regDate(comment.get().getRegDate())
            .chgDate(comment.get().getChgDate())
                                .build();
        return response;
    }

    @Override
    public CommentDto saveComment(CommentDto commentDto) {
        LOGGER.info("[savedComment] commentDto : {}", commentDto.toString());
        Comment comment = Comment.builder()
            .commentId(commentDto.getCommentId())
            .content(commentDto.getContent())
            .member(commentDto.getMember())
            .board(commentDto.getBoard())
            .likes(commentDto.getLike())
            .regDate(commentDto.getRegDate())
            .chgDate(commentDto.getChgDate())
            .build();

        Comment savedComment = commentDao.insertComment(comment);
        LOGGER.info("[savedComment] savedComment : {}", savedComment);

        CommentDto response = CommentDto.builder()
            .commentId(savedComment.getCommentId())
            .content(savedComment.getContent())
            .member(savedComment.getMember())
            .board(savedComment.getBoard())
            .like(savedComment.getLikes())
            .regDate(savedComment.getRegDate())
            .chgDate(savedComment.getChgDate())
            .build();

        return response;
    }

    @Override
    public CommentDto updateComment(Long commentId, CommentDto commentDto) throws Exception {
        Comment changedComment = commentDao.updateComment(commentId, commentDto);

        CommentDto response = CommentDto.builder()
            .commentId(changedComment.getCommentId())
            .content(changedComment.getContent())
            .member(changedComment.getMember())
            .board(changedComment.getBoard())
            .like(changedComment.getLikes())
            .regDate(changedComment.getRegDate())
            .chgDate(LocalDateTime.now())
            .build();

        return response;
    }

    @Override
    public void deleteComment(Long commentId) throws Exception {
        commentDao.deleteComment(commentId);
    }
}
