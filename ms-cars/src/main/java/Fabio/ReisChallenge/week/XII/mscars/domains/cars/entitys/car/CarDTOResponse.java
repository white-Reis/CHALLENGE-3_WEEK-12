package Fabio.ReisChallenge.week.XII.mscars.domains.cars.entitys.car;

import Fabio.ReisChallenge.week.XII.mscars.domains.pilot.entitys.pilot.PilotDTOResponse;
import lombok.Data;

import java.util.Date;

@Data
public class CarDTOResponse {
    private Long id;
    private String brand;
    private String model;
    private PilotDTOResponse pilot;
    private Date year;
}
