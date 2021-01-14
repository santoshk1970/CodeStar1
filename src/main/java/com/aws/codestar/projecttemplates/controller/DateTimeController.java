package com.aws.codestar.projecttemplates.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * Basic Spring MVC controller that handles all GET requests.
 */
@Controller
@RequestMapping("/getDatTime")
public class DateTimeController {

    private final String siteName;

    public DateTimeController(final String siteName) {
        this.siteName = siteName;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView datTime() {
       var now = LocalDateTime.now();
        var dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        var date_time = dtf.format(now);

        var params = new HashMap<String, Object>();
        params.put("date_time", date_time);
        ModelAndView mav = new ModelAndView("index");//comment
        mav.addObject("siteName", "Different site");
        return mav;
       // return new ModelAndView("showMessage", params);
    }
   

}
