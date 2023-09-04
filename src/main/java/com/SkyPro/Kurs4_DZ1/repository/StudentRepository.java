package com.SkyPro.Kurs4_DZ1.repository;

import com.SkyPro.Kurs4_DZ1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findAllByAge(Integer age);
    List<Student> findAllByAgeBetween(int min, int max);
    List<Student> findAllByFaculty_Id (Long facultyId);
    @Query(value = "select count(*) from student",nativeQuery = true)
    long countStudents();
    @Query(value = "select avg(age) from student",nativeQuery = true)
    double averegeAge();
    @Query(value = "select * from student order by id desc limit :quntity",nativeQuery = true)
    List<Student> findLastStudents(@Param("quantity") int n);
}
