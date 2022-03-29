package com.example.service.impl;

import com.example.service.ICurrencyService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements ICurrencyService {

    @Override
    public Double conversion(Double usd, Double rate) {
        return usd * rate ;
    }
}
