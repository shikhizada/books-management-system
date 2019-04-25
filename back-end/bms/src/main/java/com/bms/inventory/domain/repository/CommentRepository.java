package com.bms.inventory.domain.repository;

import com.bms.inventory.domain.model.Book;
import com.bms.inventory.domain.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c where c.book.id = ?1")
    List<Comment> findAllByBookId(Long id);
}
