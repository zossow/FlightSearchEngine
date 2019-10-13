package com.flight.search.controller;

import com.flight.search.entity.Flight;
import com.flight.search.entity.FlightDetails;
import com.flight.search.entity.OrderFlight;
import com.flight.search.service.FlightSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private FlightSearchService flightSearchService;

    @RequestMapping("/menu")
    public String userMenu(){
        return "user-menu";
    }

    @GetMapping("/list")
    public String listFlights(Model model){

        List<Flight> flights = flightSearchService.getFlightsList();
        model.addAttribute("flights", flights);
        return "flights-list";
    }

    @GetMapping("/showDetails")
    public String showDetails(@RequestParam("flightId") int theId,
                              Model model) {

        FlightDetails flightDetails = flightSearchService.getFlightDetails(theId);
        Flight flight = flightSearchService.getFlightById(theId);

        model.addAttribute("flightDetails", flightDetails);
        model.addAttribute("flight", flight);

        return "flight-details";
    }

    @GetMapping("/searchFlight")
    public String searchFlight(@RequestParam("searchOriginCity") String searchOriginCity,
                               @RequestParam("searchDestinationCity") String searchDestinationCity,
                               Model theModel) {

        List<Flight> flights = flightSearchService.searchFlights(searchOriginCity,searchDestinationCity);

        theModel.addAttribute("flights", flights);

        return "search-flight";
    }

    @GetMapping("/orderFlight")
    public String orderFlight(@RequestParam("flightId") int theId,
                              Model model){
        Flight flight = flightSearchService.getFlightById(theId);
        model.addAttribute("flight",flight);
        return "order-form";
    }
    @PostMapping("/ordering")
    public String ordering(@ModelAttribute("order") OrderFlight theOrder) {

        flightSearchService.saveOrder(theOrder);
        return "redirect:/user/orders";
    }
    @GetMapping("/orders")
    public String orders(@RequestParam("flightId") int theId, Model model){

        Flight flight = flightSearchService.getFlightById(theId);
        model.addAttribute("flight",flight);
        OrderFlight orderFlight = flightSearchService.getFlightById(theId).getOrderFlight();
        model.addAttribute("orderFlight",orderFlight);
        return "orders";
    }
}
