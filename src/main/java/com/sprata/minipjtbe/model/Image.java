package com.sprata.minipjtbe.model;

import com.sprata.minipjtbe.dto.ImageDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Image {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long boardId;

    @Column(nullable = false)
    private String fileUrl;

    @Column(nullable = false)
    private String fileName;

    public Image(ImageDto imageDto){
        this.boardId = imageDto.getBoardId();
        this.fileUrl = imageDto.getFileUrl();
        this.fileName = imageDto.getFileName();
    }
}
