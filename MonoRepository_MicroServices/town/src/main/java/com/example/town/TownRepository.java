package com.example.town;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TownRepository extends JpaRepository<Town, Integer > {
    Optional<Town> findTownByName(String name);

}
