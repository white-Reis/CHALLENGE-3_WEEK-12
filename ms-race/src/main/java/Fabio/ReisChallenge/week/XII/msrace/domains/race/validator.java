package Fabio.ReisChallenge.week.XII.msrace.domains.race;

import Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race.RaceDTORequest;
import Fabio.ReisChallenge.week.XII.msrace.exceptions.DataIntegratyViolationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class validator {

    public static void validRace(RaceDTORequest raceRequest, Validator validator) {
        Set<ConstraintViolation<RaceDTORequest>> violations = validator.validate(raceRequest);
        if (!violations.isEmpty()) {
            List<String> errorMessages = new ArrayList<>();
            for (ConstraintViolation<RaceDTORequest> violation : violations) {
                errorMessages.add(violation.getPropertyPath() + ": " + violation.getMessage());
            }
            throw new DataIntegratyViolationException(errorMessages.toString());
        }
    }
}
