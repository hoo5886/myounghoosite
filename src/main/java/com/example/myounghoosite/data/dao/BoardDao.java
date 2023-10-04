package com.example.myounghoosite.data.dao;

import com.example.myounghoosite.data.dto.BoardDto;
import com.example.myounghoosite.data.entity.Board;
import java.util.List;
import java.util.Optional;

public interface BoardDao {

    List<Board> selectAll();
    Board insertBoard(Board board);
    Optional<Board> selectBoard(Long id);
    Board updateBoard(Long id, BoardDto changeDtoDto) throws Exception;
    void deleteBoard(Long id) throws Exception;
}
