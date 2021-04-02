package com.shweta.hackernews.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.shweta.hackernews.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer>{

}
