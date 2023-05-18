package com.sangyunpark.board.controller;

import com.sangyunpark.board.entity.Board;
import com.sangyunpark.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

    @Autowired // 의존성 주입
    private BoardService boardService;

    @GetMapping("/board/write")
    public String boardWriteForm(){
        return "boardwrite";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {

        model.addAttribute("list", boardService.boardList()); // model로 view에 전달

        return "boardlist";
    }

    @GetMapping("/board/detail")
    public String boardDetail(Model model, Integer id){

        model.addAttribute("board", boardService.boardView(id).get());

        return "boarddetail";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Model model, Integer id){

        boardService.delete(id); // 게시물 삭제
        return "redirect:/board/list";
    }


    @PostMapping(value = "/board/write")
    public String boardWrite(Board board){

        boardService.write(board);

        return "";
    }

}
