package com.sprata.minipjtbe.controller;

import com.sprata.minipjtbe.dto.CommentRequestDto;
import com.sprata.minipjtbe.dto.CommentResponseDto;
import com.sprata.minipjtbe.repository.CommentRepository;
import com.sprata.minipjtbe.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    //댓글 입력
    @PostMapping("/api/comment/regist")
    public void registComment (@RequestBody CommentRequestDto commentRequestDto){
        commentService.registComment(commentRequestDto);
    }

    //댓글 조회
    @GetMapping("/api/comment/{boardid}")
    public List<CommentResponseDto> getComment(@PathVariable Long boardid){
        return commentService.getComment(boardid);
    }

    //댓글 수정
    @PutMapping("/api/comment/{commentid}")
    public Long updateComment(@PathVariable Long commentid, @RequestBody CommentRequestDto commentRequestDto){
        commentService.update(commentid,commentRequestDto);
        return commentid;
    }

    //댓글 삭제
    @DeleteMapping("/api/comment/{commentid}")
    public Long deleteComment(@PathVariable Long commentid){
        commentRepository.deleteById(commentid);
        return commentid;
    }
}
