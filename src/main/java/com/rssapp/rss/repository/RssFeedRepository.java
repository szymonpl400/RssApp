package com.rssapp.rss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rssapp.rss.entity.RssFeed;

@Repository("RssFeedRepository")
public interface RssFeedRepository extends JpaRepository<RssFeed, Integer> 
{
	RssFeed findByEmail(String email);
	List<RssFeed> findAll();
}