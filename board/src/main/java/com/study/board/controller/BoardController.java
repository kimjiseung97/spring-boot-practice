package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") //localhost:8080/board/write
    public String boardwriteform(){
        return "boardwrite";
    }


    @PostMapping("/board/writepro")
    public String boardwritepro(Board board){

        boardService.write(board);
        return "";
    }

    @GetMapping("/board/list")
    public String baordList(Model model){

        model.addAttribute("list",boardService.list());
        return "boardlist";
    }

    @GetMapping("/board/view")
    public String boardview(Model model,int id){
        model.addAttribute("board",boardService.boardView(id));
        return "boardview";
    }
}
