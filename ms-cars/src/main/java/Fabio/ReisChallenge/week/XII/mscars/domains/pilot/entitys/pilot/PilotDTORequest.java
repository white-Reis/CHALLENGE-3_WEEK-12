package Fabio.ReisChallenge.week.XII.mscars.domains.pilot.entitys.pilot;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PilotDTORequest {

    @NotBlank(message = "Name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only letters and spaces")
    private String name;

    @NotNull(message = "Age cannot be null")
    @Min(value = 17, message = "Age must be greater than or equal to 17")
    private Integer age;

}
