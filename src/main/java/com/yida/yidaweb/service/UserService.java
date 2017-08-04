package com.yida.yidaweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yida.yidaweb.dao.UserMapper;
import com.yida.yidaweb.domain.UserEntity;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class UserService {
	@Autowired
    private UserMapper userMapper;
	
	@Transactional(readOnly = true)
	public List<UserEntity> getAll() {
		return userMapper.getAll();
	}
	
	@Transactional(readOnly = true)
    public UserEntity getUserById(Long id) {
		UserEntity user = userMapper.getOne(id);
        return user;
    }
	
	public void createUser(UserEntity user) {
		userMapper.insert(user);
	}
	
	public void updateUser(UserEntity user) {
		userMapper.update(user);
	}
	
	public void deleteUser(Long id) {
		userMapper.delete(id);
	}
}
