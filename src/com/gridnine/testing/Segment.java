package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Segment {

    private final Integer id;
    private final LocalDateTime departureDate;
    private final LocalDateTime arrivalDate;

    public Integer getId() {
        return id;
    }

    LocalDateTime getDepartureDate() {
        return departureDate;
    }

    LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    Segment(final LocalDateTime departure, final LocalDateTime arrival, Integer id) {
        departureDate = Objects.requireNonNull(departure);
        arrivalDate = Objects.requireNonNull(arrival);
        this.id = id;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '[' + departureDate.format(fmt) + '|' + arrivalDate.format(fmt)
                + ']';
    }
}
