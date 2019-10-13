package com.flight.search.service;
import com.flight.search.dao.FlightDao;
import com.flight.search.entity.Flight;
import com.flight.search.entity.FlightDetails;
import com.flight.search.entity.OrderFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FlightSearchServiceImplementation implements FlightSearchService {

    @Autowired
    private FlightDao flightDao;

    @Override
    @Transactional
    public List<Flight> getFlightsList() {

        return flightDao.getFlightsList();
    }

    @Override
    @Transactional
    public FlightDetails getFlightDetails(int theId) {
        return flightDao.getFlightDetails(theId);
    }

    @Override
    @Transactional
    public List<Flight> searchFlights(String searchOriginCity, String searchDestinationCity) {
        return flightDao.searchFlights(searchOriginCity,searchDestinationCity);
    }

    @Override
    @Transactional
    public Flight getFlightById(int theId) {
        return flightDao.getFlightById(theId);
    }

    @Override
    @Transactional
    public void saveFlight(Flight theFlight) {
        flightDao.saveFlight(theFlight);
    }

    @Override
    @Transactional
    public void deleteFlight(int theId) {
        flightDao.deleteFlight(theId);
    }

    @Override
    @Transactional
    public void saveOrder(OrderFlight theOrder) {
        flightDao.saveOrder(theOrder);
    }
}
