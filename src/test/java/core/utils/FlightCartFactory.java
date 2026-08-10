package core.utils;

import models.FlightCard;
import models.User;

public class FlightCartFactory {

    public static FlightCard createFlightCard(){
        return FlightCard.builder()
                .departureDay(15)
                .departureMonth(9)
                .departureYear(2026)
                .returnDay(25)
                .returnMonth(9)
                .returnYear(2026)
                .departureCity("Самара")
                .arrivalCity("Москва")
                .build();
    }
}
