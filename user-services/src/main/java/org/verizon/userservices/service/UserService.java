package org.verizon.userservices.service;

import java.util.List;

import org.verizon.userservices.domain.User;
import org.verizon.userservices.domain.WorkGroup;

public interface UserService {
	
	void registerUser(User user);
	List<User> getAllUsers(int wrkgrpId);
	User getUserById(int userId);
	User getUserByName(String name);
	void deleteUser(int userId);
	User getUserByGarmLevel(int userId);
	//getSuperviserByUserId()
	//getSuperviserByUserName()
	//getUserGsam()
	//getUserPrevileges()
	//modifyUser()
	//decommissionUser()
}
