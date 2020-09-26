package com.backendentwickler.springbootrestapi;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.backendentwickler.springbootrestapi.controller.RestController;
import com.backendentwickler.springbootrestapi.service.TreatmentService;
import net.minidev.json.parser.JSONParser;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@WebMvcTest(RestController.class)
@Import(AopAutoConfiguration.class)

public class WebMockTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;



    @Test
    public void resultFromService() throws Exception {

//        this.mockMvc.perform(get("/api/v1/").param("nbr", "5")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Fizz")));



        String uri = "/api/v1/";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).param("nbr", "5")
                .accept(MediaType.ALL)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.contains("Buzz"));

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).param("nbr", "9")
                .accept(MediaType.ALL)).andReturn();
        status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.contains("Fizz"));

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).param("nbr", "0")
                .accept(MediaType.ALL)).andReturn();
        status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.contains("FizzBuzz"));
    }



}
