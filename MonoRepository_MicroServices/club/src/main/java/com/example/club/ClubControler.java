package com.example.club;


import com.example.club.DTO.ClubFullResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/clubs")
@RestController
@RequiredArgsConstructor
public class ClubControler {
    private final ClubService clubService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Club club){
        clubService.addClub(club);
    }

    @GetMapping
    public ResponseEntity<List<Club>> getAllClubs(){
        return ResponseEntity.ok(clubService.getClubs());
    }

    @GetMapping("{club-id}")
    public ResponseEntity<ClubFullResponse> getClub(@PathVariable("club-id") Integer club){
        return ResponseEntity.ok(clubService.getFullResponseClub(club));

    }



}
