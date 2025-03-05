package com.salted26.back_jpa.controller;

import com.salted26.back_jpa.dto.BoardDTO;
import com.salted26.back_jpa.entity.Board;
import com.salted26.back_jpa.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

  @Autowired
  private BoardService boardService;

  @GetMapping("")
  public ResponseEntity<Page<Board>> getAllBoards(
    @RequestParam int page, @RequestParam int pageSize) {
    Page<Board> boardList = boardService.getAllPagination(page, pageSize);
    return new ResponseEntity<>(boardList, HttpStatus.OK);
  }

  @GetMapping("/pagination/{offset}/{pageSize}/{field}")
  public ResponseEntity<Page<Board>> getAllBoardsWithPagination(
    @PathVariable("offset") int offset, @PathVariable("pageSize") int pageSize,
    @PathVariable("field") String field) {
    System.out.println("getAllBoardsWithPagination");
    Page<Board> boardList = boardService.getAllBoardsWithPagination(offset, pageSize, field);
    return new ResponseEntity<>(boardList, HttpStatus.OK);
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
  public ResponseEntity<BoardDTO> updatePage(@PathVariable("no") Long no) {
    BoardDTO board = boardService.getBoardByNo(no);
    return ResponseEntity.ok(board);
  }

  @PutMapping("/update/{no}")
  public ResponseEntity<?> update(@PathVariable("no") Long no, @RequestBody BoardDTO boardDTO) {
    boardService.updateBoard(no, boardDTO);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/delete/{no}")
  public ResponseEntity<?> delete(@PathVariable("no") Long no) {
    boardService.deleteBoard(no);
    return ResponseEntity.ok().build();
  }
}
