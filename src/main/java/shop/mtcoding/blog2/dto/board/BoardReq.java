package shop.mtcoding.blog2.dto.board;

import lombok.Getter;
import lombok.Setter;

public class BoardReq {

    @Setter
    @Getter
    public static class BoardSaveReqDto {
        private String title;
        private String content;

    }
}
