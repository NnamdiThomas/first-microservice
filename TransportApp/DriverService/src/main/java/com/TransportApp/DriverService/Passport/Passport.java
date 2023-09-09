package com.TransportApp.DriverService.Passport;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.time.LocalDate;
@Embeddable
@Data
public class Passport {
    private String Type;
    private String PassportNumber;
    private LocalDate DateIssued;
    private String IssuedBy;
    private String ImageURL;
}
