package com.Chamal.SweetRide.Passenger;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
@RequiredArgsConstructor
public class PassengerController {

    private final PassengerService service;

    @PostMapping("/add")
    public ResponseEntity<Passenger> Add_users(@RequestBody Passenger AddUser) {
        Passenger New_Users = service.AddPassenger(AddUser);
        return new ResponseEntity<>(New_Users, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Passenger> updateCustomer(@PathVariable("id") Long id, @RequestBody Passenger update) throws PassengerException {
        Passenger Update_User = service.UpdatePassenger(id , update);
        return new ResponseEntity<Passenger>(Update_User, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Passenger> FindAll() {
        return service.GetAllRegisteredPassenger();
    }

}
