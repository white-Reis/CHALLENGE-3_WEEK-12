package Fabio.ReisChallenge.week.XIII.mshistory.domain.raceResult;

import Fabio.ReisChallenge.week.XIII.mshistory.domain.raceResult.entitys.RaceResult;
import Fabio.ReisChallenge.week.XIII.mshistory.domain.raceResult.entitys.RaceResultDTOResponse;
import Fabio.ReisChallenge.week.XIII.mshistory.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RaceResultServiceTest {

    @InjectMocks
    private RaceResultService raceResultService;

    @Mock
    private RaceResultRepository raceResultRepository;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createRaceResult() {
        RaceResult raceResult = new RaceResult();
        when(raceResultRepository.save(raceResult)).thenReturn(raceResult);

        raceResultService.createRaceResult(raceResult);

        verify(raceResultRepository, times(1)).save(raceResult);
    }

    @Test
    void getAllRaceResults() {
        List<RaceResult> raceResults = new ArrayList<>();
        RaceResult raceResult1 = new RaceResult();
        RaceResult raceResult2 = new RaceResult();
        raceResults.add(raceResult1);
        raceResults.add(raceResult2);

        when(raceResultRepository.findAll()).thenReturn(raceResults);

        List<RaceResultDTOResponse> raceResultDTOResponses = new ArrayList<>();
        when(modelMapper.map(any(), eq(RaceResultDTOResponse.class))).thenReturn(new RaceResultDTOResponse());
        List<RaceResultDTOResponse> result = raceResultService.getAllRaceResults();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void getRaceResultById() {
        String id = "1";
        RaceResult raceResult = new RaceResult();
        raceResult.setId(id);

        when(raceResultRepository.findById(id)).thenReturn(Optional.of(raceResult));
        when(modelMapper.map(raceResult, RaceResultDTOResponse.class)).thenReturn(new RaceResultDTOResponse("1",null,null,null,null,null,null));

        RaceResultDTOResponse result = raceResultService.getRaceResultById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    void getRaceResultById_NotFound() {
        String id = "1";

        when(raceResultRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ObjectNotFoundException.class, () -> raceResultService.getRaceResultById(id));
    }
}