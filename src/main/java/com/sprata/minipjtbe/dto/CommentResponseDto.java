package com.sprata.minipjtbe.dto;

import com.sprata.minipjtbe.model.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private Long userId;
    private UserInfoDto userInfo;
    private Long boardId;
    private String comment;


    public CommentResponseDto(Comment comment, UserInfoDto userInfo) {
        this.userInfo = userInfo;
        this.boardId = comment.getBoardId();
        this.comment = comment.getComment();

    }

}
