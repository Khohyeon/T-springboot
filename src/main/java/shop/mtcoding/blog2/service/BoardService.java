package shop.mtcoding.blog2.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.mtcoding.blog2.dto.board.BoardReq.BoardSaveReqDto;
import shop.mtcoding.blog2.model.BoardRepository;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private HttpSession session;

    public void 글쓰기(BoardSaveReqDto boardSaveReqDto) {
        boardRepository.insert(boardSaveReqDto.getTitle(), boardSaveReqDto.getContent());
    }
}
