package com.admin.domain.repository;

import com.admin.domain.modle.XlProgress;
import org.springframework.data.repository.CrudRepository;
import com.admin.domain.modle.ProgressXl;

public interface ProgressXlRepository extends CrudRepository<XlProgress, Integer> {
}
