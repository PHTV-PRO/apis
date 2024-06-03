package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployerRepo extends JpaRepository<Employer,Integer> {
    @Query("select e from Employer e Where id = ?1")
    Employer findIdEmployer(int id);

    Employer getEmployerById(int id);

}
