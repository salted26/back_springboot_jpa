package com.salted26.back_jpa.mapper;

import com.salted26.back_jpa.dto.BoardDTO;
import com.salted26.back_jpa.entity.Board;

public class BoardMapper {

    public static BoardDTO mapToBoardDTO(Board board) {
        return new BoardDTO(
            board.getId(),
            board.getEmail(),
            board.getTitle(),
            board.getWriter(),
            board.getContent(),
            board.getViews(),
            board.getCreated_at(),
            board.getUpdated_at()
        );
    }

    public static Board mapToBoard(BoardDTO boardDTO) {
        return new Board(
            boardDTO.getId(),
            boardDTO.getEmail(),
            boardDTO.getTitle(),
            boardDTO.getWriter(),
            boardDTO.getContent(),
            boardDTO.getViews(),
            boardDTO.getCreated_at(),
            boardDTO.getUpdated_at()
        );
    }
}
