package Fabio.ReisChallenge.week.XII.mscars.domains.cars.entitys.car;

import Fabio.ReisChallenge.week.XII.mscars.domains.pilot.entitys.pilot.PilotDTOResponse;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDTOResponse {
    private Long id;
    private String brand;
    private String model;
    private PilotDTOResponse pilot;
    private Date year;
}
