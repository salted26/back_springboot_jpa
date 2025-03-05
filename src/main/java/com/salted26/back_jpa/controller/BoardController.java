package com.salted26.back_jpa.controller;

import com.salted26.back_jpa.dto.BoardDTO;
import com.salted26.back_jpa.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/board")
@AllArgsConstructor
public class BoardController {

  private BoardService boardService;

  @GetMapping("")
  public ResponseEntity<List<BoardDTO>> getAllBoards() {
    List<BoardDTO> boardList = boardService.getAllBoards();
    return ResponseEntity.ok(boardList);
  }

  // build Get Board REST API
  @GetMapping("/{no}")
  public ResponseEntity<BoardDTO> getBoardByNo(@PathVariable("no") Long no) {
    BoardDTO board = boardService.getBoardByNo(no);
    return ResponseEntity.ok(board);
  }

  @PostMapping("/write")
  public ResponseEntity<?> save(@RequestBody BoardDTO boardDTO) {
    boardService.saveBoard(boardDTO);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/update/{no}")
  public ResponseEntity<BoardDTO> updatePage(@PathVariable("no") Long no, @RequestBody BoardDTO boardDTO) {
    BoardDTO board = boardService.getBoardByNo(no);
    return ResponseEntity.ok(board);
  }

  @PutMapping("/update/{no}")
  @Transactional
  public ResponseEntity<?> update(@PathVariable("no") Long no, @RequestBody BoardDTO boardDTO) {
    boardService.updateBoard(no, boardDTO);
    return ResponseEntity.ok().build();
  }

}
