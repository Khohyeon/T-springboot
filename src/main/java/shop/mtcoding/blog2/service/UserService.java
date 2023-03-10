package shop.mtcoding.blog2.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.mtcoding.blog2.dto.user.UserReq.JoinReqDto;
import shop.mtcoding.blog2.dto.user.UserReq.LoginReqDto;
import shop.mtcoding.blog2.handler.ex.CustomException;
import shop.mtcoding.blog2.model.User;
import shop.mtcoding.blog2.model.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpSession session;

    public void 회원가입(JoinReqDto joinReqDto) {
        User sameUser = userRepository.findByUsername(joinReqDto.getUsername());
        if (sameUser != null) {
            throw new CustomException("동일한 username이 존재합니다");
        }
        int result = userRepository.insert(joinReqDto.getUsername(), joinReqDto.getPassword(), joinReqDto.getEmail());
        if (result != 1) {
            throw new CustomException("회원가입에 실패 하셨습니다.");
        }
    }

    public void 로그인(LoginReqDto loginReqDto) {
        User principal = userRepository.findByIdAndPassword(loginReqDto.getUsername(), loginReqDto.getPassword());
        session.setAttribute("principal", principal);

        if (principal == null) {
            throw new CustomException("유저네임 혹은 패스워드가 잘못 입력되었습니다");
        }
    }

}