package com.bounce.submore.user.service;

import com.bounce.submore.user.domain.User;
import com.bounce.submore.user.repository.UserRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByLoginId(String loginId) {
        return userRepository.selectByLoginId(loginId);
    }

    public User getUserById(@Param("id") long id) {
        return userRepository.selectByUserId(id);
    }



}
