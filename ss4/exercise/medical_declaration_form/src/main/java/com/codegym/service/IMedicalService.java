package com.codegym.service;

import com.codegym.models.MedicalDeclaration;

import java.util.List;

public interface IMedicalService {
    List<MedicalDeclaration> findAll();
}
