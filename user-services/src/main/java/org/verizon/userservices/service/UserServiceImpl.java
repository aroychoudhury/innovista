package org.verizon.userservices.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.verizon.userservices.domain.User;
import org.verizon.userservices.domain.WorkGroup;
/**
 * This UserServiceImpl class is used to implement all the methods related to User available in UserService
 * @author Giri
 *
 */

@Component("userService")
@Transactional
public class UserServiceImpl implements UserService {
	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private final UserServiceRepository userRepository;
	
	private final UserWorkGroupServiceRepository workgrouprep;
	
	@Autowired
	public UserServiceImpl(UserServiceRepository userRepository, UserWorkGroupServiceRepository workgrouprep) {
		this.userRepository = userRepository;
		this.workgrouprep = workgrouprep;
	}
	
	@Override
	public User getUserById(int userId) {
		log.debug("getUserById() - Entering ");
		Assert.notNull(userId, "userId must not be null");
		log.debug("getUserById() - Exiting ");
		return this.userRepository.findUserByUserId(userId);
	}

	@Override
	public User getUserByName(String name) {
		log.debug("getUserByName() - Entering ");
		Assert.hasLength(name, "Name must not be empty");
		log.debug("getUserByName() - Exiting ");
		return this.userRepository.findUserByFirstName(name);
	}
	
	@Override
	public List<User> getAllUsers(int wrkgrpId) {
		log.debug("getAllUsers() - Entering ");
		WorkGroup wkg = workgrouprep.findWorkGroupById(wrkgrpId);
		log.debug("getAllUsers() - Exiting ");
		return this.userRepository.findAllUsersByWorkGroup(wkg);
	}
	
	@Override
	public User getUserByGarmLevel(int userId) {
		log.debug("getUserByGarmLevel() - Entering ");
		Assert.notNull(userId, "userId must not be null");
		log.debug("getUserByGarmLevel() - Exiting ");
		return this.userRepository.findByGarmLevel(userId);
	}
	
	@Override
	public void deleteUser(int userId) {
		log.debug("deleteUser() - Entering ");
		userRepository.deleteUserByUserId(userId);
		log.debug("deleteUser() - Exiting ");
	}
	
	@Override
	public void registerUser(User user) {
		log.debug("registerUser() - Entering ");
		userRepository.save(user);
		log.debug("registerUser() - Exiting ");
	}
}
