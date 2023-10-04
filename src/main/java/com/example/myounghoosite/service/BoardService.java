package com.example.myounghoosite.service;

import com.example.myounghoosite.data.dto.BoardDto;
import java.util.List;

public interface BoardService {

    List<BoardDto> getBoards();
    BoardDto getBoard(Long boardId);
    BoardDto saveBoard(BoardDto boardDto);
    BoardDto updateBoard(Long boardId, BoardDto changeDto) throws Exception;
    void deleteBoard(Long boardId) throws Exception;
}
