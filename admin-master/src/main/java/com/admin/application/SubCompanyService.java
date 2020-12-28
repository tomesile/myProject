package com.admin.application;

import com.admin.domain.modle.SubCompany;
import com.admin.infrastructure.persistence.jdbc.SubCompanyRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class SubCompanyService {
    @Autowired
    protected SubCompanyRepositoryJPA subCompanyRepositoryJPA;
    @Modifying
    @Query("UPDATE SubCompany sc set sc.name=:name where sc.id=:id")
     public void update(SubCompany subCom)
     {
         subCompanyRepositoryJPA.save(subCom);
     }

     public void delete(SubCompany subCom)
     {
         subCompanyRepositoryJPA.delete(subCom);
     }

     public void deleteById(int id)
    {
        subCompanyRepositoryJPA.delete(id);
    }
}
