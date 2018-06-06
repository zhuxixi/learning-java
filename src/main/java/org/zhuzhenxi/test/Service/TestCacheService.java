package org.zhuzhenxi.test.Service;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;

import java.util.List;

public interface TestCacheService {

    String queryValue(String param);

    String putValue(String param);

    List<String> queryMultipleValue(String param1, String param2);

    List<String> putMultipleValue(String param1,String param2);
}
