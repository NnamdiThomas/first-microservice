package com.Chamal.SweetRide.Passenger;

import java.util.List;

public interface PassengerDAO {

    public Passenger AddPassenger(Passenger add) throws PassengerException;

    public Passenger UpdatePassenger(Long Id ,Passenger update) throws PassengerException;

    public List<Passenger> GetAllRegisteredPassenger() throws PassengerException;
}
