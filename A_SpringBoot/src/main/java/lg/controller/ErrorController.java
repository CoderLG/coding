package lg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author: LG
 * date: 2019-08-17 12:18
 * desc:
 */
@Controller
public class ErrorController {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);


    @RequestMapping("/getSomeThing")
    @ResponseBody
    public String getSomeThing(){
        logger.info("进入");
        int j = 1/0 ;
        return "suss";
    }

    @RequestMapping("/getName")
    @ResponseBody
    public String getName(){
        return "name";
    }

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "index";
    }


}
