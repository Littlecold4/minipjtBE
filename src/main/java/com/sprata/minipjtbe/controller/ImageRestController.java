//package com.sprata.minipjtbe.controller;
//
//import com.sprata.minipjtbe.dto.ImageRequestDto;
//import com.sprata.minipjtbe.service.ImageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//
//@RestController
//public class ImageRestController {
//    private final ImageService imageService;
//
//    @Autowired
//    public ImageRestController(ImageService imageService){
//        this.imageService = imageService;
//    }
//
//    // 사진 등록
//    @PostMapping("/api/board/photo")
//    public void upload(@RequestBody ImageRequestDto imageRequestDto) throws IOException {
//        imageService.upload(imageRequestDto, "static");
//    }
//
//    // 사진 삭제
//    @DeleteMapping("/api/board/photo/{imageid}")
//    public void deleteImage(@PathVariable Long imageid){
//        imageService.deleteFile(imageid);
//    }
//
//}