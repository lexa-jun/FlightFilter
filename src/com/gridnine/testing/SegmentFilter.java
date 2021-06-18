package com.gridnine.testing;

import java.util.List;
import java.util.Set;

public interface SegmentFilter {
    void showAllSegments(List<Flight> flightList);

    Set<Flight> getDepartureTimeBeforeNow(List<Flight> flightList);

    Set<Flight> getArrivalDateLessDepartureDate(List<Flight> flightList);

    Set<Flight> getFlightWithTransferMoreThanTwoHours(List<Flight> flightList);
}
