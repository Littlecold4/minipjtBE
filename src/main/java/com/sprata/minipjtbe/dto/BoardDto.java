package com.sprata.minipjtbe.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
    Long id;
    private String title;
    private String content;
    private Long userId;
    private String headinfo;
    private String topinfo;
    private String bottominfo;
    private String shoesinfo;
}
