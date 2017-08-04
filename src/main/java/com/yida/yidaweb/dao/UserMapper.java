package com.yida.yidaweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yida.yidaweb.domain.UserEntity;



public interface UserMapper {

	@Select("SELECT * FROM users")
	List<UserEntity> getAll();
	
	@Select("SELECT * FROM users WHERE id = #{id}")
	UserEntity getOne(Long id);

    @Insert("INSERT INTO users(name,pwd,email) VALUES(#{name}, #{pwd}, #{email})")
    void insert(UserEntity user);

    @Update("UPDATE users SET name=#{name},pwd=#{pwd} WHERE id =#{id}")
    void update(UserEntity user);

	@Delete("DELETE FROM users WHERE id =#{id}")
	void delete(Long id);
}
