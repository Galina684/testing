package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;
import com.gridnine.testing.service.impl.ArrivalEarlierDeparture;
import com.gridnine.testing.service.impl.DepartureUntilNow;
import com.gridnine.testing.service.impl.IntervalMoreTwoHours;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> testingFlights = FlightBuilder.createFlights();

        System.out.println("-----------------");
        System.out.println("Список полетов после исключения вылетов до текущего момента времени.");
        DepartureUntilNow departureUntilNow = new DepartureUntilNow();
        System.out.println(departureUntilNow.filter(testingFlights));

        System.out.println("-----------------");
        System.out.println("Список полетов после исключения сегментов с датой прилёта раньше даты вылета");
        ArrivalEarlierDeparture arrivalEarlierDeparture = new ArrivalEarlierDeparture();
        System.out.println(arrivalEarlierDeparture.filter(testingFlights));


        System.out.println("-----------------");
        System.out.println("Список полетов, после исключения полетов где общее время, проведённое на земле, превышает два часа");
        IntervalMoreTwoHours intervalMoreTwoHours = new IntervalMoreTwoHours();
        System.out.println(intervalMoreTwoHours.filter(testingFlights));

    }
}
