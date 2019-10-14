package lg.controller;

import lg.common.RestError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: LG
 * date: 2019-09-29 19:11
 * desc:
 */
@RestController
public class EnumController {

    @GetMapping("setReason")
    public String setReason(){
//        RestError ss = RestError.INPUT_ERROR.setReason("这样用正确么");
//        System.out.println(ss.getReason());
        return  RestError.INPUT_ERROR.toString();
    }

    @GetMapping("getReasonRes")
    public RestError getReasonRes(){
        return  RestError.INPUT_ERROR;
    }

    @GetMapping("getReasonStr")
    public String getReasonStr(){
        return  RestError.INPUT_ERROR.toString();
    }

}
