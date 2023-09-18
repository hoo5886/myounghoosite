package com.example.myounghoosite.service;

import com.example.myounghoosite.data.dto.BoardDto;

public interface BoardService {

    BoardDto getBoard(Long boardId);
    BoardDto saveBoard(BoardDto boardDto);
    BoardDto updateBoard(Long boardId, BoardDto changeDto) throws Exception;
    void deleteBoard(Long boardId) throws Exception;
}
