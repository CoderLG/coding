package lg.controller;

import lg.entity.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.Map;

/**
 * author: LG
 * date: 2019-08-20 12:26
 * desc:
 */
@Slf4j
@Controller
public class ResultController {

    @RequestMapping("getResponse")
    @ResponseBody
    public ResponseEntity getRes(){


        Map<String, Object> returnError = new HashMap();
        returnError.put("code", "200");
        returnError.put("message", "mess");
        log.info("info",returnError);
        log.warn("warn",returnError);
        log.error("error",returnError);

        return  new ResponseEntity(returnError,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping("getResponseEntity")
    @ResponseBody
    public ResponseEntity<ResultEntity> getResponseEntity(){
        Map<String, Object> returnError = new HashMap();
        returnError.put("code", "200");
        returnError.put("mes", "mess");
        ResultEntity result = new ResultEntity();
        result.setCode("200");
        result.setMessage("true");
        return  ResponseEntity.ok(result);
    }
}
