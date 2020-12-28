package com.admin.infrastructure.persistence.jdbc;

import com.admin.domain.modle.ProjectClass;
import com.admin.domain.modle.ProjectXl;
import com.admin.domain.modle.TitleInThisWeek;
import com.admin.domain.modle.XlProgress;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectXlRepository extends CrudRepository<ProjectXl,Integer> {

    @Query(value="select t.progressXlLsit  from ProjectXl t where t.id=?1")
    Iterable<XlProgress> findProgressXlLsitById(@Param("projectId") int id);

}
