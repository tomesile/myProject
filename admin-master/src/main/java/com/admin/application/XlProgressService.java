package com.admin.application;

import com.admin.domain.modle.CompletedInWeek;
import com.admin.domain.modle.TitleInThisWeek;
import com.admin.domain.modle.XlProgress;
import com.admin.domain.repository.CompletedInWeekRepositry;
import com.admin.domain.repository.TitleInThisWeekRepositry;
import com.admin.domain.repository.XlProgressRepository;
import com.admin.infrastructure.persistence.jdbc.ProjectXlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class XlProgressService {
    @Autowired
    private XlProgressRepository xlProgressRepository;
    @Autowired
    private CompletedInWeekRepositry completedInWeekRepositry;
    @Autowired
    private TitleInThisWeekRepositry titleInThisWeekRepositry;
    @Autowired
    private ProjectXlRepository projectXlRepository;


    public XlProgress findXlProgressOne(int id)
    {
        return xlProgressRepository.findOne(id);
    }

    public XlProgress save(XlProgress xlProgress, TitleInThisWeek title,CompletedInWeek completedInWeek)
    {
        xlProgress.setCompletedInWeek(completedInWeek);
        xlProgress.setTitleInThisWeek(title);
        xlProgress.setProjectXl(projectXlRepository.findOne(xlProgress.getProjectXl().getId()));
        completedInWeekRepositry.save(completedInWeek);
        titleInThisWeekRepositry.save(title);
        return xlProgressRepository.save(xlProgress);
    }
    //--------------------下面是线路进度修改功能部分
    public void update(XlProgress xlProgress, CompletedInWeek completedInWeek,int id)
    {

        xlProgress.setId(id);
        xlProgress.setCreateDate(new Date());
        completedInWeek.setId(xlProgress.getCompletedInWeek().getId());
        completedInWeekRepositry.save(completedInWeek);
        xlProgressRepository.save(xlProgress);

    }
    //--------------------------------------------
        public List<XlProgress> getAllXlProgress(int title_in_this_week_id)
    {
        //return xlProgressRepository.findAll().forEach(item->item.getTitleInThisWeek().getId()==title_in_this_week_id);
        System.out.println(((List<XlProgress>)xlProgressRepository.findAll()).toString());
        return ((List<XlProgress>)xlProgressRepository.findAll()).stream().filter(item->item.getTitleInThisWeek().getId()==title_in_this_week_id).collect(Collectors.<XlProgress>toList());

    }



}
