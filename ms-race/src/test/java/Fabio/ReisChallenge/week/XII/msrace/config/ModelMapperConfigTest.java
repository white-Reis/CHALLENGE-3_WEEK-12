package Fabio.ReisChallenge.week.XII.msrace.config;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;

class ModelMapperConfigTest {
    @Test
    public void testMapper() {
        ModelMapperConfig modelMapperConfig = new ModelMapperConfig();
        ModelMapper modelMapper = modelMapperConfig.mapper();

        assertNotNull(modelMapper);
    }
}