package shop.mtcoding.blog2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.mtcoding.blog2.dto.user.UserReq.JoinReqDto;
import shop.mtcoding.blog2.model.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void 회원가입(JoinReqDto joinReqDto) {
        int result = userRepository.insert(joinReqDto.getUsername(), joinReqDto.getPassword(), joinReqDto.getEmail());

    }

}