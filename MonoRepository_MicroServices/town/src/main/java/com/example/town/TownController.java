package com.example.town;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/towns")
@RestController
@RequiredArgsConstructor
public class TownController {

    private final TownService townService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Town town){
        townService.addTown(town);
    }

    @GetMapping
    public ResponseEntity<List<Town>> getAllTowns(){
        return ResponseEntity.ok(townService.getTowns());
    }

    @GetMapping("/{town-id}")
    public ResponseEntity<Town> getParentById(@PathVariable("town-id") Integer townId){
        return ResponseEntity.ok(townService.getTownById(townId));

    }

}
