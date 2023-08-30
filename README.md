# myounghoosite
개인적으로 운영할 소규모 블로그를 제작합니다.

# 개인용 웹사이트 만들기

# I. Overview

- 개인 블로그용으로 쓸 웹사이트 개발.
- 꾸준한 관리와 업데이트 필요.
- 기본적인 MVC 아키텍처를 사용.

## 1. 구현 기능

- **글** 조회/추가/수정/삭제
    - 삭제의 경우 DB에서 지워지지 않고, 클라이언트 내에서만 안보이게 구현
- **댓글**, 대댓글
    - 댓글, 대댓글에 `좋아요` `싫어요` 기능
- **조회수, 좋아요, 싫어요** 등 통계데이터를 위한 유저 정보 삽입.
- 좋아요, 싫어요 클릭한 경우, 알림기능
    - 댓글이 등록된 경우, 게시글에 좋아요가 추가된 경우, 댓글에 좋앙
- 스프링 시큐리티를 활용한 Authentication & Authorization
    - 좋아요, 댓글, 대댓글은 회원가입자만 가능.
    - 익명 사용자는 읽기만 가능.
- 내용, 제목을 통한 검색기능 (with Redis)

## 2. 구현 모듈

- 내가 읽은 책들을 기록할 페이지.
    - 추천과 비추천. 소감. 읽은 날짜
- 통계 데이터 툴 개발 (ㅋㅋ)
- [텍스트 에디터(ㅋㅋ)](https://www.ego-cms.com/post/10-best-text-editors-for-web-developers)
    - 텍스트 에디터 세련되게 구현하기.
        
        툴팁, 미주, 각주 등을 스크롤링없이 한번에 확인할 수 있게?
        

# II. Specification

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/05e375fa-b6ed-4991-bc5c-b5d301fdaf95/Untitled.png)

**FrontEnd**: `React`, `JavaScript`

**BackEnd**: `Java`, `SpringBoot`, `SpringSecurity`, `Spring Data JPA`

**DB**: `mysql`

## 1. mysql

**userID**: `mhksite`

**DB**: `mhsite_db`

**DBpassword**: `aptx4896`

# III. What I’ve learn during developing it

## 1. Difference the two things (DTO vs VO)

### Key insights

- 💡 The terms DTO and VO are often used interchangeably, causing confusion, but DTO is specifically for data transfer and VO is for value expression.
- 🧺 DTO is an object used to pass data between layers, with the sole purpose of containing and transmitting data, without any additional logic.
- 🤔 The DTO (Data Transfer Object) class in programming should only have getters and setters, without any other logic methods.
- 🔄 DTOs can be made more stable and secure by removing setter methods and initializing property values through the constructor, ensuring data immutability during the delivery process.
- 💡 Using an Entity class to pass request or response values can lead to complications and the need for frequent changes, whereas using a DTO allows for more flexibility and easier adaptation to changes in the view.
- 💰 The concept of Value Object (VO) is similar to how we perceive currency - we don't differentiate between bills with different serial numbers, but see them as the same value.
- 💡 Unlike DTOs, which cannot contain logic other than getter and setter methods, VO (Value Object) can contain additional logic.
- 🔄 A DTO is not considered the same if all property values are the same, but a VO is considered the same if all property values are the same.

*Summary for: https://youtu.be/z5fUkck_RZM by [Eightify](https://www.eightify.app/)*

## 2. Software architecture Pattern

https://mingrammer.com/translation-10-common-software-architectural-patterns-in-a-nutshell/
