package com.rssapp.rss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rssapp.rss.entity.RssFeed;
import com.rssapp.rss.repository.RssFeedRepository;

@Service("RssFeedService")
public class RssFeedService {
	
	@Autowired
	private RssFeedRepository  rssFeedRepository;
	
	public RssFeed findByEmail(String email) {
		return rssFeedRepository.findByEmail(email);
	};
	
	public List<RssFeed> findAll() 
	{
		return rssFeedRepository.findAll();
	}

}
