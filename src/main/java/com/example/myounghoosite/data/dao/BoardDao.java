package com.example.myounghoosite.data.dao;

import com.example.myounghoosite.data.entity.Board;

public interface BoardDao {

    Board insertBoard(Board board);
    Board selectBoard(Long id);
    Board updateBoardTitle(Long id, String title) throws Exception;
    void deleteBoard(Long id) throws Exception;
}
