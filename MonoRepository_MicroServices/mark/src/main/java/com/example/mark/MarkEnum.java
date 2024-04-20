package com.example.mark;

import lombok.Getter;

@Getter
public enum MarkEnum {
    POOR(2),
    AVERAGE(3),
    GOOD(4),
    VERY_GOOD(5),
    EXCELLENT(6);

    private final int value;

    MarkEnum(int value) {
        this.value = value;
    }
}
