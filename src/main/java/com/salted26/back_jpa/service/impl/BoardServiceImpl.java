package com.salted26.back_jpa.service.impl;

import com.salted26.back_jpa.dto.BoardDTO;
import com.salted26.back_jpa.entity.Board;
import com.salted26.back_jpa.mapper.BoardMapper;
import com.salted26.back_jpa.repository.BoardRepository;
import com.salted26.back_jpa.repository.PageRepository;
import com.salted26.back_jpa.service.BoardService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardRepository boardRepository;

  @Autowired
  private PageRepository pageRepository;

  @Override
  public List<Board> getAllBoards() {
    List<Board> boardList = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "no"));
    return boardList;
  }

  @Override
  public Page<Board> getAllPagination(int page, int pageSize, String searchKeyword) {
    PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "no"));

    if(searchKeyword.isEmpty() || searchKeyword.equals("")) {
      System.out.println("null : " + searchKeyword);
      Page<Board> boardList = boardRepository.findAll(pageRequest);
      return boardList;
    } else {
      System.out.println("keyword : " + searchKeyword);
      Page<Board> boardList = pageRepository.findByTitleContaining(searchKeyword, pageRequest);
      return boardList;
    }
  }

  @Override
  public Page<Board> getAllBoardsWithPagination(int offset, int pageSize, String field) {
    Page<Board> boards = boardRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
    return boards;
  }

  @Override
  public BoardDTO getBoardByNo(Long no) {
    Board board = boardRepository.findById(no)
      .orElseThrow(()
        -> new EntityNotFoundException("Board with id " + no + " not found"));
    return BoardMapper.mapToBoardDTO(board);

  }

  @Override
  public void saveBoard(BoardDTO boardDTO) {
    BoardMapper.mapToBoardDTO(boardRepository.save(BoardMapper.mapToBoard(boardDTO)));
  }

  @Override
  public void updateBoard(Long no, BoardDTO boardDTO) {
    Board board = boardRepository.findById(no)
      .orElseThrow(() -> new EntityNotFoundException("Board with id " + no + " not found"));

    if(board != null) {
      board.setId(boardDTO.getId());
      board.setId(boardDTO.getId());
      board.setTitle(boardDTO.getTitle());
      board.setContent(boardDTO.getContent());
      board.setWriter(boardDTO.getWriter());

      boardRepository.save(board);
    }
  }

  @Override
  public void deleteBoard(Long no) {
    boardRepository.deleteById(no);
  }


}
