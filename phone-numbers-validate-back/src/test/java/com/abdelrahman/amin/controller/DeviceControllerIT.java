package com.abdelrahman.amin.controller;


import com.abdelrahman.amin.entity.Customer;
import com.abdelrahman.amin.repository.CustomerRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WithMockUser(roles = {"ADMIN"})
@AutoConfigureMockMvc
public class DeviceControllerIT {

    public static final String URL_PREFIX = "/api/v1/phone-number";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer;


    @Before
    public void setUp() {
        customer=new Customer();
        customer.setId(999999);
        customer.setName("test");
        customer.setPhone("(256) 123456789");
        customer = customerRepository.save(customer);
    }
    @After
    public void delete() {
        customerRepository.delete(customer);
    }

    @Test
    public void getAllValidNumbersByCountry_GetValidByCounty_ReturnPageResponse() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get(URL_PREFIX + "/country/Uganda/valid");
        this.mockMvc.perform(requestBuilder).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getAllNotValidPhoneByCountry_GetNotValidByCountry_ReturnPageResponse() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get(URL_PREFIX + "/country/Uganda/not-valid");
        this.mockMvc.perform(requestBuilder).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getAllCountryPhones_GetByCounty_ReturnPageResponse() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get(URL_PREFIX + "/country/Uganda");
        this.mockMvc.perform(requestBuilder).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void getAllValidNumbersByCountry_GetByCounty_ReturnPageResponse() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get(URL_PREFIX);
        this.mockMvc.perform(requestBuilder).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}