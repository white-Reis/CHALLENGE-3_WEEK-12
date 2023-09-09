package Fabio.ReisChallenge.week.XIII.mscars.domains.pilot.entitys.pilot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PilotDTOResponse {

    private Long id;
    private String name;
    private int age;

}
