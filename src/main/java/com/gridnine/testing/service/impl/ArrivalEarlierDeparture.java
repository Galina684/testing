package com.gridnine.testing.service.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.FlightsFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * Сегменты с датой прилёта раньше даты вылета
 */
public class ArrivalEarlierDeparture implements FlightsFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> fl = new ArrayList<>();
        for (Flight flight : flights) {
            for (Segment seg : flight.getSegments())
                if (seg.getArrivalDate().isAfter(seg.getDepartureDate())) {
                    fl.add(flight);
                }
        }
        return fl;
    }
}
