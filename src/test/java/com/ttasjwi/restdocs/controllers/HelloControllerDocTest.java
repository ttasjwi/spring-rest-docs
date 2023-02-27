package com.ttasjwi.restdocs.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs // rest docs 자동 설정
class HelloControllerDocTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Hello가 실행된다.")
    public void testHello() throws Exception {
        // expected
        this.mockMvc.perform(get("/hello")
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"))
                .andDo(print())
                .andDo(document("hello"));
    }

}
