package com.admin.application;

import com.admin.domain.modle.TitleInThisWeek;
import com.admin.domain.repository.TitleInThisWeekRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleInThisWeekDbService  {
    @Autowired
    private TitleInThisWeekRepositry titleInThisWeekRepositry;
    @Autowired
    private OperationOnTitleInThisWeek operationOnTitleInThisWeek;

    public Iterable<TitleInThisWeek> getAllTitles()
    {
        return titleInThisWeekRepositry.findAll();
    }
    public Iterable<TitleInThisWeek> getAllXlTitles()
    {
      return titleInThisWeekRepositry.findAllByProductTypeId(0);
    }

    public Iterable<TitleInThisWeek> getAllBdTitles()
    {
       return titleInThisWeekRepositry.findAllByProductTypeId(1);
    }



}
