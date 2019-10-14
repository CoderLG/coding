package lg.controller;

import io.swagger.annotations.Api;
import lg.common.RestError;
import lg.dvo.ImageParams;
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
@Api(tags = "异常测试",description = "imageName或者geo任何一个为空，返回参数异常; " +
                                        "geo输入123，返回DMDefinedException；" +
        "                            imageName，返回GeoDataDefinedException；")
public class ExceptionController {
    @GetMapping("/demo/")
    public ResponseEntity<ImageParams> sayHello(@Valid ImageParams imageParams) {
        if (imageParams.getGeo().equals("123")) {
            throw new GeoException();
        } else if(imageParams.getGeo().equals("456")){
            throw new ImageException(RestError.INPUT_ERROR.getCode(),RestError.INPUT_ERROR.getMessage());
        }else{
            return ResponseEntity.ok(imageParams);
        }
    }


}
