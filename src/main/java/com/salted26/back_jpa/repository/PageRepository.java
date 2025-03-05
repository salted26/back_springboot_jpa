package com.salted26.back_jpa.repository;

import com.salted26.back_jpa.entity.Board;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends PagingAndSortingRepository<Board, Long> {

}
