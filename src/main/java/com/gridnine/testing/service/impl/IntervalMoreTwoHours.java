package com.gridnine.testing.service.impl;

import com.gridnine.testing.service.FlightsFilter;
import com.gridnine.testing.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Исключение перелетов, где общее время, проведённое на земле, превышает два часа
 */
public class IntervalMoreTwoHours implements FlightsFilter {
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        return flightList.parallelStream()
                .filter(flight -> flight.IntervalTime() < 2)
                .collect(Collectors.toList());
    }

}