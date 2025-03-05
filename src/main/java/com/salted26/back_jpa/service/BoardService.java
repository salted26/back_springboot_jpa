package com.salted26.back_jpa.service;

import com.salted26.back_jpa.dto.BoardDTO;

import java.util.List;

public interface BoardService {

  BoardDTO getBoardByNo(Long no);

  List<BoardDTO> getAllBoards();

  BoardDTO saveBoard(BoardDTO boardDTO);

  void updateBoard(Long no, BoardDTO boardDTO);
}
