package Fabio.ReisChallenge.week.XIII.mshistory.domain.externalsObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String brand;
    private String model;
    private Pilot pilot;
    private Date year;
}
