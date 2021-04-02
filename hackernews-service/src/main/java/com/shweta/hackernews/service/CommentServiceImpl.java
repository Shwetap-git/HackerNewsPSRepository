package com.shweta.hackernews.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shweta.hackernews.entity.Comment;
import com.shweta.hackernews.repository.CommentRepository;
import com.shweta.hackernews.util.CommentKidsComparator;
import com.shweta.hackernews.util.HackerNewsDelegator;

@Service
public class CommentServiceImpl implements CommentService{
	private CommentRepository commentRepo;
	private HackerNewsDelegator delegator;
	
	@Autowired
	public CommentServiceImpl(CommentRepository commentRepo, HackerNewsDelegator delegator) {
		this.commentRepo = commentRepo;
		this.delegator = delegator;
	}

	public List<Comment> getStoryComments(int storyId) {
		List<Comment> comments= delegator.callStoryCommentsAPI(storyId);
		Collections.sort(comments, new CommentKidsComparator());
		return comments;
	}

}
