package com.example.myounghoosite.service;

import com.example.myounghoosite.data.dto.BoardChangeDto;
import com.example.myounghoosite.data.dto.BoardDto;
import com.example.myounghoosite.data.dto.BoardResponseDto;

public interface BoardService {

    BoardResponseDto getBoard(Long boardId);
    BoardResponseDto saveBoard(BoardDto boardDto);
    BoardResponseDto changeBoard(Long boardId, BoardChangeDto changeDto) throws Exception;
    void deleteBoard(Long boardId) throws Exception;
}
