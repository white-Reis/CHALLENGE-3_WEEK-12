package Fabio.ReisChallenge.week.XIII.mshistory.domain.raceResult;

import Fabio.ReisChallenge.week.XIII.mshistory.domain.raceResult.entitys.RaceResultDTOResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RaceResultControllerTest {

    @InjectMocks
    private RaceResultController raceResultController;

    @Mock
    private RaceResultService raceResultService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCarById() {
        String raceResultId = "1";
        RaceResultDTOResponse raceResultDTO = new RaceResultDTOResponse();

        when(raceResultService.getRaceResultById(raceResultId)).thenReturn(raceResultDTO);

        RaceResultDTOResponse result = raceResultController.getCarById(raceResultId).getBody();

        assertNotNull(result);
    }

    @Test
    void getAllCars() {
        List<RaceResultDTOResponse> raceResultDTOs = new ArrayList<>();
        RaceResultDTOResponse raceResultDTO1 = new RaceResultDTOResponse();
        RaceResultDTOResponse raceResultDTO2 = new RaceResultDTOResponse();
        raceResultDTOs.add(raceResultDTO1);
        raceResultDTOs.add(raceResultDTO2);

        when(raceResultService.getAllRaceResults()).thenReturn(raceResultDTOs);

        List<RaceResultDTOResponse> result = raceResultController.getAllCars().getBody();

        assertNotNull(result);
        assertEquals(2, result.size());
    }
}
