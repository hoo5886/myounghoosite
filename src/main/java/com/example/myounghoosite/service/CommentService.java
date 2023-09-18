package com.example.myounghoosite.service;

import com.example.myounghoosite.data.dto.CommentDto;

public interface CommentService {

    CommentDto getComment(Long commentId);
    CommentDto saveComment(CommentDto commentDto);
    CommentDto updateComment(Long commentId, CommentDto commentDto) throws Exception;
    void deleteComment(Long commentId) throws Exception;
}
