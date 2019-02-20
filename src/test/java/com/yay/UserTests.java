package com.yay;

import com.yay.web.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2016/12/26 19:58
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class UserTests {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();

    }


    @Test
    public void testUserController() throws Exception {
        RequestBuilder request = null;

        //获取列表
        request = get("/users/");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));

        //post user
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("id", "1");
        paramMap.put("name", "测试大师");
        paramMap.put("age", "20");
        request = post("/users/").contentType(MediaType.APPLICATION_JSON).content(paramMap.toString());

        mvc.perform(request).andExpect(content().string(equalTo("success")));

        //再获取列表
        request = get("/users/");
        mvc.perform(request).andDo(result -> System.out.println(result.getResponse().getContentAsString()));

        //更新值
        request = put("/users/1")
                .param("name", "测试终极大师")
                .param("age", "30");
        mvc.perform(request).andExpect(content().string(equalTo("success")));


        // 5、get一个id为1的user
        request = get("/users/1");
        mvc.perform(request).andDo(result -> System.out.println(result.getResponse().getContentAsString()));


        // 6、del删除id为1的user
        request = delete("/users/1");
        mvc.perform(request).andExpect(content().string(equalTo("success")));

        request = get("/users/");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
    }
}
