package com.aws.codestar.projecttemplates.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aws.codestar.projecttemplates.model.DataToBeProtected;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * Basic Spring MVC controller that handles all GET requests.
 */
@Controller
public class HelloWorldController {

    private final String siteName;
    
   // @Autowired
   // private DataProtector dataProtector;

    public HelloWorldController(final String siteName) {
        this.siteName = siteName;
    }
    @RequestMapping("/")
    public ModelAndView helloWorld() {
        ModelAndView mav = new ModelAndView("index");//comment
        mav.addObject("siteName", this.siteName);
        return mav;
    }
   
 @RequestMapping("/protect")
    public ModelAndView getDateTime() {
       var now = LocalDateTime.now();
        var dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        var date_time = dtf.format(now);

        var params = new HashMap<String, Object>();
        params.put("date_time", date_time);
        ModelAndView mav = new ModelAndView("result");//comment
        mav.addObject("date_time", date_time);
        return mav;
       // return new ModelAndView("showMessage", params);
    }
 
 @RequestMapping(method = RequestMethod.POST, value="/protect")
 public ModelAndView processProtection(@ModelAttribute("dataToBeProtected") DataToBeProtected dataToBeProtected,
         Map<String, Object> model) {
 
	 ModelAndView mav = new ModelAndView("result");//comment
     mav.addObject("date_time", dataToBeProtected.getClearValue());
     return mav;
    
    }
}
