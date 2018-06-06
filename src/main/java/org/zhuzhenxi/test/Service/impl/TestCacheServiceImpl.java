package org.zhuzhenxi.test.Service.impl;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.zhuzhenxi.test.Service.TestCacheService;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

@Service
@CacheConfig
public class TestCacheServiceImpl implements TestCacheService {

    private static String value = "";

    private static List<String> valueList = new ArrayList<>();

    @Cached(name="testCache-", key="#param",expire = 1,timeUnit = TimeUnit.MINUTES,cacheType = CacheType.LOCAL,area = "default")
    @Override
    public String queryValue(String param) {
        System.out.println("进入了queryValue方法体");
        return value;
    }
    @CacheUpdate(name="testCache-", key="#param",value = "#result",area = "default")
    @Override
    public String putValue(String param) {
        System.out.println("进入了putValue方法体");
        value = param+"321321321";
        return value;
    }

    @Cached(name="testCache-", key="#param1+#param2",expire = 1,timeUnit = TimeUnit.MINUTES,cacheType = CacheType.LOCAL,area = "default")
    @Override
    public List<String> queryMultipleValue(String param1, String param2) {
        System.out.println("进入了queryMultipleValue方法体");
        return valueList;
    }

    @CacheUpdate(name="testCache-", key="#param1+#param2",value = "#result",area = "default")
    @Override
    public List<String> putMultipleValue(String param1, String param2) {
        System.out.println("进入了putMultipleValue方法体");
        valueList.add(param1+param2);
        return valueList;
    }
}
