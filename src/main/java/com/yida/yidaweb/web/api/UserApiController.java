package com.yida.yidaweb.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yida.yidaweb.ResHttpStatus;
import com.yida.yidaweb.domain.UserEntity;
import com.yida.yidaweb.service.UserService;

@RestController
@RequestMapping("/api")
public class UserApiController {

	@Autowired
	private UserService userService;
	 /**
     * GET  /users -> get all users.
     */
    @RequestMapping(value = "/users",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResHttpStatus> getAllUsers() {
    		List<UserEntity> users = userService.getAll();
    		ResHttpStatus res = new ResHttpStatus();
    		res.setCode("200");
    		res.setMsg("");
    		res.setData(users);
	        return new ResponseEntity<>(res, HttpStatus.OK);
	}
    
    /**
     * GET  /users/:id -> get the "id" user.
     */
    @RequestMapping(value = "/users/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResHttpStatus> getUser(@PathVariable Long id) {
    	UserEntity user = userService.getUserById(id);
    	ResHttpStatus res = new ResHttpStatus();
		res.setCode("200");
		res.setMsg("");
		res.setData(user);
		return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    /**
     * POST  /users -> Creates a new user.
     */
    @RequestMapping(value = "/users",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResHttpStatus> createUser(@RequestBody UserEntity user) {
    	userService.createUser(user);
    	ResHttpStatus res = new ResHttpStatus();
		res.setCode("200");
		res.setMsg("新增用户成功");
		return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    /**
     * PUT  /users -> Updates an existing User.
     */
    @RequestMapping(value = "/users",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResHttpStatus> updateUser(@RequestBody UserEntity user) {
    	userService.updateUser(user);
    	ResHttpStatus res = new ResHttpStatus();
		res.setCode("200");
		res.setMsg("更新用户成功");
		return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    /**
     * DELETE  USER :id -> delete the "id" User.
     */
    @RequestMapping(value = "/users/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResHttpStatus> deleteUser(@PathVariable Long id) {
    	userService.deleteUser(id);
    	ResHttpStatus res = new ResHttpStatus();
		res.setCode("200");
		res.setMsg("删除用户成功");
		return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
}

