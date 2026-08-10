package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class FlightCard {

    int departureDay;
    int departureMonth;
    int departureYear;

    int returnDay;
    int returnMonth;
    int returnYear;

    String departureCity;
    String arrivalCity;

}
