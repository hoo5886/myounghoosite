package com.example.myounghoosite.controller;

import com.example.myounghoosite.config.GsonLocalDateTimeAdapter;
import com.google.gson.Gson;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.example.myounghoosite.data.dto.BoardDto;
import com.example.myounghoosite.data.dto.BoardResponseDto;
import com.example.myounghoosite.service.impl.BoardServiceImpl;
import com.google.gson.GsonBuilder;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BoardController.class)
public class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BoardServiceImpl boardService;

    private static LocalDateTime t = LocalDateTime.of(2023, 9, 02, 17, 30);
    private static LocalDateTime chgT = LocalDateTime.of(2023, 9, 02, 18, 30);

    @Test
    @DisplayName("MockMvc를 통한 Board 데이터 가져오기 테스트")
    void getBoardTest() throws Exception {

        given(boardService.getBoard(123L)).willReturn(
            new BoardResponseDto(123L, "title", "content", "common", t, t)
        );

        String boardId = "123";

        mockMvc.perform(
            get("/board?boardId=" + boardId))
            .andExpect(status().isOk())
            .andExpect(jsonPath(
                "$.boardId").exists())
            .andExpect(jsonPath("$.title").exists())
            .andExpect(jsonPath("$.content").exists())
            .andExpect(jsonPath("$.boardType").exists())
            .andExpect(jsonPath("$.regDate").exists())
            .andDo(print());

        verify(boardService).getBoard(123L);
    }

    @Test
    @DisplayName("Board 데이터 생성 테스트")
    void createBoardTest() throws Exception {

        given(boardService.saveBoard(any()))
            .willReturn(new BoardResponseDto(123L, "title", "content", "boardType", t, t));

        BoardDto boardDto = BoardDto.builder()
            .title("title")
            .content("content")
            .boardType("boardType")
            .regDate(t)
            .chgDate(t)
            .build();

        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTimeAdapter())
            .registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTimeAdapter()).create();
        String content = gson.toJson(boardDto);

        /**
         * mockMvc.perform()
         * 서버로 URL 요청을 보내는 것처럼 통신 테스트 코드를 작성해서 컨트롤러를 테스트할 수 있습니다.
         */

        mockMvc.perform(
                post("/board")
                    .content(content)
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.boardId").value(123L))
            .andExpect(jsonPath("$.title").value("title"))
            .andExpect(jsonPath("$.content").value("content"))
            .andExpect(jsonPath("$.boardType").value("boardType"))
            .andExpect(jsonPath("$.regDate").value("2023-09-02T17:30:00"))
            .andExpect(jsonPath("$.chgDate").value("2023-09-02T17:30:00"))
            .andDo(print());

        verify(boardService).saveBoard(refEq(boardDto));
    }
}
