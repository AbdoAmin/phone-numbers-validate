package com.abdelrahman.amin.impl;

import com.abdelrahman.amin.dto.PageResponse;
import com.abdelrahman.amin.entity.Country;
import com.abdelrahman.amin.entity.Customer;
import com.abdelrahman.amin.repository.CountryRepository;
import com.abdelrahman.amin.repository.CustomerRepository;
import com.abdelrahman.amin.service.impl.CustomerServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CountryRepository countryRepository;
    @InjectMocks
    private CustomerServiceImpl customerService;
    private Page<Customer> customerPage;
    private Optional<Country> country;

    @Before
    public void setUp() {

        country = Optional.of(new Country());
        country.get().setName("test");
        country.get().setPhoneRegex("test");
        customerPage = Page.empty();

    }

    @Test
    public void getCustomersByCountryRegex_GetFirstPageByCountryValid_ReturnPageResponse() {
        when(countryRepository.getByName(Mockito.anyString())).thenReturn(country);
        when(customerRepository.getAllByPhoneRegex(Mockito.anyString(),Mockito.any(Pageable.class))).thenReturn(customerPage);
        PageResponse<List<Customer>> customersPageResponse = customerService.getCustomersByCountryRegex("test",0);
        assertEquals(0, customersPageResponse.getPage().intValue());
    }

    @Test
    public void getAllNotValidPhoneByCountry_GetFirstPageByCountryNotValid_ReturnPageResponse() {
        when(countryRepository.getByName(Mockito.anyString())).thenReturn(country);
        when(customerRepository.getAllNotValidPhoneByCountry(Mockito.anyString(),Mockito.anyString(),Mockito.any(Pageable.class))).thenReturn(customerPage);
        PageResponse<List<Customer>> customersPageResponse = customerService.getAllNotValidPhoneByCountry("test",0);
        assertEquals(0, customersPageResponse.getPage().intValue());
    }

    @Test
    public void getAllCountryPhones_GetFirstPageByCountry_ReturnPageResponse() {
        when(countryRepository.getByName(Mockito.anyString())).thenReturn(country);
        when(customerRepository.getAllByPhoneLike(Mockito.anyString(),Mockito.any(Pageable.class))).thenReturn(customerPage);
        PageResponse<List<Customer>> customersPageResponse = customerService.getAllCountryPhones("test",0);
        assertEquals(0, customersPageResponse.getPage().intValue());
    }

    @Test
    public void getAllPhoneNumbers_GetFirstPage_ReturnPageResponse() {
        when(customerRepository.findAll(Mockito.any(Pageable.class))).thenReturn(customerPage);
        PageResponse<List<Customer>> customersPageResponse = customerService.getAllPhoneNumbers(0);
        assertEquals(0, customersPageResponse.getPage().intValue());
    }
}