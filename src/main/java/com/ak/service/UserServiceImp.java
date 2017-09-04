package com.ak.service;

import com.ak.dao.UserDao;
import com.ak.model.User;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User findOne(Long id) {
		return userDao.findOne(id);
	}

	@Override
	public void save(User user) {
		userDao.save(user);	
	}

	@Override
	public void delete(Long id) {
		userDao.delete(id);		
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userDao.findByEmail(email);
		if (user == null){
			throw new UsernameNotFoundException(String.format("%s do not exist in database!", email));
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(),
				user.getPassword(),
				authorities);
	}

}
