package com.example.myounghoosite.data.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String username;

    //cascade 특성: 삭제/업데이트 시 연속효과가 적용되는 방법지정.
    //mappedBy="user" Board 클래스의 user가 이 관계의 기본키임
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Board> boards;

    @Column(nullable = false)
    private String password;
    private LocalDateTime regDate;
    private LocalDateTime chgDate;
}
