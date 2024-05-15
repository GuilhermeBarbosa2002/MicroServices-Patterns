package com.example.apiExterna.Client;

import com.example.apiExterna.DTO.ClubDTO;
import com.example.apiExterna.DTO.ParentDTO;
import com.example.apiExterna.DTO.Town;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(name = "CLUBS", path = "/api/v1/clubs")
public interface ClubClient {

    @GetMapping
    ResponseEntity<List<ClubDTO>> getAllClubs();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Integer addClub(@RequestBody ClubDTO clubDTO);

    @DeleteMapping("/{club-id}")
    void deleteById(@PathVariable("club-id") Integer clubId);

}

