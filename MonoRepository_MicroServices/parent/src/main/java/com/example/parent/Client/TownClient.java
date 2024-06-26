package com.example.parent.Client;

import com.example.parent.DTO.Town;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "towns", path = "/api/v1/towns")
public interface TownClient {
    @GetMapping("/{town-id}")
    Town getTownById(@PathVariable("town-id") Integer townId);
}
