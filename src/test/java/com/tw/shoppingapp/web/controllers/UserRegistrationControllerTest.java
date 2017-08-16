package com.tw.shoppingapp.web.controllers;

import com.tw.shoppingapp.gateways.user.inmemory.UserRepository;
import com.tw.shoppingapp.usecases.userregistration.UserRegistrationUseCase;
import com.tw.shoppingapp.usecases.userregistration.UserRegistrationUseCaseRequest;
import com.tw.shoppingapp.usecases.userregistration.UserRegistrationUseCaseResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.FileCopyUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(UserRegistrationController.class)
public class UserRegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRegistrationUseCase userRegistrationUseCase;

    @MockBean
    private UserRepository userRepository;


    @Test
    public void givenValidUserRegistrationRequest_whenExecuted_thenReturnSuccessfullResponse() throws Exception {
        when(this.userRegistrationUseCase
                .execute(any(UserRegistrationUseCaseRequest.class)))
                .thenReturn(getValidUserRegistrationUseCaseResponse());
        this.mockMvc
                .perform(post("/user/register")
                        .contentType(APPLICATION_JSON)
                        .content(getUserRegistrationString("src/test/resources/__files/user-registration-details.json")))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"isRegistrationSuccessful\" : true}"));
    }

    @Test
    public void givenInValidUserRegistrationRequest_whenExecuted_thenReturn4XX() throws Exception {
        when(this.userRegistrationUseCase
                .execute(any(UserRegistrationUseCaseRequest.class)))
                .thenReturn(getValidUserRegistrationUseCaseResponse());
        this.mockMvc
                .perform(post("/user/register")
                        .contentType(APPLICATION_JSON)
                        .content(getUserRegistrationString("src/test/resources/__files/invalid-user-registration-details.json")))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void givenValidUserRegistrationRequestWithInvalidMapping_whenExecuted_thenReturn4XX() throws Exception {
        when(this.userRegistrationUseCase
                .execute(any(UserRegistrationUseCaseRequest.class)))
                .thenReturn(getValidUserRegistrationUseCaseResponse());
        this.mockMvc
                .perform(post("/user/invalid")
                        .contentType(APPLICATION_JSON)
                        .content(getUserRegistrationString("src/test/resources/__files/user-registration-details.json")))
                .andExpect(status().is4xxClientError());
    }

    private UserRegistrationUseCaseResponse getValidUserRegistrationUseCaseResponse() {
        return new UserRegistrationUseCaseResponse(true);
    }

    private String getUserRegistrationString(String filePath) throws Exception {
        return FileCopyUtils.copyToString(
                new BufferedReader(new InputStreamReader(
                        new FileInputStream(new File(filePath)))));
    }
}