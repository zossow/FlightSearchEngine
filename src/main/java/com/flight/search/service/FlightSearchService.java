package com.flight.search.service;

import com.flight.search.entity.Flight;
import com.flight.search.entity.FlightDetails;
import com.flight.search.entity.OrderFlight;

import java.util.List;

public interface FlightSearchService {

    public List<Flight> getFlightsList();

    public Flight getFlightById(int theId);

    public FlightDetails getFlightDetails(int theId);

    public List<Flight> searchFlights(String searchOriginCity, String searchDestinationCity);

    public void saveFlight(Flight theFlight);

    public void deleteFlight(int theId);

    public void saveOrder(OrderFlight theOrder);
}
