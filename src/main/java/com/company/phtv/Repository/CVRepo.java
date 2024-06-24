package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface CVRepo extends JpaRepository<CurriculumVitae,Integer> {
    List<CurriculumVitae> findByAccount(Account account);
}
