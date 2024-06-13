package com.gridnine.testing.service.impl;

import com.gridnine.testing.service.FlightsFilter;
import com.gridnine.testing.model.Flight;

import java.util.ArrayList;
import java.util.List;

/**
 * Исключение сегментов с датой прилёта раньше даты вылета
 */
public class ArrivalEarlierDeparture implements FlightsFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> result = new ArrayList<>();
        if (flights != null) {
            flights.forEach(flight -> flight.getSegments()
                    .stream()
                    .filter(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())).limit(1)
                    .forEach(segment -> result.add(flight)));
            return result;
        }
        return result;
    }
}

