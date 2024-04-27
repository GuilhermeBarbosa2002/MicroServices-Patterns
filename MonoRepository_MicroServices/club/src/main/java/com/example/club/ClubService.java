package com.example.club;

import com.example.club.DTO.ClubFullResponse;
import com.example.club.Client.TownClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor

public class ClubService {
    private final ClubRepository clubRepository;
    private final TownClient townClient;

    public List<Club> getClubs() {
        return clubRepository.findAll();
    }

    public Integer addClub(Club club) {
        clubRepository.save(club);

        return clubRepository.findClubByName(club.getName()).getId();
    }


    public ClubFullResponse getFullResponseClub(Integer clubId) {
        var club = clubRepository.findById(clubId).orElse(Club.builder().name("NOT_FOUND").description("NOT_FOUND").build());
        var town = townClient.getTownById(club.getTown());
        return ClubFullResponse.builder()
                .name(club.getName())
                .description(club.getDescription())
                .town(town).
                build();

    }
}
