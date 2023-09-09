package com.Chamal.SweetRide.Passenger;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table
public class Passenger {
    @Id
    @SequenceGenerator(
            name = "Passenger_sequence",
            sequenceName = "Passenger_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Passenger_sequence")
    private Long Id;
    private String FirstName;
    private String LastName;
    private String MiddleName;
    @Transient
    private Integer Age;
    private LocalDate DateOfBirth;
    private SEX Sex;
    private String NinNumber;
    private String ImageUrl;
    private String Email;
    private String Password;
    @Transient
    private LocalDate DateOfRegistration;

    public LocalDate getDateOfRegistration() {
        return LocalDate.now();
    }

    public Integer getAge() {
        return Period.between(DateOfBirth , LocalDate.now()).getYears();
    }
}

