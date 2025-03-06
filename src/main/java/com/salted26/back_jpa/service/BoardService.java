package com.salted26.back_jpa.service;

import com.salted26.back_jpa.dto.BoardDTO;
import com.salted26.back_jpa.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

import java.util.List;

public interface BoardService {

  List<Board> getAllBoards();

  Page<Board> getAllPagination(int page, int pageSize, String searchKeyword);


  Page<Board> getAllBoardsWithPagination(int offset, int pageSize, String field);

  BoardDTO getBoardByNo(Long no);

  void saveBoard(BoardDTO boardDTO);

  void updateBoard(Long no, BoardDTO boardDTO);

  void deleteBoard(Long no);


}
