package Fabio.ReisChallenge.week.XIII.mshistory.domain.raceResult.entitys;

import Fabio.ReisChallenge.week.XIII.mshistory.domain.externalsObjects.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "race_results")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RaceResult {

    @Id
    private String id;

    private String name;

    private String country;

    private Date date;

    private Car winner;

    private Car secondPlace;

    private Car thirdPlace;
}
