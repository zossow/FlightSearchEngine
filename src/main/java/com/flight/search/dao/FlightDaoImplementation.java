package com.flight.search.dao;

import com.flight.search.entity.Flight;
import com.flight.search.entity.FlightDetails;
import com.flight.search.entity.OrderFlight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightDaoImplementation implements FlightDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Flight> searchFlights(String searchOriginCity, String searchDestinationCity) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = null;

        //
        // only search by name if theSearchName is not empty
        //
        if (searchOriginCity != null && searchOriginCity.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Flight where lower(originCity) like :originCity and lower(destinationCity) like :destinationCity",
                    Flight.class);
            theQuery.setParameter("originCity", "%" + searchOriginCity.toLowerCase() + "%");
            theQuery.setParameter("destinationCity", "%" + searchDestinationCity.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Flight", Flight.class);
        }

        // execute query and get result list
        List<Flight> flights = theQuery.getResultList();

        // return the results
        return flights;

    }

    @Override
    public List<Flight> getFlightsList() {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<Flight> query = currentSession.createQuery("from Flight", Flight.class);
        List<Flight> flightsList = query.getResultList();

        return flightsList;
    }

    @Override
    public FlightDetails getFlightDetails(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        FlightDetails flightDetails = currentSession.get(FlightDetails.class, theId);
        return flightDetails;
    }

    @Override
    public Flight getFlightById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Flight flight = currentSession.get(Flight.class, theId);
        return flight;
    }

    @Override
    public void saveFlight(Flight theFlight) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theFlight);
    }

    @Override
    public void deleteFlight(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Flight flight = currentSession.get(Flight.class, theId);
        currentSession.delete(flight);
    }

    @Override
    public void saveOrder(OrderFlight theOrder) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(theOrder);
    }
}
