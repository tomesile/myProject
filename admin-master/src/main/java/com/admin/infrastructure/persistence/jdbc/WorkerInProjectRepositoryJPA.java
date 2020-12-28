package com.admin.infrastructure.persistence.jdbc;

import com.admin.domain.modle.WorkerInProject;
import org.springframework.data.repository.CrudRepository;

public interface WorkerInProjectRepositoryJPA extends CrudRepository<WorkerInProject,Integer> {
}
