package com.sprata.minipjtbe.model;

import com.sprata.minipjtbe.dto.SignupRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String password;

    public User(SignupRequestDto requestDto){
        this.userEmail = requestDto.getUseremail();
        this.nickname = requestDto.getNickname();
        this.password = requestDto.getPassword();
    }
}
