package com.TransportApp.DriverService.Driver;

import com.TransportApp.DriverService.License.DriverLicense;
import com.TransportApp.DriverService.Passport.Passport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Driver {
    @Id
    @SequenceGenerator(
            name = "Driver_sequence",
            sequenceName = "Driver_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Driver_sequence")
    private Long Id;
    private String FirstName;
    private String LastName;
    private String MiddleName;
    private String PhoneNumber;
    private LocalDate DateOfBirth;
    private Integer Age;
    private LocalDate DateOfRegistration;
    @JsonIgnore
    @Embedded
    private Passport passport;
    @JsonIgnore
    @Embedded
    private DriverLicense license;
}
