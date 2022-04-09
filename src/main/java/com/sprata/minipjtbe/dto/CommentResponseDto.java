package com.sprata.minipjtbe.dto;

import com.sprata.minipjtbe.model.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private Long userId;
    private UserInfoDto userInfo;
    private Long boardId;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public CommentResponseDto(Comment comment, UserInfoDto userInfo) {
        this.userInfo = userInfo;
        this.boardId = comment.getBoardId();
        this.comment = comment.getComment();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();

    }

}
