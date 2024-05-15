package com.example.apiExterna.Client;


import com.example.apiExterna.DTO.Town;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "TOWNS", path = "/api/v1/towns")
public interface TownClient {
    @GetMapping("/{town-id}")
    Town getTownById(@PathVariable("town-id") Integer townId);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Integer addTown(@RequestBody Town town);

    @DeleteMapping("/{town-id}")
    void deleteById(@PathVariable("town-id") Integer townId);




}
