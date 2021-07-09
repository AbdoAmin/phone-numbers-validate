package com.abdelrahman.amin.controller;

import com.abdelrahman.amin.controller.api.PhoneNumbersAPI;
import com.abdelrahman.amin.dto.PageResponse;
import com.abdelrahman.amin.entity.Customer;
import com.abdelrahman.amin.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class PhoneNumbersController implements PhoneNumbersAPI {

    private CustomerService customerService;

    @Override
    public PageResponse<List<Customer>> getAllValidNumbersByCountry(String countryName, Integer pageNumber) {
        return customerService.getCustomersByCountryRegex(countryName, pageNumber);
    }

    @Override
    public PageResponse<List<Customer>> getAllNotValidPhoneByCountry(String countryName, Integer pageNumber) {
        return customerService.getAllNotValidPhoneByCountry(countryName, pageNumber);
    }

    @Override
    public PageResponse<List<Customer>> getAllCountryPhones(String countryName, Integer pageNumber) {
        return customerService.getAllCountryPhones(countryName, pageNumber);
    }

    @Override
    public PageResponse<List<Customer>> getAll(Integer pageNumber) {
        return customerService.getAllPhoneNumbers(pageNumber);
    }
}
