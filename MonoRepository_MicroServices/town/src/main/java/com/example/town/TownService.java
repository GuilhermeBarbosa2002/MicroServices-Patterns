package com.example.town;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TownService {

        private final TownRepository townRepository;

    public Integer addTown(Town town) {
        if(townRepository.findTownByName(town.getName()) == null){
            townRepository.save(town);
            return townRepository.findTownByName(town.getName()).getId();
        }else {
            return townRepository.findTownByName(town.getName()).getId();
        }

    }

        public List<Town> getTowns(){
            return townRepository.findAll();
        }

        public Integer getIdByName(String name){
            Town town = townRepository.findTownByName(name);
            return town.getId();
        }

        public Town getTownById(Integer id){
            var parent = townRepository.findById(id).orElse(Town.builder().name("NOT_FOUND").country("NOT_FOUND").build());
            return parent;
         }

        public void removeTown(Integer id){
            townRepository.deleteById(id);
        }



}
