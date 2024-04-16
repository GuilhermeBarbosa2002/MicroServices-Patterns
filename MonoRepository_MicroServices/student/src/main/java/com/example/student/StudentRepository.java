package com.example.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository  extends JpaRepository<Student, Integer >{

    List<Student> findAllByParent(Integer parentId);

    List<Student> findAllByTown(Integer townId);
}
