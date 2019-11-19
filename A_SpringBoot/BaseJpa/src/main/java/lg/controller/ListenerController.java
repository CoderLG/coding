package lg.controller;

import lg.customListener.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: LG
 * date: 2019-10-31 17:07
 * desc:
 */
@RestController
public class ListenerController {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @GetMapping("testListener")
    public String testListener(){
        applicationContext.publishEvent(new MyEvent("测试事件"));
        return "ok";
    }

}
