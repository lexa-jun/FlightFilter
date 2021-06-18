package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class FlightBuilder {
    private Integer flightId = 0;
    private Integer segmentId = 0;

    public List<Flight> createFlights() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        return Arrays.asList(
                // Обычный рейс продолжительностью 2 часа
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                // Обычный мульти-сегментный рейс
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)),
                // рейс, выполнявшийся в прошлом
                createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow),
                // вылет раньше, чем прибытие
                createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6)),
                // рейс с ожиданием на земле более 2 часов
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)),
                // рейс с ожиданием на земле 2 часа
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4),
                        threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)));

    }

}
