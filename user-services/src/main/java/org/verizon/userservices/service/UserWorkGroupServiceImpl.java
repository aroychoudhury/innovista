package org.verizon.userservices.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.verizon.userservices.domain.WorkGroup;

@Component("userWorkGroupService")
@Transactional
public class UserWorkGroupServiceImpl implements UserWorkGroupService{
	
	Logger log = LoggerFactory.getLogger(UserWorkGroupServiceImpl.class);
	private UserWorkGroupServiceRepository  userWkGrpRepository;
	
	@Autowired
	public UserWorkGroupServiceImpl(UserWorkGroupServiceRepository userWkGrpRepository) {
		this.userWkGrpRepository = userWkGrpRepository;
	}

	@Override
	public WorkGroup getWorkGroupById(int id) {
		Assert.notNull(id, "Id must not be null");
		return this.userWkGrpRepository.findWorkGroupById(id);
	}

	/*@Override
	public User getUserWorkGroupById(int id) {
		return null;
	}*/

}
