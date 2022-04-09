package com.sprata.minipjtbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserInfoDto {
    private String username;
    private String nickname;

    public UserInfoDto(String username, String nickname){
        this.username = username;
        this.nickname = nickname;
    }
}
