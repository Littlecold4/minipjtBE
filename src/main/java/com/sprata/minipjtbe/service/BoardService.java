package com.sprata.minipjtbe.service;

import com.sprata.minipjtbe.dto.BoardDto;
import com.sprata.minipjtbe.dto.BoardsDto;
import com.sprata.minipjtbe.model.Board;
import com.sprata.minipjtbe.model.Favorite;
import com.sprata.minipjtbe.repository.BoardRepository;
import com.sprata.minipjtbe.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final FavoriteRepository favoriteRepository;

    public void registBoard(BoardDto boardDto){
        Board board = new Board(boardDto);
        boardRepository.save(board);
    }

    public List<BoardsDto> showAllBoard(){
        List<Board> boardList= boardRepository.findAll();
        List<BoardsDto> boardsList = new ArrayList<>();
        for (Board board : boardList) {
            int like = favoriteRepository.countAllByBoardId(board.getId());
            BoardsDto boardsDto = new BoardsDto(board, like, 0);
            boardsList.add(boardsDto);
        }
        return boardsList;
    }

    public void updateBoard(Long id,BoardDto boardDto){
        Board board = boardRepository.findBoardById(id);
        board.update(boardDto);
        boardRepository.save(board);
    }

    public void deleteBoard(Long id){
        boardRepository.deleteById(id);
    }

    public List<BoardsDto> showMyBoard(Long userId){
        List<Board> boardList= boardRepository.findAllByUserId(userId);
        List<BoardsDto> boardsList = new ArrayList<>();
        for (Board board : boardList) {
            int like = favoriteRepository.countAllByBoardId(board.getId());
            BoardsDto boardsDto = new BoardsDto(board, like, 0);
            boardsList.add(boardsDto);
        }
        return boardsList;
    }

    public List<BoardsDto> showFavoriteBoard(Long userId){
        List<Favorite> favoriteList =favoriteRepository.findAllByUserId(userId);
        List<BoardsDto> boardsList = new ArrayList<>();
        for(Favorite favorite : favoriteList){
            Board board = boardRepository.findBoardById(favorite.getBoardId());
            int like = favoriteRepository.countAllByBoardId(board.getId());
            BoardsDto boardsDto = new BoardsDto(board, like, 0);
            boardsList.add(boardsDto);
        }
        return  boardsList;
    }

    public  BoardsDto showBoardDetail(Long boardid){
        Board board = boardRepository.findBoardById(boardid);
        int like = favoriteRepository.countAllByBoardId(board.getId());
        return new BoardsDto(board,like,0);
    }
}
