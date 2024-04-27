package com.example.apiExterna.Client;

import com.example.apiExterna.DTO.Club;
import com.example.apiExterna.DTO.Student;
import com.example.apiExterna.DTO.Town;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "club-service", url = "${application.config.clubs-url}")
public interface ClubClient {

    @GetMapping
    ResponseEntity<List<Club>> getAllClubs();



}
