package com.shweta.hackernews.util;

import java.util.Comparator;

import com.shweta.hackernews.entity.Comment;

public class CommentKidsComparator implements Comparator<Comment>{

	public int compare(Comment o1, Comment o2) {
		if (o1 == o2){
			return 0;
		}
		if (o1.getKids() == null && o2.getKids() == null) {
			return o2.getId().compareTo(o1.getId());
		} else if (o1.getKids() == null && o2.getKids() != null) {
			return 1;
		} else if(o1.getKids() != null && o2.getKids() == null) {
			return -1;
		} else {
			return Integer.compare(o2.getKids().size(),o1.getKids().size());
		}
	}

}
