package com.example.myounghoosite.data.repository;

import com.example.myounghoosite.data.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
