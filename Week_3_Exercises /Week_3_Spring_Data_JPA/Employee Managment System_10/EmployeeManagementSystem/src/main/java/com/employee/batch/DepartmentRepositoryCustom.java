package com.employee.batch;

import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employee.entity.Department;

import java.util.List;

@Repository
public class DepartmentRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void batchInsertDepartments(List<Department> departments) {
        int batchSize = 20;
        for (int i = 0; i < departments.size(); i++) {
            entityManager.persist(departments.get(i));
            if (i > 0 && i % batchSize == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
    }
}
