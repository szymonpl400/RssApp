package com.rssapp.rss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rssapp.rss.entity.Users;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<com.rssapp.rss.entity.Users, Integer> 
{
	com.rssapp.rss.entity.Users findByEmail(String email);
	List<Users> findAll();
	List<Users> findByNameAndLastName(String name, String lastName);
	List<Users> findByName(String name);


}