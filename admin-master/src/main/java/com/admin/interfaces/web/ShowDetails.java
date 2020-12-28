package com.admin.interfaces.web;

import com.admin.application.BdProgressService;
import com.admin.application.BdTitleInThisWeekService;
import com.admin.application.ProjectBdService;
import com.admin.application.TitleInThisWeekService;
import com.admin.domain.modle.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/BdshowDetail")
public class ShowDetails {

    @Autowired
    private ProjectBdService projectBdService;
    @Autowired
    private BdProgressService bdProgressService;
    @Autowired
    private BdTitleInThisWeekService bdTitleInThisWeekService;
    @Autowired
    private TitleInThisWeekService titleInThisWeekService;

    @GetMapping("/")
    public @ResponseBody BdProjectModle getShowDetails(@RequestParam("pid") int project_id, @RequestParam("tid") int title_in_this_week_id)
    {
        BdProjectModle rtBdProject=new BdProjectModle();
        ProjectBd projectBd=projectBdService.getOneProjectBd(project_id);
        List<ProgressBd> progressBdList=bdProgressService.getAllProgressBdByName(title_in_this_week_id);
        rtBdProject.setProjectBd(projectBd);
        rtBdProject.setProgressBd(progressBdList);
        return rtBdProject;

    }


    @GetMapping("/allbd")
    public @ResponseBody List<BProjectNdameId> getAllBdList()
    {
        List<ProjectBd> projectBds=new ArrayList<>();
        // Map<String,Integer>  projectNameMap=new HashMap<>();
        List<BProjectNdameId> mapList=new ArrayList<BProjectNdameId>();
        projectBds=(List<ProjectBd>)projectBdService.getAllProjects();
        for(ProjectBd bd:projectBds)
        {
            BProjectNdameId bdProjectNameId=new BProjectNdameId();
            bdProjectNameId.setId(bd.getId());
            bdProjectNameId.setName(bd.getName());

            mapList.add(bdProjectNameId);
            System.out.println(mapList.toString());
        }

        return mapList;
    }


    @PostMapping("/createBdProgress")
    public String createBdProgress(@Valid ProgressBd progressBd, Errors errors, Model model)
    {
        if(errors.hasErrors()) return "/403";
        progressBd.setCreateDate(new Date());
        TitleInThisWeek title=null;
        System.out.println("传入的titile:"+progressBd.getTitleInThisWeek());
        if(progressBd.getTitleInThisWeek()==null || progressBd.getTitleInThisWeek().getId()<=0)
        {
            System.out.println("传入的titile为空！");
            title=createTitle( progressBd.getProjectBd().getId(),progressBd);
            progressBd.setTitleInThisWeek(title);

        }
        else if(progressBd.getTitleInThisWeek().getId()>0)
        {
            title= titleInThisWeekService.getTitleById(progressBd.getTitleInThisWeek().getId(),1);
            System.out.println("id不为空时取得的title："+progressBd.getTitleInThisWeek().getId());
        }
        else
        {
           title=bdTitleInThisWeekService.getTitle0(progressBd.getProjectBd().getId(),1);
            System.out.println("其他情况时取得的title："+title.getName());
        }
        System.out.println("----保存进度之前的title:"+title.getName());
//ProgressBd progressBd, Construction con, Elec elec, Debuge debug
        ProgressBd rt=bdProgressService.save(progressBd,title,progressBd.getConstruction(),progressBd.getElec(),progressBd.getDebuge());
       // System.out.println("----最后的XlProgress:"+rt.toString());
      //  System.out.println("----最后的title:"+title);
        title.setName(title.getName());
        title.setProjectId(title.getProjectId());
        title.setCreateDate(title.getCreateDate());
        title.setProjectTypeId(title.getProjectTypeId());
        title.getBdList().add(rt);//添加到数据库列表中
        bdTitleInThisWeekService.save(title);
        // System.out.println("----最后的title--:" +title);
        return "xlProgressCreate";
    }
    public TitleInThisWeek createTitle( int id,ProgressBd progressBd)
    {
        String rtName;
        TitleInThisWeek titles;
        if(isCreatedTitle(id))
        {
            //从TITLE列表中获取到title
            titles=bdTitleInThisWeekService.getTitle0(id,1);
            System.out.println("直接查询的数据为："+titles.getName());
        }
        else
        {
            //顺便创建TITLE,并存储在数据库中
            TitleInThisWeek title=new TitleInThisWeek();
            Date date=new Date();
            String dateName=new String();
            String endDate=plusDay2(6);
            dateName="("+dateNow()+"-"+endDate;
            title.setName(dateName+")"+"公司变电工程信息一览表");
            title.setCreateDate(new Date());
            title.setProjectId(id);
            title.setProjectTypeId(1);//0为线路，1为变电

            //  title.setBdList(null);
            //  completedInWeekRepositry.save(xlProgress.getCompletedInWeek());
            titles= bdTitleInThisWeekService.saveTitle(title);
            rtName=dateName;//从刚创建的TITLE中返回name
            System.out.println("从刚创建的TITLE中返回name"+rtName);
        }
        return titles;
    }
    public boolean isCreatedTitle(int progressId)
    {
        if(bdTitleInThisWeekService.isCanCreateTitleInThisWeek(progressId)) return true;
        return false;
    }

    public  String plusDay2(int num){
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        String currdate = format.format(d);
        System.out.println("现在的日期是：" + currdate);

        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
        d = ca.getTime();
        String enddate = format.format(d);
        System.out.println("增加天数以后的日期：" + enddate);
        return enddate;
    }
    public String dateNow()
    {
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String currdate = format.format(d);
        System.out.println("现在的日期是：" + currdate);
        return currdate;
    }

}
