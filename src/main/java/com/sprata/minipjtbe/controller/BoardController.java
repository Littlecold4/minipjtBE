package com.sprata.minipjtbe.controller;

import com.sprata.minipjtbe.dto.BoardDto;
import com.sprata.minipjtbe.dto.BoardsDto;
import com.sprata.minipjtbe.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    //게시글 작성하기
    @PostMapping("/api/board/regist")
    public void registBoard(@RequestBody BoardDto boardDto){
        System.out.println(boardDto);
        boardService.registBoard(boardDto);
    }

    //전체 게시글 조회
    @GetMapping("/api/board")
    public List<BoardsDto> showAllBoard(){
        return boardService.showAllBoard();
    }

    //게시글 수정
    @PutMapping("/api/board/{boardid}")
    public void updateBoard(@PathVariable Long boardid, @RequestBody BoardDto boardDto) {
        boardService.updateBoard(boardid, boardDto);
    }

    //게시글 삭제
    @DeleteMapping("/api/board/{boardid}")
    public void deleteBoard(@PathVariable Long boardid){
        boardService.deleteBoard(boardid);
    }

    //내가 작성한 게시글 조회
    @GetMapping("/api/board/myboard/{userid}")
    public List<BoardsDto> showMyBoard(@PathVariable Long userid){
        return boardService.showMyBoard(userid);
    }

    //내가 좋아요한 게시글 조회
    @GetMapping("/api/board/favoriteboard/{userid}")
    public List<BoardsDto> showFavoriteBoard(@PathVariable Long userid){
        return boardService.showFavoriteBoard(userid);
    }

    //상세페이지
    @GetMapping("/api/board/detail/{boardid}")
    public BoardsDto showBoardDetail(@PathVariable Long boardid){
        return boardService.showBoardDetail(boardid);
    }
}
