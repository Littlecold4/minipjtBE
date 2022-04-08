package com.sprata.minipjtbe.dto;

import com.sprata.minipjtbe.model.Board;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class BoardsDto {
    private Long boardId;
    private Long userId;
    private String title;
    private String content;
    private int like;
    private int userinfo;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public BoardsDto(Board board,int like, int userinfo){
        this.boardId= board.getId();
        this.title= board.getTitle();
        this.content = board.getContent();
        this.userId = board.getUserId();
        this.like = like;
        this.userinfo = userinfo;
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }
}
