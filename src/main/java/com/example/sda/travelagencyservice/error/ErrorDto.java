package com.example.sda.travelagencyservice.error;

import java.time.LocalDate;

public class ErrorDto {

    private String reason;

    private LocalDate time = LocalDate.now();

    public ErrorDto(String reason) {
        this.reason = reason;

    }

    public String getReason() {
        return reason;
    }

    public LocalDate getTime() {
        return time;
    }
}
