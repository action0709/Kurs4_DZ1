package com.SkyPro.Kurs4_DZ1.repository;

import com.SkyPro.Kurs4_DZ1.model.Avatar;
import com.SkyPro.Kurs4_DZ1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AvatarRepository extends JpaRepository <Avatar,Long>{
    Optional<Avatar> findByStudent (Student student);


}
