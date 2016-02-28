package org.verizon.userservices.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.verizon.userservices.domain.User;
import org.verizon.userservices.domain.WorkGroup;

/**
 * This UserServiceRepository class is used to define all the methods related to UserServiceRepository.
 * @author Giri
 *
 */

public interface UserServiceRepository extends JpaRepository<User, Integer>{

	User findUserByUserId(int userId);

	User findUserByFirstName(String fname);

	void deleteUserByUserId(int userId);

	User findByGarmLevel(int userId);

	List<User> findAllUsersByWorkGroup(WorkGroup wrkgrpId);


}
