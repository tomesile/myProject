package com.admin.application;

import com.admin.domain.modle.*;
import com.admin.domain.repository.*;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.catalina.manager.StatusTransformer.filter;

@Service
public class BdProgressService {
    @Autowired
    private ProgressBdRepository progressBdRepository;
    @Autowired
    private ConstructionRepository constructionRepository;
    @Autowired
    private ElecRepository elecRepository;
    @Autowired
    private DebugeRepository debugeRepository;
    @Autowired
    private TitleInThisWeekRepositry titleInThisWeekRepositry;
    @Autowired
    private ProjectBdRepository projectBdRepository;

    public ProgressBd save(ProgressBd progressBd, TitleInThisWeek title,Construction con, Elec elec, Debuge debug)
    {
        progressBd.setConstruction(con);
        progressBd.setElec(elec);
        progressBd.setDebuge(debug);
        progressBd.setTitleInThisWeek(title);
        progressBd.setProjectBd(projectBdRepository.findOne(progressBd.getProjectBd().getId()));
        constructionRepository.save(con);
        elecRepository.save(elec);
        debugeRepository.save(debug);
        titleInThisWeekRepositry.save(title);
       // projectBdRepository.save(progressBd.getProjectBd());

        return progressBdRepository.save(progressBd);
    }


    public void update()
    {

    }
    public List<ProgressBd> getAllProgressBdByName(int title_id)
    {
        //return progressBdRepository.findAll().forEach(item->item.stream().filter(item.getTitleInThisWeek().getId())==title_id);
        return ((List<ProgressBd>)progressBdRepository.findAll()).stream().filter(item->item.getTitleInThisWeek().getId()==title_id).collect(Collectors.<ProgressBd>toList());

    }

}
