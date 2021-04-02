package com.shweta.hackernews.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shweta.hackernews.entity.Comment;
import com.shweta.hackernews.entity.Story;
import com.shweta.hackernews.service.CommentService;
import com.shweta.hackernews.service.StoryService;

@RestController
@RequestMapping("/")
public class HackerNewsController {
	
	@Autowired
	private StoryService storyService;
	@Autowired
	private CommentService commentService;
	
	
	@GetMapping("best-stories")
	public List<Story> getBestStories(){
		return storyService.getBestStories();
	}
	
	@GetMapping("past-stories")
	public List<Story> getPastStories(){
		return storyService.getPastStories();
	}
	
	@GetMapping("comments/{id}")
	public List<Comment> getComments(@PathVariable("id") int id){
		return commentService.getStoryComments(id);
	}

}
