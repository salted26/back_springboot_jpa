package com.salted26.back_jpa.service.impl;

import com.salted26.back_jpa.dto.BoardDTO;
import com.salted26.back_jpa.entity.Board;
import com.salted26.back_jpa.mapper.BoardMapper;
import com.salted26.back_jpa.repository.BoardRepository;
import com.salted26.back_jpa.service.BoardService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardRepository boardRepository;

  @Override
  public BoardDTO getBoardByNo(Long no) {
    Board board = boardRepository.findById(no)
      .orElseThrow(()
        -> new EntityNotFoundException("Board with id " + no + " not found"));
    return BoardMapper.mapToBoardDTO(board);

  }

  @Override
  public List<BoardDTO> getAllBoards() {
    List<Board> boardList = boardRepository.findAll();
    return boardList.stream().map((board) -> BoardMapper.mapToBoardDTO(board))
      .collect(Collectors.toList());
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

}
