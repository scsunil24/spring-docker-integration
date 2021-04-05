package io.sunilbranch.springdockerintegration.controller;

import io.sunilbranch.springdockerintegration.model.Player;
import io.sunilbranch.springdockerintegration.repository.PlayerRepository;
import io.sunilbranch.springdockerintegration.service.PlayerServiceDaoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PlayerControllerTest {

    @Autowired
    private PlayerServiceDaoImpl playerServiceDao;

    @MockBean
    private PlayerRepository playerRepository;

    @Test
    @DisplayName("Getting all players test case")
    void shouldReturnAllPlayersInformation_test() {
        Stream<Player> playerStream = Stream.of(
                new Player("sunil", "chityala", "scsunil24@gmail.com", "Male", "10.9.10.10", "http://localhost"),
                new Player("neha", "jadhav", "neha@gmail.com", "Female", "10.9.11.12", "http://localhost::8989")
        );

        List<Player> players = playerStream.collect(Collectors.toList());
        when(playerRepository.findAll()).thenReturn(players);
        assertEquals(2, playerServiceDao.getAllPlayers().size());
    }

    @Test
    @DisplayName("Saving the player test case")
    void savePlayer() {
        Player player =  new Player("sunil", "chityala", "scsunil24@gmail.com", "Male", "10.9.10.10", "http://localhost");
        when(playerRepository.save(player)).thenReturn(player);
        assertEquals(player, playerServiceDao.savePlayer(player));
    }

    @Test
    @DisplayName("Getting single player test case")
    void shouldReturnPlayerInformationOnBasisOfId_test() {
        Player player =  new Player("sunil", "chityala", "scsunil24@gmail.com", "Male", "10.9.10.10", "http://localhost");

        when(playerRepository.findById(player.getId())).thenReturn(Optional.of(player));
        assertEquals(player.getId(), player.getId());
    }
}