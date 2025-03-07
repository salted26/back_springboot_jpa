package com.salted26.back_jpa.controller;

import com.salted26.back_jpa.dto.BoardDTO;
import com.salted26.back_jpa.entity.Board;
import com.salted26.back_jpa.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/board")
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class BoardController {

  @Autowired
  private BoardService boardService;

  @GetMapping("")
  public ResponseEntity<Page<Board>> getAllBoards(
    @RequestParam(required = false) int page,
    @RequestParam(required = false) int pageSize,
    @RequestParam(required = false) String searchKeyword) {
    Page<Board> boardList = boardService.getAllPagination(page, pageSize, searchKeyword);
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
  @GetMapping("/{id}")
  public ResponseEntity<BoardDTO> getBoardById(@PathVariable("id") Long id) {
    BoardDTO board = boardService.getBoardById(id);
    return ResponseEntity.ok(board);
  }

  @PostMapping("/write")
  public ResponseEntity<?> save(@RequestBody BoardDTO boardDTO) {
    boardService.saveBoard(boardDTO);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/update/{id}")
  public ResponseEntity<BoardDTO> updatePage(@PathVariable("id") Long id) {
    BoardDTO board = boardService.getBoardById(id);
    return ResponseEntity.ok(board);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody BoardDTO boardDTO) {
    boardService.updateBoard(id, boardDTO);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    boardService.deleteBoard(id);
    return ResponseEntity.ok().build();
  }
}
