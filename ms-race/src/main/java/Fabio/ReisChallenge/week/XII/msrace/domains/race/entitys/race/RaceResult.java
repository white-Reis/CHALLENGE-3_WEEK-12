package Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race;

import Fabio.ReisChallenge.week.XII.msrace.domains.cars.entitys.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RaceResult {

    private String name;

    private String country;

    private Date date;

    private Car winner;

    private Car secondPlace;

    private Car thirdPlace;
}
