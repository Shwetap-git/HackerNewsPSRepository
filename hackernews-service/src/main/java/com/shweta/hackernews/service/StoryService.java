package com.shweta.hackernews.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shweta.hackernews.entity.Story;

@Service
public interface StoryService {

	public List<Story> getBestStories();

	public List<Story> getPastStories();

}
