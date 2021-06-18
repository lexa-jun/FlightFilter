package com.gridnine.testing;

import java.util.List;

public class SegmentFilterImpl implements SegmentFilter {


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
}
