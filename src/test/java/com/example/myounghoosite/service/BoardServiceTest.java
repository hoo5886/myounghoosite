//package com.example.myounghoosite.service;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.AdditionalAnswers.returnsFirstArg;
//
//import com.example.myounghoosite.data.dao.BoardDao;
//import com.example.myounghoosite.data.dto.BoardDto;
//import com.example.myounghoosite.data.dto.BoardResponseDto;
//import com.example.myounghoosite.data.entity.Board;
//import com.example.myounghoosite.service.impl.BoardServiceImpl;
//import java.time.LocalDateTime;
//import java.util.Optional;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//public class BoardServiceTest {
//
//    private BoardDao boardDao = Mockito.mock(BoardDao.class);
//    private BoardServiceImpl boardService;
//
//    private static LocalDateTime t = LocalDateTime.of(2023, 9, 02, 17, 30);
//    private static LocalDateTime chgT = LocalDateTime.of(2023, 9, 02, 18, 30);
//
//    @BeforeEach
//    public void setUpTest() {
//        boardService = new BoardServiceImpl(boardDao);
//    }
//
//    @Test
//    void getBoardTest() {
//        Board givenBoard = Board.builder()
//            .boardId(123L)
//            .title("title")
//            .content("content")
//            .boardType("boardType")
//            .regDate(t)
//            .chgDate(chgT)
//            .build();
//
//        Mockito.when(boardDao.selectBoard(123L))
//            .thenReturn(Optional.of(givenBoard));
//
//        BoardResponseDto boardResponseDto = boardService.getBoard(123L);
//
//        Assertions.assertEquals(boardResponseDto.getBoardId(), givenBoard.getBoardId());
//        Assertions.assertEquals(boardResponseDto.getTitle(), givenBoard.getTitle());
//        Assertions.assertEquals(boardResponseDto.getContent(), givenBoard.getContent());
//        Assertions.assertEquals(boardResponseDto.getRegDate(), givenBoard.getRegDate());
//        Assertions.assertEquals(boardResponseDto.getChgDate(), givenBoard.getChgDate());
//
//        Mockito.verify(boardDao).selectBoard(123L);
//    }
//
//    @Test
//    void saveBoardTest() {
//        Mockito.when(boardDao.insertBoard(any(Board.class)))
//            .then(returnsFirstArg());
//
//        BoardResponseDto boardResponseDto = boardService.saveBoard(
//            new BoardDto("title", "content", "boardType", t, chgT)
//        );
//
//        Assertions.assertEquals(boardResponseDto.getTitle(), "title");
//        Assertions.assertEquals(boardResponseDto.getContent(), "content");
//        Assertions.assertEquals(boardResponseDto.getBoardType(), "boardType");
//        Assertions.assertEquals(boardResponseDto.getRegDate(), t);
//        Assertions.assertEquals(boardResponseDto.getChgDate(), chgT);
//
//        Mockito.verify(boardDao).insertBoard(any());
//    }
//}
