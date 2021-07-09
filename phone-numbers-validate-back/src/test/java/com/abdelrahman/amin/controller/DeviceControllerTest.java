package com.abdelrahman.amin.controller;

import com.abdelrahman.amin.dto.PageResponse;
import com.abdelrahman.amin.entity.Customer;
import com.abdelrahman.amin.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DeviceControllerTest {
    @Mock
    public CustomerService customerService;
    @InjectMocks
    public PhoneNumbersController phoneNumbersController;

    private PageResponse<List<Customer>> pageResponse;


    @Before
    public void setUp() {
        pageResponse = new PageResponse<>(new ArrayList<>(),0,0,0L);

    }

    @Test
    public void getAllValidNumbersByCountry_GetValidByCounty_ReturnPageResponse() {
        Mockito.when(customerService.getCustomersByCountryRegex(Mockito.anyString(),Mockito.anyInt())).thenReturn(pageResponse);
        PageResponse<List<Customer>> customers = phoneNumbersController.getAllValidNumbersByCountry("test", 0);

        assertEquals(0, customers.getPage().intValue());
    }

    @Test
    public void getAllNotValidPhoneByCountry_GetNotValidByCountry_ReturnPageResponse() {
        Mockito.when(customerService.getAllNotValidPhoneByCountry(Mockito.anyString(),Mockito.anyInt())).thenReturn(pageResponse);
        PageResponse<List<Customer>> customers = phoneNumbersController.getAllNotValidPhoneByCountry("test", 0);
        assertEquals(0, customers.getPage().intValue());
    }
    @Test
    public void getAllCountryPhones_GetByCounty_ReturnPageResponse() {
        Mockito.when(customerService.getAllCountryPhones(Mockito.anyString(),Mockito.anyInt())).thenReturn(pageResponse);
        PageResponse<List<Customer>> customers = phoneNumbersController.getAllCountryPhones("test", 0);
        assertEquals(0, customers.getPage().intValue());
    }
    @Test
    public void getAllValidNumbersByCountry_GetByCounty_ReturnPageResponse() {
        Mockito.when(customerService.getAllPhoneNumbers(Mockito.anyInt())).thenReturn(pageResponse);
        PageResponse<List<Customer>> customers = phoneNumbersController.getAll(0);
        assertEquals(0, customers.getPage().intValue());
    }

}