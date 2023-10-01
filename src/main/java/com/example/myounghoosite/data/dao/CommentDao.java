package com.example.myounghoosite.data.dao;

import com.example.myounghoosite.data.dto.CommentDto;
import com.example.myounghoosite.data.entity.Comment;
import java.util.Optional;

public interface CommentDao {

    Comment insertComment(Comment comment);
    Optional<Comment> selectComment(Long id);
    Comment updateComment(Long id, CommentDto commentDto) throws Exception;
    void deleteComment(Long id) throws Exception;
}
