package com.sprata.minipjtbe.service;

import com.sprata.minipjtbe.dto.FavoriteDto;
import com.sprata.minipjtbe.model.Favorite;
import com.sprata.minipjtbe.repository.BoardRepository;
import com.sprata.minipjtbe.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;

    //좋아요
    public void pressFavorite(FavoriteDto favoriteDto){
        Favorite favorite = new Favorite(favoriteDto);
        if(favoriteRepository.findByBoardIdAndUserId(favoriteDto.getBoardId(), favoriteDto.getUserId()).isPresent()) {
            throw new IllegalArgumentException("좋아요가 이미 눌러진 상태입니다.");
        }
        favoriteRepository.save(favorite);
    }

    //좋아요 취소
    public void unpressFavorite(FavoriteDto favoriteDto){
        Long userId = favoriteDto.getUserId();
        Long boardId = favoriteDto.getBoardId();
        Optional<Favorite> favorite = favoriteRepository.findByBoardIdAndUserId(boardId,userId);
        if (favorite.isPresent()){
            favoriteRepository.deleteById(favorite.get().getId());
        }
        else{
            throw new IllegalArgumentException("이미 좋아요가 취소된 상태입니다.");
        }
    }
}
