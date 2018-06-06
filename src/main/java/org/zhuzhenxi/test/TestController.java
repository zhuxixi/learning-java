package org.zhuzhenxi.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zhuzhenxi.test.Service.TestCacheService;

import java.util.List;

/**
 * @author zhuzhenxi
 * @date 2018.06.06
 */
@RestController
public class TestController {

    @Autowired
    private TestCacheService testCacheService;

    @RequestMapping(value = "/put",method = RequestMethod.GET)
    public String putValue(String param){
        return testCacheService.putValue(param);
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public String queryValue(String param){
        return testCacheService.queryValue(param);
    }

    @RequestMapping(value = "/multiplePut",method = RequestMethod.GET)
    public List<String> putValue(String param1,String param2){
        List<String> list = testCacheService.putMultipleValue(param1,param2);
        return list;
    }

    @RequestMapping(value = "/multipleQuery",method = RequestMethod.GET)
    public List<String> queryValue(String param1,String param2){
        return testCacheService.queryMultipleValue(param1,param2);
    }
}
