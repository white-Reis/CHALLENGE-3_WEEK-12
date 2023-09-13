package Fabio.ReisChallenge.week.XII.msrace.domains.race;

import Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race.RaceDTORequest;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class validatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void validRace_WithValidRaceDTORequest_ShouldNotThrowException() {
        RaceDTORequest raceDTORequest = new RaceDTORequest();
        raceDTORequest.setName("Race Name");
        raceDTORequest.setCountry("Race Country");

        assertDoesNotThrow(() -> validator.validate(raceDTORequest));
    }
}