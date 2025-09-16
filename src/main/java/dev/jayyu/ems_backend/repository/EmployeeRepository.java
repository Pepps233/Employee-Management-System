package dev.jayyu.ems_backend.repository;

import dev.jayyu.ems_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// JpaRepository<entity class, type of primary key
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
