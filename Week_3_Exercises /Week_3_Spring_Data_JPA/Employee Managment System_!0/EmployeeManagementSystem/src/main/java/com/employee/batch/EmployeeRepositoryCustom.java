package com.employee.batch;

import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employee.entity.Employee;

import java.util.List;

@Repository
public class EmployeeRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void batchInsertEmployees(List<Employee> employees) {
        int batchSize = 20;
        for (int i = 0; i < employees.size(); i++) {
            entityManager.persist(employees.get(i));
            if (i > 0 && i % batchSize == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
    }
}
