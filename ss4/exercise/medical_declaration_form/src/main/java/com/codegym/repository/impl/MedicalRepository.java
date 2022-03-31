package com.codegym.repository.impl;

import com.codegym.models.MedicalDeclaration;
import com.codegym.repository.IMedicalRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class MedicalRepository implements IMedicalRepository {
    private  static List< MedicalDeclaration> declarationList = new ArrayList<>();
    static int autoIncrease = 0 ;

    static {
        MedicalDeclaration declaration = new MedicalDeclaration(autoIncrease++,"NGUYỄN A",1996,
                "Nam","Việt Nam",201938475,"Tàu bay","VN-115","21D",
                "30-03-2021","31-03-2021","HCM","Đà Nẵng","Cẩm Lệ",
                "Hòa Thọ Đông","198 Lê Lợi","0901928394","long@gmail.com");
        MedicalDeclaration declaration1 = new MedicalDeclaration(autoIncrease++,"NGUYỄN B",1990,
                "Nam","Việt Nam",201984775,"Tàu bay","VN-125","12D",
                "12-03-2021","13-03-2021","Hà Nội","Đà Nẵng","Hải Châu",
                "Hòa Cường","198 Lê Lợi","0901987394","b@gmail.com");
        declarationList.add(declaration);
        declarationList.add(declaration1);
    }

    @Override
    public List<MedicalDeclaration> findAll() {
        return declarationList;
    }

    @Override
    public void save(MedicalDeclaration medicalDeclaration) {
        medicalDeclaration.setId(autoIncrease++);
        declarationList.add(medicalDeclaration);
    }
}
