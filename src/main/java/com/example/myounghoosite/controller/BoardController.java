package com.example.myounghoosite.controller;

import com.example.myounghoosite.data.dto.BoardChangeDto;
import com.example.myounghoosite.data.dto.BoardDto;
import com.example.myounghoosite.data.dto.BoardResponseDto;
import com.example.myounghoosite.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    /**
     * 컨트롤러는 요청과 응답을 전달하는 역할.
     */
    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<BoardResponseDto> getBoard(Long boardId) {
        BoardResponseDto boardResponseDto = boardService.getBoard(boardId);

        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @PostMapping()
    public ResponseEntity<BoardResponseDto> createBoard(@RequestBody BoardDto boardDto) {
        BoardResponseDto boardResponseDto = boardService.saveBoard(boardDto);

        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @PutMapping()
    public ResponseEntity<BoardResponseDto> changeBoard(@RequestBody BoardChangeDto changeDto) throws Exception {
        BoardResponseDto boardResponseDto = boardService.changeBoard(changeDto.getBoardId(), changeDto);

        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteBoard(Long boardId) throws Exception {
        boardService.deleteBoard(boardId);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}
