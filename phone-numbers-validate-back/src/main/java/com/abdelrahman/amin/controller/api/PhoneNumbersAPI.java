package com.abdelrahman.amin.controller.api;

import com.abdelrahman.amin.dto.PageResponse;
import com.abdelrahman.amin.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/phone-number")
@CrossOrigin(origins = "http://localhost:3000")
public interface PhoneNumbersAPI {
    @GetMapping("/country/{countryName}/valid")
    PageResponse<List<Customer>> getAllValidNumbersByCountry(@PathVariable String countryName, @RequestParam(value = "pageNumber", required = false) Integer pageNumber);

    @GetMapping("/country/{countryName}/not-valid")
    PageResponse<List<Customer>> getAllNotValidPhoneByCountry(@PathVariable String countryName, @RequestParam(value = "pageNumber", required = false) Integer pageNumber);

    @GetMapping("/country/{countryName}")
    PageResponse<List<Customer>> getAllCountryPhones(@PathVariable String countryName, @RequestParam(value = "pageNumber", required = false) Integer pageNumber);


    @GetMapping()
    PageResponse<List<Customer>> getAll(Integer pageNumber);


}
