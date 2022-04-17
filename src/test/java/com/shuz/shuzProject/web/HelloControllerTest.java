package com.shuz.shuzProject.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)	// {2}
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired    // {4}
    private MockMvc mvc;	// {5}

    @Test
    public void hello로_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))		// {6}
                .andExpect(status().isOk())		// {7}
                .andExpect(content().string(hello));	//{8}
    }
}
