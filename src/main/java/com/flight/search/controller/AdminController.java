package com.flight.search.controller;

import com.flight.search.entity.Flight;
import com.flight.search.entity.FlightDetails;
import com.flight.search.service.FlightSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private FlightSearchService flightSearchService;


    @RequestMapping("/menu")
    public String adminMenu(){
        return "admin-menu";
    }

    @GetMapping("/list")
    public String listFlights(Model model){

        List<Flight> flights = flightSearchService.getFlightsList();
        model.addAttribute("flights", flights);
        return "admin-flights-list";
    }

    @GetMapping("/showDetails")
    public String showDetails(@RequestParam("flightId") int theId,
                              Model model) {

        FlightDetails flightDetails = flightSearchService.getFlightDetails(theId);
        Flight flight = flightSearchService.getFlightById(theId);

        model.addAttribute("flightDetails", flightDetails);
        model.addAttribute("flight", flight);

        return "admin-flight-details";
    }

    @GetMapping("/searchFlight")
    public String searchFlight(@RequestParam("searchOriginCity") String searchOriginCity,
                               @RequestParam("searchDestinationCity") String searchDestinationCity,
                               Model theModel) {

        List<Flight> flights = flightSearchService.searchFlights(searchOriginCity,searchDestinationCity);

        theModel.addAttribute("flights", flights);

        return "admin-search-flight";
    }
    @GetMapping("/add")
    public String addFlight(Model model){

        Flight flight = new Flight();
        FlightDetails flightDetails = new FlightDetails();
        model.addAttribute("flight",flight);
        model.addAttribute("flightDetails",flightDetails);
        return "flight-form";
    }

    @PostMapping("/saveFlight")
    public String saveCustomer(@ModelAttribute("flight") Flight theFlight) {

        flightSearchService.saveFlight(theFlight);
        return "redirect:/admin/list";
    }
    @GetMapping("/modifyFlight")
    public String showUpdateForm(@RequestParam("flightId") int theId,
                                 Model model){
        Flight flight = flightSearchService.getFlightById(theId);
        model.addAttribute("flight", flight);
        return "flight-form";
    }

    @GetMapping("/delete")
    public String deleteFlight(@RequestParam("flightId") int theId){

        flightSearchService.deleteFlight(theId);
        return "redirect:/admin/list";

    }



}
