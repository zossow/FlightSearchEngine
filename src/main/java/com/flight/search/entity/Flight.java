package com.flight.search.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "origin_city")
    private String originCity;

    @Column(name = "destination_city")
    private String destinationCity;

    @Column(name = "departure_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date departureDate;

    @Column(name = "price")
    private int price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_details_id")
    private FlightDetails flightDetails;

    @OneToOne(mappedBy="flight", cascade=CascadeType.ALL)
    private OrderFlight orderFlight;


    public Flight() {}

    public Flight(String originCity, String destinationCity, Date departureDate, int price, FlightDetails flightDetails, OrderFlight orderFlight) {
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.departureDate = departureDate;
        this.price = price;
        this.flightDetails = flightDetails;
        this.orderFlight = orderFlight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public FlightDetails getFlightDetails() {
        return flightDetails;
    }

    public void setFlightDetails(FlightDetails flightDetails) {
        this.flightDetails = flightDetails;
    }

    public OrderFlight getOrderFlight() {
        return orderFlight;
    }

    public void setOrderFlight(OrderFlight orderFlight) {
        this.orderFlight = orderFlight;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", originCity='" + originCity + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", departureDate=" + departureDate +
                ", price=" + price +
                ", flightDetails=" + flightDetails +
                ", orderFlight=" + orderFlight +
                '}';
    }
}
