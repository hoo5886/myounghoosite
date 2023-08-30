package com.example.myounghoosite.data.repository;

import com.example.myounghoosite.data.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
