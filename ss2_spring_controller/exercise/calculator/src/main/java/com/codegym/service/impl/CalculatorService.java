package com.codegym.service.impl;

import com.codegym.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {


    @Override
    public int addition(int number1, int number2) {
        return number1+number2;
    }

    @Override
    public int subtraction(int number1, int number2) {
        return  number1-number2;
    }

    @Override
    public int multiplication(int number1, int number2) {
        return number1*number2;
    }

    @Override
    public int division(int number1, int number2) {
        return number1/number2;
    }
}
