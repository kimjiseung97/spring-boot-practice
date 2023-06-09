package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    //게시글 저장처리
    @Autowired
    private BoardRepository boardRepository;
    public void write(Board board){
        boardRepository.save(board);
    }

    //게시글 리스트 처리
    public List<Board> list(){
        return boardRepository.findAll();
    }

    //특정 글 상세조회
    public Board boardView(int id){

        return boardRepository.findById(id).get();
    }

    //특정 게시글을 삭제
    public void boardDelete(int id){

        boardRepository.deleteById(id);
    }
}
