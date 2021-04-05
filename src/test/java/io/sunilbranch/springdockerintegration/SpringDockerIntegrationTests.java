package io.sunilbranch.springdockerintegration;

import io.sunilbranch.springdockerintegration.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

//@SpringBootTest
@WebMvcTest
class SpringDockerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PlayerService playerRepository;


    @Test
    void contextLoads() {

        Mockito.when(playerRepository.getAllPlayers()).thenReturn(
                Collections.emptyList()
        );

        try {
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/rest/player/list")
                            .accept(MediaType.APPLICATION_JSON_VALUE)
            ).andReturn();

            System.out.println(mvcResult.getResponse());
            Mockito.verify(playerRepository).getAllPlayers();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
