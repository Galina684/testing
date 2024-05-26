package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.util.List;

public interface FlightsFilter {
    List<Flight> filter(List<Flight> flights);
}
