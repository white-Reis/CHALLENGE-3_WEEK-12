package Fabio.ReisChallenge.week.XII.mscars.config;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class ModelMapperConfigTest {

    @Test
    public void testMapper() {
        ModelMapperConfig modelMapperConfig = new ModelMapperConfig();
        ModelMapper modelMapper = modelMapperConfig.mapper();

        assertNotNull(modelMapper);
    }
}