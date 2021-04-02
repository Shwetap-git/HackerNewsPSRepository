package com.shweta.hackernews.util;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shweta.hackernews.entity.Comment;
import com.shweta.hackernews.entity.Story;
import com.shweta.hackernews.entity.User;

@Component
public class HackerNewsDelegator {
	private List<Story> stories;
	private LocalTime time;
	public static final String BEST_STORIES_API="https://hacker-news.firebaseio.com/v0/beststories.json";
	public static final String GET_ITEM_API="https://hacker-news.firebaseio.com/v0/item/";
	public static final String GET_USER_API="https://hacker-news.firebaseio.com/v0/user/";
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<Story> callBestStoriesApi(){
		if(null!=time){
			LocalTime now = LocalTime.now();
			long mins = Duration.between(time, now).toMinutes();
			if(mins<15){
				return stories;
			}
		}
		List<Integer> list = restTemplate.getForObject(BEST_STORIES_API, List.class);
		stories = new LinkedList<Story>();
		for(int i=0;i<10;i++){
			//System.out.println(list.get(i));
			stories.add(callStoryApi(list.get(i)));
		}
		time = LocalTime.now();
		return stories;		
	}
	
	private Story callStoryApi(Integer num){
		String storyStr = restTemplate.getForObject(GET_ITEM_API+num+".json", String.class);
		Story story = convertJsonToObject(storyStr, Story.class);
		//System.out.println(story);
		return story;
	}
	
	private Comment callCommentsApi(Integer num){
		String commentStr = restTemplate.getForObject(GET_ITEM_API+num+".json", String.class);
		Comment comment = convertJsonToObject(commentStr, Comment.class);
		//System.out.println(comment);
		return comment;
	}
	
	private User callUserApi(String by){
		String userStr = restTemplate.getForObject(GET_USER_API+by+".json", String.class);
		User user = convertJsonToObject(userStr, User.class);
		//System.out.println(user);
		return user;
	}
	
	public static <T> T convertJsonToObject(String jsonString, Class<T> clazz) {
		final ObjectMapper Obj = new ObjectMapper();
		T result = null;
		try {
			result = Obj.readValue(jsonString, clazz);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
		}

	public List<Comment> callStoryCommentsAPI(int storyId) {
		Story story = restTemplate.getForObject(GET_ITEM_API+storyId+".json", Story.class);
		List<Comment> comments = new LinkedList<Comment>();
		List<Integer> list = story.getKids();
		Comment comment=null;
		User user = null;
		Calendar c = Calendar.getInstance(); 
		for(int i=0;i<10;i++){
			comment = callCommentsApi(list.get(i));
			user = callUserApi(comment.getBy());
			c.setTimeInMillis(user.getCreated().longValue());
			int year = Calendar.getInstance().get(Calendar.YEAR)-c.get(Calendar.YEAR);
			comment.setUserTime(year+" years");
			comments.add(comment);
			
		}
		return comments;
	}
}
