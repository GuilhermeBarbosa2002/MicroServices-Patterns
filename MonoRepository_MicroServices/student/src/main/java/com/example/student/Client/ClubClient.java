package com.example.student.Client;


import com.example.student.DTO.Club;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "clubs", path = "/api/v1/clubs")
public interface ClubClient {

    @GetMapping("/{club-id}")
    Club getClubById(@PathVariable("club-id") Integer clubId);



}
