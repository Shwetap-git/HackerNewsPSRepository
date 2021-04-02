package com.shweta.hackernews.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.shweta.hackernews.entity.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story, Integer>{

}
