package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestObjects {
    private final LocalDateTime dateTime = LocalDateTime.now();

    public static Flight createExpectedFlight(LocalDateTime dateTime) {
        List<Segment> list = List.of
                (new Segment(dateTime.plusHours(1), dateTime.plusDays(1)),
                        new Segment(dateTime.plusHours(1), dateTime.plusHours(7)));
        Flight flight = new Flight(list);
        return flight;
    }

    public static List<Flight> createExpectedFlightList() {
        Flight flight = createExpectedFlight(LocalDateTime.now());
        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight);
        return flightList;
    }

    public static List<Flight> actualFlightListForArrivalEarlierDeparture(LocalDateTime dateTime) {
        List<Segment> list = List.of
                (new Segment(dateTime.plusHours(2), dateTime.minusDays(1)),
                        new Segment(dateTime.plusHours(3), dateTime));
        Flight flight = new Flight(list);
        List<Flight> flightList = new ArrayList<>();
        Flight expectedFlight = createExpectedFlight(dateTime);
        flightList.add(flight);
        flightList.add(expectedFlight);
        return flightList;
    }

    public static List<Flight> actualFlightListForDepartureUntilNow(LocalDateTime dateTime) {
        List<Segment> list = List.of
                (new Segment(dateTime.minusDays(1), dateTime),
                        new Segment(dateTime, dateTime.plusHours(2)));
        Flight flight = new Flight(list);
        List<Flight> flightList = new ArrayList<>();
        Flight expectedFlight = createExpectedFlight(dateTime);
        flightList.add(flight);
        flightList.add(expectedFlight);
        return flightList;
    }

    public static List<Flight> actualFlightListForIntervalMoreTwoHours(LocalDateTime dateTime) {
        List<Segment> list = List.of
                (new Segment(dateTime.plusHours(2), dateTime.plusHours(3)),
                        new Segment(dateTime.plusHours(5), dateTime));
        Flight flight = new Flight(list);
        List<Flight> flightList = new ArrayList<>();
        Flight expectedFlight = createExpectedFlight(dateTime);
        flightList.add(flight);
        flightList.add(expectedFlight);
        return flightList;
    }

}
