package com.example.myounghoosite.controller;

import com.example.myounghoosite.data.dto.BoardDto;
import com.example.myounghoosite.service.BoardService;
import java.util.Arrays;
import java.util.List;
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

    @GetMapping("/hello")
    public List<String> Hello(){
        return Arrays.asList("리액트 스프링 ", "연결에 성공하였습니다.");
    }

    @GetMapping("/boardId")
    public ResponseEntity<BoardDto> getBoard(Long boardId) {
        BoardDto boardDto = boardService.getBoard(boardId);

        return ResponseEntity.status(HttpStatus.OK).body(boardDto);
    }

    @PostMapping()
    public ResponseEntity<BoardDto> createBoard(@RequestBody BoardDto boardDto) {
        BoardDto response = boardService.saveBoard(boardDto);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping()
    public ResponseEntity<BoardDto> updateBoard(@RequestBody BoardDto boardDto) throws Exception {
        BoardDto response = boardService.updateBoard(boardDto.getBoardId(), boardDto);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteBoard(Long boardId) throws Exception {
        boardService.deleteBoard(boardId);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}
