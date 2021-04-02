package com.shweta.hackernews.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shweta.hackernews.entity.Comment;

@Service
public interface CommentService {

	public List<Comment> getStoryComments(int id);

}
