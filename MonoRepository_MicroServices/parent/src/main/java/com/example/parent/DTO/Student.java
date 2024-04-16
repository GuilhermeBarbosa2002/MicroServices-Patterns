package com.example.parent.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private String name;
    private String email;
    private Integer parent;
    private Integer town;
}
