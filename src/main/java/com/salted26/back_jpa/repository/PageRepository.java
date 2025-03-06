package com.salted26.back_jpa.repository;

import com.salted26.back_jpa.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends PagingAndSortingRepository<Board, Long> {

  Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);

}
