package com.sprata.minipjtbe.repository;

import com.sprata.minipjtbe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserEmail(String userEmail);

    Optional<User> findByNickname(String nickname);
}
