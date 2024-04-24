package com.example.parent;

import com.example.town.Town;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParentRepository extends JpaRepository<Parent, Integer> {

    Optional<Parent> findParentByEmail(String email);

}
