package com.SkyPro.Kurs4_DZ1.repository;

import com.SkyPro.Kurs4_DZ1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findAllByAge(Integer age);
    List<Student> findAllByAgeBetween(int min, int max);
    List<Student> findAllByFaculty_Id (Long facultyId);
}
