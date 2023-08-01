package com.szaruga.myapp.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static com.szaruga.myapp.myenum.MyStringsTest.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;


@SpringBootTest
@AutoConfigureMockMvc
class MembersRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void httpRequestWithOutAuthentication() throws Exception {
        mockMvc.perform(get(API_ENDPOINT.myString + MEMBERS_ENDPOINT.myString))
                .andDo(print())
                .andExpect(status().is(401));
    }

    @Test
    void httpRequestWithUserAuthentication() throws Exception {
        mockMvc.perform(get(API_ENDPOINT.myString + MEMBERS_ENDPOINT.myString)
                        .with(httpBasic(USER.myString, USER_PASSWORD.myString)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void httpRequestWithManagerAuthentication() throws Exception {
        mockMvc.perform(get(API_ENDPOINT.myString + MEMBERS_ENDPOINT.myString)
                        .with(httpBasic(MANAGER.myString, MANAGER_PASSWORD.myString)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void httpRequestWithAdminAuthentication() throws Exception {
        mockMvc.perform(get(API_ENDPOINT.myString + MEMBERS_ENDPOINT.myString)
                        .with(httpBasic(ADMIN.myString, ADMIN_PASSWORD.myString)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void findAll() throws Exception {

    }

    @Test
    void addMember() {
    }

    @Test
    void deleteMember() {
    }

    @Test
    void getMemberWithItems() {
    }
}