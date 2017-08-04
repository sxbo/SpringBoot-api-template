package com.yida.yidaweb;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yida.yidaweb.dao.UserMapper;
import com.yida.yidaweb.domain.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YidawebApplicationTests {
	@Autowired
	private UserMapper userMapper;
	 
	@Test
    public void testInsert() throws Exception {
		UserEntity u = new UserEntity();
		u.setName("娃娃");
		u.setPwd("123");
		u.setEmail("dd@163.com");
		userMapper.insert(u);

        Assert.assertEquals(3, userMapper.getAll().size());
    }
	
	@Test
    public void testQuery() throws Exception {
        List<UserEntity> users = userMapper.getAll();
        System.out.println(users.toString());
    }
	
	@Test
    public void testUpdate() throws Exception {
        UserEntity user = userMapper.getOne(1L);
        System.out.println(user.toString());
        user.setName("neo");
        userMapper.update(user);
        Assert.assertTrue(("neo".equals(userMapper.getOne(1L).getName())));
    }
	
	@Test
    public void testDelete() throws Exception {
		userMapper.delete(4L);
		Assert.assertEquals(3, userMapper.getAll().size());
    }
	
	@Test
	public void contextLoads() {
	}

}
