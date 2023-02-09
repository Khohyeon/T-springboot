package shop.mtcoding.blog2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blog2.dto.board.BoardReq.BoardSaveReqDto;
import shop.mtcoding.blog2.dto.board.BoardResp.BoardDetailRespDto;
import shop.mtcoding.blog2.dto.board.BoardResp.BoardMainRespDto;
import shop.mtcoding.blog2.model.BoardRepository;
import shop.mtcoding.blog2.service.BoardService;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping({ "/", "/main" })
    public String main(Model model) {
        List<BoardMainRespDto> boardList = boardRepository.findAllWithUser();
        model.addAttribute("boardList", boardList);
        return "board/main";
    }

    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }

    @PostMapping("/board")
    public String save(BoardSaveReqDto boardSaveReqDto, Model model) {
        boardService.글쓰기(boardSaveReqDto);

        return "redirect:/";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable int id, Model model) {
        BoardDetailRespDto boardDetail = boardRepository.findOneWithUser(id);
        model.addAttribute("boardDetail", boardDetail);
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
