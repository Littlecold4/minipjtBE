package com.sprata.minipjtbe.service;

import com.sprata.minipjtbe.dto.IdCheckRequestDto;
import com.sprata.minipjtbe.dto.SignupRequestDto;
import com.sprata.minipjtbe.model.User;
import com.sprata.minipjtbe.repository.UserRepository;
import com.sprata.minipjtbe.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final Validator validator;
    private final PasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository, Validator validator, PasswordEncoder encoder){
        this.userRepository = userRepository;
        this.validator = validator;
        this.encoder = encoder;
    }

    // 회원가입
    public String signup(SignupRequestDto signupRequestDto) {
        String msg = "회원 가입이 완료되었습니다.";

        try {
            // 회원가입 검증
            validator.signupValidate(signupRequestDto);

        }catch (IllegalArgumentException e){
            msg = e.getMessage();
            return msg;
        }

        signupRequestDto.setPassword(encoder.encode(signupRequestDto.getPassword()));
        userRepository.save(new User(signupRequestDto));
        return msg;
    }


    public String idCheck(IdCheckRequestDto idCheckRequestDto) {
        String msg = "사용 가능한 아이디입니다.";
        try {
            // 회원가입 검증
            validator.idCheck(idCheckRequestDto);

        }catch (IllegalArgumentException e){
            msg = e.getMessage();
            return msg;
        }

        return msg;
    }
}
