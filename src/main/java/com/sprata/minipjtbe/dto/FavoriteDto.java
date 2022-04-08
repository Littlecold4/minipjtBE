package com.sprata.minipjtbe.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
public class FavoriteDto {
    private Long userId;
    private Long boardId;
}
