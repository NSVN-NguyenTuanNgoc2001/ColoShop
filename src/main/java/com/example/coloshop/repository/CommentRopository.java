package com.example.coloshop.repository;

import com.example.coloshop.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRopository extends JpaRepository<Comment, Integer> {
}
