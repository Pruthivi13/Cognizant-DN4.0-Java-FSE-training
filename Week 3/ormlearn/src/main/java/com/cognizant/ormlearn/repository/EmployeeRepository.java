package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e LEFT JOIN FETCH e.department d LEFT JOIN FETCH e.skillList WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    @Query(value="SELECT AVG(e.salary) FROM Employee e")
    double getAverageSalary();

    @Query(value="SELECT AVG(e.salary) FROM Employee e where e.department.id = :id")
    double getAverageSalary(@Param("id") int id);

    @Query(value="SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();

    @Query(value="SELECT e.* FROM employee e LEFT JOIN employee_skill es ON e.em_id = es.es_em_id LEFT JOIN skill s ON es.es_sk_id = s.sk_id", nativeQuery = true)
    List<Employee> getAllEmployeesNativeWithSkills();
}
