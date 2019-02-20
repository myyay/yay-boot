package com.yay.spring.el;

import java.lang.annotation.*;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/1/12 17:02
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface CheckBefore {

    String[] cProcess() default {"@commonCheck.process(..)"};

    String errorCheckCallBack() default "#this.paramCheckResponse(#paramCheckResponse_result)";
}
