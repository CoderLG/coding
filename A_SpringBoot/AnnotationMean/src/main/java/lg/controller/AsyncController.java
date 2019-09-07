package lg.controller;

import lg.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author: LG
 * date: 2019-08-18 14:25
 * desc:
 */
@Slf4j
@Controller
public class AsyncController {

    @Autowired
    private AsyncService asyncService;
    @Value("${name}")
    private String name;
    @Value("${url}")
    private String url;



    @RequestMapping("/getAsync")
    @ResponseBody
    public String getAsync(){

        System.out.println("1");
        asyncService.getAsync();
        System.out.println("4");
        return "suss";
    }

    @RequestMapping("/getAppName")
    @ResponseBody
    public String getAppName(){
        return name;
    }

    @RequestMapping("/getUrl")
    @ResponseBody
    public String getUrl(){
        return url;
    }

}
