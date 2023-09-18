//package com.example.myounghoosite.dao;
//
//import com.example.myounghoosite.data.dao.BoardDao;
//import com.example.myounghoosite.data.entity.Board;
//import com.example.myounghoosite.data.repository.BoardRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//@DataJpaTest
//public class BoardRepositoryTestByH2 {
//
//    /**
//     * DataJpaTest는 기본값으로 임베디드 DB를 사용.
//     * 다른 DB를 사용하려면 별도의 설정을 거쳐야 한다.
//     */
//
//    @Autowired
//    private BoardRepository boardRepository;
//
//    @Test
//    void saveTest() {
//        //given
//        Board board = Board.builder()
//            .title("title")
//            .content("content")
//            .boardType("boardType")
//            .build();
//
//        //when
//        Board savedBoard = boardRepository.save(board);
//
//        //then
//        Assertions.assertEquals(board.getTitle(), savedBoard.getTitle());
//        Assertions.assertEquals(board.getContent(), savedBoard.getContent());
//        Assertions.assertEquals(board.getBoardType(), savedBoard.getBoardType());
//    }
//
//    @Test
//    void selectTest() {
//        // given
//        Board board = Board.builder()
//            .title("title")
//            .content("content")
//            .boardType("boardType")
//            .build();
//
//        Board savedBoard = boardRepository.saveAndFlush(board);
//
//        // when
//        Board foundBoard = boardRepository.findById(savedBoard.getBoardId()).get();
//
//        //then
//        Assertions.assertEquals(board.getTitle(), foundBoard.getTitle());
//        Assertions.assertEquals(board.getContent(), foundBoard.getContent());
//        Assertions.assertEquals(board.getBoardType(), foundBoard.getBoardType());
//    }
//
//    @Test
//    void updateTest() {
//        // given
//        Board board = Board.builder()
//            .title("title")
//            .content("content")
//            .boardType("boardType")
//            .build();
//
//        Board savedBoard = boardRepository.save(board);
//
//        // when
//        Board foundBoard = boardRepository.findById(savedBoard.getBoardId()).get();
//        foundBoard.setTitle("updatedTitle");
//
//        Board updatedBoard = boardRepository.save(foundBoard);
//
//        //then
//        Assertions.assertEquals(board.getTitle(), "updatedTitle");
//
//    }
//
//    @Test
//    void deleteTest() {
//        // given
//        Board board = Board.builder()
//            .title("title")
//            .content("content")
//            .boardType("boardType")
//            .build();
//
//        Board savedBoard = boardRepository.saveAndFlush(board);
//
//        // when
//        boardRepository.delete(savedBoard);
//
//        //then
//        Assertions.assertFalse(boardRepository.findById(savedBoard.getBoardId()).isPresent());
//    }
//}
