package Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RaceDTORequest {

    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotBlank(message = "Country cannot be blank")
    private String country;

    private Date date;
}
