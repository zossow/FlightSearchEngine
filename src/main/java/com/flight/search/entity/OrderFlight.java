package com.flight.search.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_flight")
public class OrderFlight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "amount")
    private int amount;
    @Column(name = "price")
    private int price;
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "flight_id")
    private Flight flight;

    public OrderFlight(){};

    public OrderFlight(int amount, int price, Users user, Flight flight) {
        this.amount = amount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "OrderFlight{" +
                "id=" + id +
                ", amount=" + amount +
                ", price=" + price +

                '}';
    }
}
