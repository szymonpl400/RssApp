package com.rssapp.rss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rssapp.rss.entity.Role;


@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<com.rssapp.rss.entity.Role, Integer> 
{
	Role findByRole(String role);
}