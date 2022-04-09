package com.sprata.minipjtbe.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserInfoDto {
    private String username;
    private String nickname;

    public UserInfoDto(String username, String nickname){
        this.username = username;
        this.nickname = nickname;
    }
}
