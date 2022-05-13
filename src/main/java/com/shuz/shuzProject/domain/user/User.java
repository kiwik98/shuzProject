package com.shuz.shuzProject.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@ToString
@Getter
@NoArgsConstructor
@DynamicInsert // insert하지않은 값을 쿼리문에서 빼는 역할(DDL상에 role필드의 default = 'user'인데 이 어노테이션이 없으면 null로 들어감)

@Entity
@Table(name ="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;
    private String userId;
    private String password;
    private char gender;
    private String role; //일반유저는 null/관리자는 admin


    @Builder
    public User(Long userNo, String userId, String password, char gender, String role) {
        this.userNo = userNo;
        this.userId = userId;
        this.password = password;
        this.gender = gender;
        this.role = role;
    }
}