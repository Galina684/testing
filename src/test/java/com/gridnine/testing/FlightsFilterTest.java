package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightsFilter;
import com.gridnine.testing.service.impl.ArrivalEarlierDeparture;
import com.gridnine.testing.service.impl.DepartureUntilNow;
import com.gridnine.testing.service.impl.IntervalMoreTwoHours;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static com.gridnine.testing.TestObjects.*;

public class FlightsFilterTest {
    private LocalDateTime dateTime = LocalDateTime.now();

    @Test
    void ArrivalEarlierDepartureTest() {
        FlightsFilter flightsFilter = new ArrivalEarlierDeparture();
        List<Flight> expected = createExpectedFlightList();
        List<Flight> actual = flightsFilter.filter(actualFlightListForArrivalEarlierDeparture(dateTime));
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void DepartureUntilNowTest() {
        FlightsFilter flightsFilter = new DepartureUntilNow();
        List<Flight> expected = createExpectedFlightList();
        List<Flight> actual = flightsFilter.filter(actualFlightListForDepartureUntilNow(dateTime));
        Assertions.assertEquals(actual.toString(), expected.toString());
    }

    @Test
    void IntervalMoreTwoHourTest() {
        FlightsFilter flightsFilter = new IntervalMoreTwoHours();
        List<Flight> expected = createExpectedFlightList();
        List<Flight> actual = flightsFilter.filter(actualFlightListForIntervalMoreTwoHours(dateTime));
        Assertions.assertEquals(actual.toString(), expected.toString());
    }
}
