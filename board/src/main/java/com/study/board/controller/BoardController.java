package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String boardwritepro(Board board, Model model){
        model.addAttribute("message","글 작성이 완료되었습니다");
        model.addAttribute("searchUrl","/board/list");
        boardService.write(board);
        return "message";
    }
    @PostMapping("/board/modifypro")
    public String boarmodifypro(Board board, Model model){
        model.addAttribute("message","글 수정이 완료되었습니다");
        model.addAttribute("searchUrl","/board/list");
        boardService.write(board);
        return "modify";
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

    @GetMapping("/board/delete")
    public String boardDelete(int id){
        boardService.boardDelete(id);
        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") int id,Model model) {

        model.addAttribute(boardService.boardView(id));
        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") int id, Board board){
        Board temp = boardService.boardView(id);
        temp.setTitle(board.getTitle());
        temp.setContent(board.getContent());

        boardService.write(temp);
        return "redirect:/board/list";
    }
}
