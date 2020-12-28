package com.admin.infrastructure.persistence.jdbc;

import com.admin.domain.modle.ProjectClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectClass,Integer> {


}
