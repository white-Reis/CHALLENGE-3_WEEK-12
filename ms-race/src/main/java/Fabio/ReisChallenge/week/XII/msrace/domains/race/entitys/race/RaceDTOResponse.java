package Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RaceDTOResponse {

    private Long id;

    private String name;

    private String country;

    private Date date;
}
