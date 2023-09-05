package com.example.myounghoosite.data.dao;

import com.example.myounghoosite.data.dto.BoardChangeDto;
import com.example.myounghoosite.data.entity.Board;
import java.util.Optional;

public interface BoardDao {

    Board insertBoard(Board board);
    Optional<Board> selectBoard(Long id);
    Board updateBoard(Long id, BoardChangeDto changeDtoDto) throws Exception;

    void deleteBoard(Long id) throws Exception;
}
