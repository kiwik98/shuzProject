package com.shuz.shuzProject.service.user;

import com.shuz.shuzProject.domain.user.User;
import com.shuz.shuzProject.domain.user.UserRepository;
import com.shuz.shuzProject.web.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    //회원가입
    public void save(UserInfoDto dto) {
        userRepository.save(User.builder()
                .userId(dto.getId())
                .password(dto.getPassword())
                .gender(dto.getGender()).build());
    }

    //로그인
    public User findByUserId(String id) {return userRepository.findByUserId(id);}
}
