package com.example.myounghoosite.data.dao.impl;

import com.example.myounghoosite.data.dao.BoardDao;
import com.example.myounghoosite.data.dto.BoardChangeDto;
import com.example.myounghoosite.data.entity.Board;
import com.example.myounghoosite.data.repository.BoardRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoardDaoImpl implements BoardDao {

    private final BoardRepository boardRepository;

    @Override
    public Board insertBoard(Board board) {
        Board savedBoard = boardRepository.save(board);

        return savedBoard;
    }

    @Override
    public Optional<Board> selectBoard(Long id) {
        Optional<Board> selectedBoard = Optional.of(boardRepository.getById(id));

        return selectedBoard;
    }

    @Override
    public Board updateBoard(Long id, BoardChangeDto changeDtoDto) throws Exception {
        Optional<Board> selectedBoard = boardRepository.findById(id);

        Board updatedBoard;
        if (selectedBoard.isPresent()) {
            Board board = selectedBoard.get();

            board.setTitle(changeDtoDto.getTitle());
            board.setContent(changeDtoDto.getContent());
            board.setChgDate(LocalDateTime.now());

            updatedBoard = boardRepository.save(board);
        } else {
            throw new Exception();
        }

        return updatedBoard;
    }

    @Override
    public void deleteBoard(Long id) throws Exception {
        Optional<Board> selectedBoard = boardRepository.findById(id);

        if (selectedBoard.isPresent()) {
            Board board = selectedBoard.get();

            boardRepository.delete(board);
        } else {
            throw new Exception();
        }

    }
}
