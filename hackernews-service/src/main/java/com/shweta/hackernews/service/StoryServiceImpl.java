package com.shweta.hackernews.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shweta.hackernews.entity.Story;
import com.shweta.hackernews.repository.StoryRepository;
import com.shweta.hackernews.util.HackerNewsDelegator;

@Service
public class StoryServiceImpl implements StoryService{
	
	private StoryRepository storyRepo;
	private HackerNewsDelegator delegator;
	
	@Autowired
	public StoryServiceImpl(StoryRepository storyRepo, HackerNewsDelegator hNDelegator){
		this.storyRepo = storyRepo;
		this.delegator = hNDelegator;
	}

	public List<Story> getBestStories() {
		List<Story> stories= delegator.callBestStoriesApi();
		storyRepo.saveAll(stories);
		return stories;
	}

	public List<Story> getPastStories() {
		return storyRepo.findAll();
	}
	

}
