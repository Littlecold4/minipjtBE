package com.sprata.minipjtbe.controller;

import com.sprata.minipjtbe.dto.FavoriteDto;
import com.sprata.minipjtbe.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FavoriteController {
    private final FavoriteService favoriteService;

    @PostMapping("/api/board/favoriteboard")
    private void pressFavorite(@RequestBody FavoriteDto favoriteDto){
        favoriteService.pressFavorite(favoriteDto);
    }

    @DeleteMapping("/api/board/favoriteboard")
    private void unpressFavorite(@RequestBody FavoriteDto favoriteDto){
        favoriteService.unpressFavorite(favoriteDto);
    }
}
