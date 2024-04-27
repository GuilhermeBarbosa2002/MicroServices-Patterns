package com.example.apiExterna.Client;

import com.example.apiExterna.DTO.ClubDTO;
import com.example.apiExterna.DTO.ParentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
@FeignClient(name = "club-service", url = "${application.config.clubs-url}")
public interface ClubClient {

    @GetMapping
    ResponseEntity<List<ClubDTO>> getAllClubs();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Integer addClub(@RequestBody ClubDTO clubDTO);
}
