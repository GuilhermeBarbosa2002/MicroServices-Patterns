package com.example.apiExterna;


import com.example.apiExterna.Client.TownClient;
import com.example.apiExterna.DTO.Town;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiExternaService {
    private final TownClient townClient;
    public void addTown(Town town) {
        Integer id = townClient.addTown(town);
        System.err.println("--------------------------------  " + id + "----------------------");
    }
}
