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

    public Set<Flight> getArrivalDateLessDepartureDate(List<Flight> flights){
        Set<Flight> resultSet = new HashSet<>();
        List<Segment> split = new ArrayList<>();
        for(Flight flight : flights){
            split.addAll(flight.getSegments());

            while (split.size() > 0){
                LocalDateTime departureTime = split.get(0).getDepartureDate();
                LocalDateTime arrivalTime = split.remove(0).getArrivalDate();
                if(arrivalTime.isBefore(departureTime)){
                    showRightFLight(flight, departureTime, arrivalTime);
                    resultSet.add(flight);
                }
            }
        }
        return resultSet;
    }

    public Set<Flight> getDepartureTimeBeforeNow(List<Flight> flights){
        LocalDateTime timeNow = LocalDateTime.now();
        Set<Flight> resultSet = new HashSet<>();
        List<Segment> split = new ArrayList<>();
        for(Flight flight : flights){
            split.addAll(flight.getSegments());

            while (split.size() > 0){
                LocalDateTime departureTime = (split.get(0).getDepartureDate());
                LocalDateTime arrivalTime = (split.remove(0).getArrivalDate());
                if(departureTime.isAfter(timeNow)){
                    showRightFLight(flight, departureTime, arrivalTime);
                    resultSet.add(flight);
                }
            }
        }
        return resultSet;
    }

}
