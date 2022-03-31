package com.codegym.repository;

import com.codegym.models.MedicalDeclaration;

import java.util.List;

public interface IMedicalRepository {
    List<MedicalDeclaration> findAll();

    void save(MedicalDeclaration medicalDeclaration);

    MedicalDeclaration findById(Integer id);

    void update(MedicalDeclaration medicalDeclaration);
}
