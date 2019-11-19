package lg.controller;

import io.swagger.annotations.Api;
import lg.common.RestError;
import lg.dvo.ImageParams;
import lg.exception.CommonException;
import lg.exception.GeoException;
import lg.exception.ImageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;



@RestController
@RequestMapping("/exceptionController")
@Slf4j
@Api(tags = "异常测试")
public class ExceptionController {
    @GetMapping("/demo/")
    public ResponseEntity<ImageParams> sayHello(@Valid ImageParams imageParams) {
        if (imageParams.getGeo().equals("123")) {
            throw new GeoException();
        } else if(imageParams.getGeo().equals("456")){
            throw new ImageException(RestError.INPUT_ERROR.getCode(),RestError.INPUT_ERROR.getMessage());
        }else if(imageParams.getGeo().equals("789")){
           //自己分风格的异常处理
            CommonException commonException = new CommonException(RestError.INPUT_ERROR.toString());
            log.error("自己异常的处理方法",commonException);
            throw commonException;
        }else{
            return ResponseEntity.ok(imageParams);
        }

    }


}
