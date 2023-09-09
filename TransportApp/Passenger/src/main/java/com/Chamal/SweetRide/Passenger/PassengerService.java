package com.Chamal.SweetRide.Passenger;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerService implements PassengerDAO {

    private final PassengerRepo repo;
    @Override
    public Passenger AddPassenger(Passenger add) throws PassengerException {
        Passenger RegisterPassenger = Passenger
                .builder()
                .Email(add.getEmail())
                .Password(add.getPassword())
                .build();

        if(add != null){
            return repo.save(RegisterPassenger);
        }else {
            throw new PassengerException("NO USER ADDED");
        }
    }

    @Override
    public Passenger UpdatePassenger(Long Id,Passenger update) throws PassengerException {

        Passenger Update = repo.findById(Id).orElseThrow(()-> new PassengerException
                ("NO USER RESGISTERED WITH ID OF "+Id));


        Passenger Age = new Passenger();



        Update.setFirstName(update.getFirstName());
        Update.setLastName(update.getLastName());
        Update.setMiddleName(update.getMiddleName());
        Update.setSex(update.getSex());
        Update.setDateOfBirth(update.getDateOfBirth());
        Update.setNinNumber(update.getNinNumber());
        Update.setImageUrl(update.getImageUrl());
        Integer age = update.getAge();
    //    Update.setAge(Period.between(age), LocalDate.now().getYear());

        if (Update!= null){
            return repo.save(Update);
        }else {
            throw new PassengerException("NO ID INPUTTED");
        }

    }
    @Override
    public List<Passenger> GetAllRegisteredPassenger() throws PassengerException {

        List<Passenger> FindAllRegistered = repo.findAll();
        if (FindAllRegistered.isEmpty()){
            throw new PassengerException("NO REGISTERED PASSENGER");
        }  else {
        return FindAllRegistered;
        }

    }
}
