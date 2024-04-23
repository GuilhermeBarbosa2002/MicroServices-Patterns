package com.example.club;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor


public class ClubService {
    private final ClubRepository clubRepository;

    public List<Club> getClubs() {
        return clubRepository.findAll();
    }

    public void addClub(Club club) {
        clubRepository.save(club);

    }


    public Optional<Club> getClub(Integer club) {
        return clubRepository.findById(club);
    }
}
