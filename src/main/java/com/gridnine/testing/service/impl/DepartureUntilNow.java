package com.gridnine.testing.service.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.FlightsFilter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Вылет до текущего момента времени.
 */
public class DepartureUntilNow implements FlightsFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> fl = new ArrayList<>();
        for (Flight e : flights) {
            for (Segment s : e.getSegments()) {
                if (s.getDepartureDate().compareTo(LocalDateTime.now()) < 0) {
                    fl.add(e);
                }
            }
        }
        return fl;
    }
}
