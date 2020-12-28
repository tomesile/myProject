package com.admin.interfaces.web;

import com.admin.application.TitleInThisWeekService;
import com.admin.application.XlProgressService;
import com.admin.application.XlTitleInThisWeekService;
import com.admin.domain.modle.TitleInThisWeek;
import com.admin.domain.modle.XlProgress;
import com.admin.domain.repository.CompletedInWeekRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("xlProgressCreate")
public class XlProgressCreateController {

    @Autowired
    private XlProgressService xlProgressService;
    @Autowired
    private XlTitleInThisWeekService xlTitleInThisWeekService;
    @Autowired
    private CompletedInWeekRepositry completedInWeekRepositry;
    @Autowired
    private TitleInThisWeekService titleInThisWeekService;
    @GetMapping
    public String  getView()
    {
        return "xlProgressCreate";
    }
    @PostMapping
    public String createXlProgress(@Valid XlProgress xlProgress, Errors errors, Model model)
    {
        if(errors.hasErrors()) return "/403";
        xlProgress.setCreateDate(new Date());
        TitleInThisWeek title=null;
        System.out.println("传入的titile:"+xlProgress.getTitleInThisWeek());
        if(xlProgress.getTitleInThisWeek()==null || xlProgress.getTitleInThisWeek().getId()<=0)
        {
            System.out.println("传入的titile为空！");
            title=createTitle( xlProgress.getProjectXl().getId(),xlProgress);
            xlProgress.setTitleInThisWeek(title);

        }
        else if(xlProgress.getTitleInThisWeek().getId()>0)
        {
            title= titleInThisWeekService.getTitleById(xlProgress.getTitleInThisWeek().getId(),0);
            System.out.println("id不为空时取得的title："+xlProgress.getTitleInThisWeek().getId());
        }
        else
        {
            System.out.println("进入了其他！");
            title=xlTitleInThisWeekService.getTitle0(xlProgress.getProjectXl().getId(),0);
        }


        XlProgress rt=xlProgressService.save(xlProgress,title,xlProgress.getCompletedInWeek());
      //  System.out.println("----最后的XlProgress:"+rt);
       // System.out.println("----最后的title:"+title);
        title.getXlList().add(rt);//添加到数据库列表中
        xlTitleInThisWeekService.save(title);
       // System.out.println("----最后的title--:" +title);
        return "xlProgressCreate";
    }
    public TitleInThisWeek createTitle( int id,XlProgress xlProgress)
    {
        String rtName;
        TitleInThisWeek titles;
        if(isCreatedTitle(id))
        {
            //从TITLE列表中获取到title
            titles=xlTitleInThisWeekService.getTitle0(id,0);
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
            title.setName(dateName+")"+"公司线路工程信息一览表");
            title.setCreateDate(new Date());
            title.setProjectId(id);
            title.setProjectTypeId(0);//0为线路，1为变电

          //  title.setBdList(null);
          //  completedInWeekRepositry.save(xlProgress.getCompletedInWeek());
            titles= xlTitleInThisWeekService.saveTitle(title);
            rtName=dateName;//从刚创建的TITLE中返回name
            System.out.println("从刚创建的TITLE中返回name"+rtName);
        }
        return titles;
    }
    public boolean isCreatedTitle(int progressId)
    {
        if(xlTitleInThisWeekService.isCanCreateTitleInThisWeek(progressId)) return true;
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
