package com.example.club.DTO;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClubFullResponse {

    private String description;
    private String name;
    private Town town;

}
