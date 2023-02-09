package shop.mtcoding.blog2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blog2.dto.board.BoardReq.BoardSaveReqDto;
import shop.mtcoding.blog2.model.BoardRepository;
import shop.mtcoding.blog2.service.BoardService;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping({ "/", "/board" })
    public String main() {
        return "board/main";
    }

    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }

    @PostMapping("/board")
    public String save(BoardSaveReqDto boardSaveReqDto) {
        boardService.글쓰기(boardSaveReqDto);
        return "redirect:/board";
    }

    @GetMapping("/detail")
    public String detail() {
        return "board/detail";
    }

    @GetMapping("board/updateForm")
    public String updateForm() {
        return "board/updateForm";
    }

    @GetMapping("board/writeForm")
    public String writeForm() {
        return "board/writeForm";
    }

}
