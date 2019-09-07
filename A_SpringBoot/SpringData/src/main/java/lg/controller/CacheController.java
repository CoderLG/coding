package lg.controller;

import io.swagger.annotations.Api;
import lg.service.CachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * author: LG
 * date: 2019-09-05 13:31
 * desc:
 */
@RestController
@Api(tags = "缓存原理测试")
public class CacheController {

    @Autowired
    private CachingService cachingService;

    @GetMapping("addCache")
    public void addCache(String key, String value) {
        cachingService.addMap(key,value);
    }

    @GetMapping("getCache")
    public Map getCache() {
        return cachingService.getMap();
    }
}
