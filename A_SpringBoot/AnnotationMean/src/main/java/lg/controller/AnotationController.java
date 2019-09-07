package lg.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lg.configurer.CarConf;
import lg.configurer.ValueConf;
import lg.entity.ConfCar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * author: LG
 * date: 2019-08-18 18:32
 * desc:
 *
 */

@Controller
@Slf4j
@RequestMapping("/AnyTest")
@Api(tags = "服务基本接口")
public class AnotationController {
    @Autowired
    private ConfCar confCar;

    @Autowired
    private CarConf carConf;

    @Autowired
    private ValueConf valueConf;

    @ResponseBody
    @GetMapping("vluefun")
    public void vluefun(){
        valueConf.Say();
    }


    @ApiOperation(value = "ParamFu", notes = "ParamFu Desc")
    @ResponseBody
    @GetMapping("annotation")
    public int annotation(){
        confCar.setName("yy");
        confCar.setAge("12");
        carConf.sayH();
        return 1;
    }


    @ApiOperation(value = "ParamFu", notes = "ParamFu Desc")
    @ResponseBody
    @GetMapping("ParamFuc")
    public ConfCar ParamFuc(){
        confCar.setName("yy");
        confCar.setAge("12");
        return confCar;
    }


    @ResponseBody
    @DeleteMapping("ParamFu")
    public ConfCar ParamFu(@RequestBody ConfCar car){
        return car;
    }


    @ResponseBody
    @DeleteMapping("ParamFud")
    public int ParamFud(int a){
        return a;
    }


    @ResponseBody
    @PutMapping("ParamFup")
    public int ParamFup(int a){
        return a;
    }

    @ResponseBody
    @PostMapping("ParamFupo")
    public int ParamFupo(int a){
        return a;
    }



    @ApiOperation(value = "ParamF", notes = "ParamF Desc")
    @ResponseBody
    @GetMapping("ParamF")
    public String ParamF(@RequestParam(name = "name",defaultValue = "lg" ,required = true) String name, String age){
        return name +" "+age;
    }


    /**
     * RequestParam
     * 如果不写，按实际名字匹配
     * @param id
     * @param name
     * @param age
     * @return
     */
    @ApiOperation(value = "试用swagger", notes = "swagger的小说明")
    @ResponseBody
    @RequestMapping("indexFunction")
    public String indexFunction(String id,@RequestParam("nameaa")String name, String age){
        return id+" "+name +" "+age;
    }

    /**
     * 写的匹配 没写的 ？后面匹配
     * @param id
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("indexFun/{id1}")
    public String indexFunc(String id,@PathVariable("id1")String name){
        return id+" "+name;
    }


    @ResponseBody
    @RequestMapping("indexF/{id1}/{name}")
    public String indexFun(@PathVariable("name") String id,@PathVariable("id1")String name){
        return id+" "+name;
    }


    @ResponseBody
    @RequestMapping("indexF/{id1}")
    public String indexF(@PathVariable("id1") String id,@RequestParam("name")String name,@RequestParam("orderType")int age ){
        return id+" "+name+" "+age;
    }


    @ResponseBody
    @RequestMapping("/getHttpServletRequest")
    public String getHttpServletRequest( HttpServletRequest request){
        System.out.println("------------");
        String s = request.getRequestURL().toString();
        System.out.println(s);
        return "suss";
    }

    @ResponseBody
    @RequestMapping("/getException")
    public String getException() throws Exception {
        log.info("进入getException");
        if(true)
            throw  new Exception();

        log.info("异常抛出");
        return "suss";
    }

    @ResponseBody
    @RequestMapping("/getException1")
    public String getException1()  {

        try {
            throw  new Exception();
        } catch (Exception e) {
            log.info("进入getException");
            e.printStackTrace();
        }

        log.info("异常抛出");
        return "suss";
    }

    @ResponseBody
    @RequestMapping("/getException2")
    public String getException2() throws Exception {
        log.info("进入getException");

        try {
            if(true)
                throw  new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            log.info("异常抛出");
            throw  new Exception();
        }
        log.info("异常抛出");
        return "suss";
    }



}
