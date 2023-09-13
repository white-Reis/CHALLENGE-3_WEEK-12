package Fabio.ReisChallenge.week.XII.msrace.domains.race;

import com.fasterxml.jackson.databind.ObjectMapper;

import Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race.RaceDTORequest;
import Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race.RaceDTOResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(RaceController.class)
class RaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RaceService raceService;


    @Test
    void createRace() throws Exception {
        RaceDTORequest raceDTORequest = new RaceDTORequest();

        Mockito.doNothing().when(raceService).createRace(raceDTORequest);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/race")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(raceDTORequest))
        );

        result.andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void getRaceById() throws Exception {
        Long raceId = 1L; // ID de corrida simulado
        RaceDTOResponse raceResponse = new RaceDTOResponse();

        Mockito.when(raceService.getRaceById(raceId)).thenReturn(raceResponse);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/race/{raceId}", raceId)
                .contentType(MediaType.APPLICATION_JSON)
        );

        result.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(raceResponse)));
    }

    @Test
    void getAllCars() throws Exception {
        List<RaceDTOResponse> raceList = new ArrayList<>();
        Mockito.when(raceService.listAllRaces()).thenReturn(raceList);
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/race")
                .contentType(MediaType.APPLICATION_JSON)
        );
        result.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(raceList)));
    }
}
