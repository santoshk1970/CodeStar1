package net.amznsantosh.transform.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;

import net.amznsantosh.transform.model.DataToBeProtected;
import net.amznsantosh.transform.service.DataProtector;

/**
 * Basic Spring MVC controller that handles all GET requests.
 */
@Controller
public class TransformAWSLambdaController {

	@Autowired	
	private DataProtector dataProtector;
    private final String siteName;
    public TransformAWSLambdaController(final String siteName) {
        this.siteName = siteName;
    }
    @RequestMapping("/")
    public ModelAndView helloWorld() {
        ModelAndView mav = new ModelAndView("index");//comment
        mav.addObject("siteName", this.siteName);
        return mav;
    }
    @RequestMapping(method=RequestMethod.GET, value="/sensitive")
    public ModelAndView sensitive() {
         ModelAndView mav = new ModelAndView("sensitive");
         mav.addObject("dataToBeProtected", new DataToBeProtected());
        return mav;
      
    }
    @ModelAttribute("dataElementsList")
    public Map<String, String> getCountryList() {
       Map<String, String> dataElementsList = new HashMap<String, String>();
       dataElementsList.put("alpha", "Alphanumeric");
       dataElementsList.put("num", "Number");
       dataElementsList.put("ssn", "Social security number");
       return dataElementsList;
    }
    /*
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
 */
 @RequestMapping(method = RequestMethod.POST, value="/protect")
 public ModelAndView processProtection(@ModelAttribute("dataToBeProtected") DataToBeProtected dataToBeProtected,
         Map<String, Object> model) throws JsonProcessingException {
 	 ModelAndView mav = new ModelAndView("result");//comment
	 mav.addObject("original_value", dataToBeProtected.getClearValue()); 
	 mav.addObject("transformed_value", dataProtector.transform(dataToBeProtected));
     return mav;
    
    }
}
