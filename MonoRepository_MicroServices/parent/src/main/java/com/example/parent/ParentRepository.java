package com.example.parent;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParentRepository extends JpaRepository<Parent, Integer> {

    List<Parent> findAllByTown(Integer townId);

}
