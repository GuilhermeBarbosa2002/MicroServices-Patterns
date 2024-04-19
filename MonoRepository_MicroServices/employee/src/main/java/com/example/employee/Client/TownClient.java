package com.example.employee.Client;

import com.example.employee.DTO.Town;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "town-service", url = "${application.config.towns-url}")
public interface TownClient {
    @GetMapping("/{town-id}")
    Town getTownById(@PathVariable("town-id") Integer townId);
}
