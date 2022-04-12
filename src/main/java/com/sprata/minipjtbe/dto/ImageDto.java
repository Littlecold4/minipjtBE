package com.sprata.minipjtbe.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageDto {
    private Long id;
    private Long boardId;
    private String fileUrl;
    private String fileName;

    public ImageDto(String fileName, String fileUrl){
        this.fileUrl = fileUrl;
        this.fileName = fileName;
    }
}
