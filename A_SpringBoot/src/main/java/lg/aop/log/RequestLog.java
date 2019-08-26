package lg.aop.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * author: LG
 * date: 2019-08-18 12:51
 * desc:
 */

@Component
public class RequestLog {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    public void doBefore() throws Throwable{

    }
}
