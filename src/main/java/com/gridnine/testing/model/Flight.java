package com.gridnine.testing.model;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class Flight {
    private final List<Segment> segments;

    public Flight(final List<Segment> segs) {
        segments = segs;
    }

    public List<Segment> getSegments() {
        return segments;
    }


    public int IntervalTime() {
        List<Segment> segmentsList = getSegments();
        int sum = 0;
        for (int i = 1; i < segmentsList.size(); i++) {
            long between = ChronoUnit.HOURS.between(segments.get(i - 1).getArrivalDate(), segments.get(i).getDepartureDate());
            sum += between;
        }
        return (int) sum;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
