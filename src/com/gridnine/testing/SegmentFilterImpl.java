package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SegmentFilterImpl implements SegmentFilter {

    private DateTimeFormatter getDateFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd' T 'HH:mm");
    }

    public void showAllSegments(List<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println("Номер рейса - " + flight.getId());
            for (int i = 0; i < flight.getSegments().size(); i++) {
                System.out.println(flight.getSegments().get(i)
                        + " Номер сегмента: "
                        + flight.getSegments().get(i).getId());
            }
        }
    }

    private void showRightFLight(Flight flight, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        DateTimeFormatter dateTimeFormatter = getDateFormatter();
        System.out.println("Номер рейса - " + flight.getId() + "\n" + "Время отправления: "
                + dateTimeFormatter.format(departureTime) + "\n" + "Время прибытия: "
                + dateTimeFormatter.format(arrivalTime));
        System.out.println("..................................");

    }


}
