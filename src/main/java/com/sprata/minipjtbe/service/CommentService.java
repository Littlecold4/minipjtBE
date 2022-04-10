package com.sprata.minipjtbe.service;

import com.sprata.minipjtbe.dto.CommentRequestDto;
import com.sprata.minipjtbe.dto.CommentResponseDto;
import com.sprata.minipjtbe.dto.UserInfoDto;
import com.sprata.minipjtbe.model.Comment;
import com.sprata.minipjtbe.model.User;
import com.sprata.minipjtbe.repository.CommentRepository;
import com.sprata.minipjtbe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    //댓글 조회
    public List<CommentResponseDto> getComment(Long boardId){
        List<Comment> commentList = commentRepository.findAllByBoardId(boardId);
        List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();
        for(Comment comment : commentList){
            User user= userRepository.findById(comment.getUserId()).orElseThrow(
                    () -> new IllegalArgumentException("not found")
                    );
            UserInfoDto userInfoDto = new UserInfoDto();
            userInfoDto.setNickname(user.getNickname());
            userInfoDto.setUsername(user.getUsername());
            CommentResponseDto commentResponseDto = new CommentResponseDto(comment, userInfoDto);
            commentResponseDtoList.add(commentResponseDto);
        }
        return commentResponseDtoList;
    }

    //댓글 등록
    @Transactional
    public void registComment(CommentRequestDto commentRequestDto){

        //댓글 조건 1 : 빈 공백
        if(commentRequestDto.getComment() == null) {
            throw new IllegalArgumentException("댓글을 입력하세요");
        }
        //댓글 조건 2 : 로그인 안 됐을 시
//        if(commentRequestDto.getUserId() == null) {
//            throw new IllegalArgumentException("로그인이 필요합니다")
//        }
        //xss필터 써야하는지?
        Comment comment = new Comment(commentRequestDto);
        commentRepository.save(comment);

    }

    //댓글 수정
    @Transactional
    public void update(Long commentid, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(commentid).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않습니다.")
        );
        comment.update(commentRequestDto);
    }
}
