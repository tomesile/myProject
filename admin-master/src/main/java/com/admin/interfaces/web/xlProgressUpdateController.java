package com.admin.interfaces.web;

import com.admin.application.XlProgressService;
import com.admin.domain.modle.CompletedInWeek;
import com.admin.domain.modle.XlProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/xlProgressUpdate")
public class xlProgressUpdateController {

    @Autowired
    private XlProgressService xlProgressService;

    @GetMapping
    public String getView(Model model)
    {

        model.addAttribute("xlProgress",xlProgressService.findXlProgressOne(3));
        return "/xlProgressUpdate";
    }
    @PostMapping
    public String updateXlProgress(@Valid XlProgress xlProgress, Errors errors, @ModelAttribute XlProgress xlMode)
    {
        //int id=idd;
        System.out.println("----------------"+xlProgress.toString());
        //System.out.println("----------------"+id);
        CompletedInWeek c=xlProgress.getCompletedInWeek();
        xlProgressService.update(xlProgress,c,3);
        return ("/xlProgressUpdate");
    }
}
