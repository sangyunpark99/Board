package com.sangyunpark.board.service;

import com.sangyunpark.board.entity.Board;
import com.sangyunpark.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    @Autowired
    public void BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public void write(Board board){ // JPA 사용
        boardRepository.save(board);
    }

    public List<Board> boardList(){
        return boardRepository.findAll();
    }

    public Optional<Board> boardView(Integer id){
        return boardRepository.findById(id);
    }
}
