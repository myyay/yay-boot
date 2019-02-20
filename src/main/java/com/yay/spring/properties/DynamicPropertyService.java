package com.yay.spring.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/17 13:51
 */
@Service
//@PropertySource(DynamicPropertyConfig.DYNAMIC_CONFIG_NAME)
@Scope(SCOPE_PROTOTYPE)
public class DynamicPropertyService {

    @Value("${dynamicInfo}")
    private String dynamicInfo;

    public void print() {
        System.out.println("dynamicInfo:" + dynamicInfo);
    }

}
