package com.admin.infrastructure.persistence.jdbc;

import com.admin.domain.modle.SubCompany;
import org.springframework.data.repository.CrudRepository;

public interface SubCompanyRepositoryJPA extends CrudRepository<SubCompany,Integer> {
}
