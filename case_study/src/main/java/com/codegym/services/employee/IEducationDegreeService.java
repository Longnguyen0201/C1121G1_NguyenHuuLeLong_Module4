package com.codegym.services.employee;

import com.codegym.model.employee.EducationDegree;

import java.util.List;

public interface IEducationDegreeService {
    List<EducationDegree> findAll();
}
