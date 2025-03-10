package com.salted26.back_jpa.repository;

import com.salted26.back_jpa.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {

  @Query(value = "UPDATE Board SET views = :views+1 where id = :id")
  @Modifying
  void setViews(
    @Param(value="views") int views,
    @Param(value="id") Long id);

}
