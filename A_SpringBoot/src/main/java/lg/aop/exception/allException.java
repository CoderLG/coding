package lg.aop.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * author: LG
 * date: 2019-08-17 16:43
 * desc:
 *
 * @ControllerAdvice()
 * 定义全局异常处理类
 *
 * @ControllerAdvice(basePackages = "lg.controller")
 * 可以指定一个
 *
 * @ExceptionHandler
 * 声明异常处理方法
 *
 */

@ControllerAdvice()
//@ControllerAdvice(basePackages = "lg.controller")
@ResponseBody
public class allException {

    @ExceptionHandler
    public Map<String,Object> ioException(IOException e){
        Map<String,Object> map = new HashMap<>();
        map.put("code",500);
        map.put("exce",e);
        return  map;
    }

    @ExceptionHandler
    public Map<String,Object> exception(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code",500);
        map.put("mas","未知错误，给管理员发送邮件");
        map.put("exce",e.toString());
        return  map;
    }
}
