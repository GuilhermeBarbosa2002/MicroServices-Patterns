package com.example.student.Client;


import com.example.student.DTO.Club;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "club-service", url = "${application.config.clubs-url}")
public interface ClubClient {

    @GetMapping("/{club-id}")
    Club getClubById(@PathVariable("club-id") Integer clubId);



}
