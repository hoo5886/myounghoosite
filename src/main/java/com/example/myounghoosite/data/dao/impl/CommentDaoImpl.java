package com.example.myounghoosite.data.dao.impl;

import com.example.myounghoosite.data.dao.CommentDao;
import com.example.myounghoosite.data.dto.CommentDto;
import com.example.myounghoosite.data.entity.Comment;
import com.example.myounghoosite.data.repository.CommentRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentDaoImpl implements CommentDao {

    private final CommentRepository commentRepository;

    @Override
    public Comment insertComment(Comment comment) {
        Comment savedComment = commentRepository.save(comment);

        return savedComment;
    }

    @Override
    public Optional<Comment> selectComment(Long id) {
        Optional<Comment> selectedComment = Optional.of(commentRepository.getById(id));

        return selectedComment;
    }

    @Override
    public Comment updateComment(Long id, CommentDto commentDto) throws Exception {
        Optional<Comment> selectedComment = commentRepository.findById(id);

        Comment updatedComment;
        if (selectedComment.isPresent()) {
            Comment comment = selectedComment.get();

            comment.setContent(commentDto.getContent());
            comment.setChgDate(LocalDateTime.now());

            updatedComment = commentRepository.save(comment);

        } else {
            throw new Exception();
        }

        return updatedComment;
    }

    @Override
    public void deleteComment(Long id) throws Exception {
        Optional<Comment> selectedComment = commentRepository.findById(id);

        if (selectedComment.isPresent()) {
            Comment comment = selectedComment.get();

            commentRepository.delete(comment);
        } else {
            throw new Exception();
        }
    }
}
