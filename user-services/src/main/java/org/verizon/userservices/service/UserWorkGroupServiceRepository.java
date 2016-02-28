package org.verizon.userservices.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.verizon.userservices.domain.WorkGroup;

public interface UserWorkGroupServiceRepository extends JpaRepository<WorkGroup, Integer >{

	WorkGroup findWorkGroupById(int id);


}
