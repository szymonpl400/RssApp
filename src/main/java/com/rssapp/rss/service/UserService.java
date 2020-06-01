package com.rssapp.rss.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rssapp.rss.entity.Role;
import com.rssapp.rss.entity.Users;
import com.rssapp.rss.repository.RoleRepository;
import com.rssapp.rss.repository.UserRepository;


@Service("userService")
public class UserService 
{
	private UserRepository userRepository;
	
	private RoleRepository roleRepository;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	
	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) 
	{
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public Users findUserByEmail(String email) 
	{
		return userRepository.findByEmail(email);
	}
	
	public List<Users> findAll()
	{
		return userRepository.findAll();
	}
	
	public Users getOne(Integer id) 
	{
		return userRepository.getOne(id);
	}
	
	public void saveUser(Users users) 
	{
		users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
		users.setActive(1);
		Role userRole = roleRepository.findByRole("ADMIN");
		users.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(users);
	}
	
	public void saveOnlyUser(Users users) 
	{
		userRepository.save(users);
	}
	
	public List<Users> findByNameAndLastName(String name, String lastName)
	{
		return userRepository.findByNameAndLastName(name, lastName);
	}
	
	public List<Users> findByName(String name)
	{
		return userRepository.findByName(name);
	}
}