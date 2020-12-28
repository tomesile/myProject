package com.admin.domain.repository;

import com.admin.domain.modle.TitleInThisWeek;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TitleInThisWeekRepositry extends CrudRepository<TitleInThisWeek,Integer> {




    @Query(value="from TitleInThisWeek t where t.projectTypeId=?1")
    Iterable<TitleInThisWeek> findAllByProductTypeId( @Param("projectTypeId") int id);

    @Query(value="from TitleInThisWeek t where t.projectId=?1 and t.projectTypeId=?2")
    Iterable<TitleInThisWeek> findAllByProductId( @Param("projectId") int id,@Param("projectTypeId") int typeId);

    @Query(value="from TitleInThisWeek t where t.id=?1 and t.projectTypeId=?2")
    TitleInThisWeek findTitleOne( @Param("id") int id,@Param("projectTypeId") int typeId);


}
