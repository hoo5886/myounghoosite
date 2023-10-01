package com.example.myounghoosite.service.impl;

import com.example.myounghoosite.data.dao.BoardDao;
import com.example.myounghoosite.data.dto.BoardDto;
import com.example.myounghoosite.data.entity.Board;
import com.example.myounghoosite.service.BoardService;

import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final Logger LOGGER = LoggerFactory.getLogger(BoardServiceImpl.class);
    private final BoardDao boardDao;

    @Override
    public BoardDto getBoard(Long boardId) {
        LOGGER.info("[getBoard] input boardId : {}", boardId);
        Optional<Board> board = Optional.of(boardDao.selectBoard(boardId).get());

        LOGGER.info("[getBoard] boardId : {}, board title : {}",
            board.get().getBoardId(), board.get().getTitle());
        BoardDto response = BoardDto
                            .builder()
                            .boardId(board.get().getBoardId())
                            .title(board.get().getTitle())
                            .content(board.get().getContent())
                            .boardType(board.get().getBoardType())
                            .regDate(board.get().getRegDate())
                            .chgDate(board.get().getChgDate())
                            .build();
        return response;
    }

    @Override
    public BoardDto saveBoard(BoardDto boardDto) {
        LOGGER.info("[saveBoard] boardDto : {}", boardDto.toString());
        Board board = Board.builder()
            .title(boardDto.getTitle())
            .content(boardDto.getContent())
            .boardType(boardDto.getBoardType())
            .regDate(boardDto.getRegDate())
            .chgDate(boardDto.getChgDate())
            .build();

        Board savedBoard = boardDao.insertBoard(board);
        LOGGER.info("[savedBoard] savedBoard : {}", savedBoard);

        BoardDto response = BoardDto.builder()
            .boardId(savedBoard.getBoardId())
            .title(savedBoard.getTitle())
            .content(savedBoard.getContent())
            .boardType(savedBoard.getBoardType())
            .regDate(savedBoard.getRegDate())
            .chgDate(savedBoard.getChgDate())
            .build();

        return response;
    }

    @Override
    public BoardDto updateBoard(Long boardId, BoardDto boardDto) throws Exception {
        Board changedBoard = boardDao.updateBoard(boardId, boardDto);

        BoardDto response = BoardDto
            .builder()
            .boardId(changedBoard.getBoardId())
            .title(changedBoard.getTitle())
            .content(changedBoard.getContent())
            .boardType(changedBoard.getBoardType())
            .chgDate(LocalDateTime.now())
            .build();

        return response;
    }

    @Override
    public void deleteBoard(Long boardId) throws Exception {
        boardDao.deleteBoard(boardId);
    }
}
