package com.gridnine.testing.service.impl;

import com.gridnine.testing.service.FlightsFilter;
import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Исключение вылетов до текущего момента времени.
 */
public class DepartureUntilNow implements FlightsFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        if (flights != null) {
            return flights.stream()
                    .filter(flight -> flight.getSegments().stream()
                            .anyMatch(segment -> LocalDateTime.now().isBefore(segment.getDepartureDate())))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}