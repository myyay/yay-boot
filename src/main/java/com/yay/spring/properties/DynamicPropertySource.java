package com.yay.spring.properties;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.MapPropertySource;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/17 11:17
 */
public class DynamicPropertySource extends MapPropertySource {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static Map<String, Object> map = new ConcurrentHashMap<>(16);

    private static ScheduledExecutorService scheduledService = new ScheduledThreadPoolExecutor(1,
            new BasicThreadFactory.Builder().namingPattern("my-schedule-pool-%d").daemon(false).build());

    static {
        map.put("dynamicInfo", "init");
        scheduledService.scheduleAtFixedRate(() -> {
            map = dynamicLoadMapInfo();
            System.out.println("设置Map");
        }, 1, 1, TimeUnit.SECONDS);
    }

    public DynamicPropertySource(String name) {
        super(name, map);
    }

    @Override
    public Object getProperty(String name) {
        return map.get(name);
    }


    @Override
    public boolean containsProperty(String name) {
        return map.containsKey(name);
    }

    @Override
    public String[] getPropertyNames() {
        return map.keySet().toArray(new String[0]);
    }

    private static Map<String, Object> dynamicLoadMapInfo() {
        Map<String, Object> m = new ConcurrentHashMap<>(16);
        int randomData = RandomUtils.nextInt(0, 100);
        m.put("dynamicInfo", randomData);
        return m;
    }

}
