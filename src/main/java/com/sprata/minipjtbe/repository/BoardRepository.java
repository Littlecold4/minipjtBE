package com.sprata.minipjtbe.repository;

import com.sprata.minipjtbe.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
    Board findBoardById(Long id);
    List<Board> findAllByUserId(Long userId);
}
