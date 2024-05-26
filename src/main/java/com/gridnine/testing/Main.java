package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;
import com.gridnine.testing.service.impl.ArrivalEarlierDeparture;
import com.gridnine.testing.service.impl.DepartureUntilNow;
import com.gridnine.testing.service.impl.IntervalMoreTwoHours;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> testingFlights = FlightBuilder.createFlights();

        System.out.println("-----------------");
        System.out.println("Вылет до текущего момента времени.");
        System.out.println(testingFlights = new DepartureUntilNow().filter(testingFlights));
        System.out.println("-----------------");
        System.out.println("Сегменты с датой прилёта раньше даты вылета");
        System.out.println(testingFlights = new ArrivalEarlierDeparture().filter(testingFlights));
        System.out.println("-----------------");
        System.out.println("Перелеты, где общее время, проведённое на земле, превышает два часа");
        System.out.println(testingFlights = new IntervalMoreTwoHours().filter(testingFlights));
    }
}
