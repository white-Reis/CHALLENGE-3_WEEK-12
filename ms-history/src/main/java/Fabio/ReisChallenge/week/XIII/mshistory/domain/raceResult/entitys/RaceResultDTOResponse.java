package Fabio.ReisChallenge.week.XIII.mshistory.domain.raceResult.entitys;

import Fabio.ReisChallenge.week.XIII.mshistory.domain.externalsObjects.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RaceResultDTOResponse {

    private String id;

    private String name;

    private String country;

    private Date date;

    private Car winner;

    private Car secondPlace;

    private Car thirdPlace;
}
