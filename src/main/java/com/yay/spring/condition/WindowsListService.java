package com.yay.spring.condition;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/9 13:59
 */
public class WindowsListService implements ListService {

    @Override
    public String showCmd() {
        return "dir";
    }
}
