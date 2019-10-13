package com.flight.search.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flight_details")
public class FlightDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "flight_number")
    private String flightNumber;
    @Column(name = "departure_time")
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date departureTime;

    @Column(name = "quantity_left")
    private int quantityLeft;


    public FlightDetails() {}

    public FlightDetails(String flightNumber, Date departureTime, int quantityLeft) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.quantityLeft = quantityLeft;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }


    public int getQuantityLeft() {
        return quantityLeft;
    }

    public void setQuantityLeft(int quantityLeft) {
        this.quantityLeft = quantityLeft;
    }


    @Override
    public String toString() {
        return "FlightDetails{" +
                "id=" + id +
                ", flightNumber=" + flightNumber +
                ", departureTime=" + departureTime +
                ", quantityLeft=" + quantityLeft +
                '}';
    }
}
