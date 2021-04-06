package io.sunilbranch.springdockerintegration.service;

import io.sunilbranch.springdockerintegration.model.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getAllPlayers();

    Player getPlayer(Integer playerID);

    Player savePlayer(Player player);

    void deletePlayer(Integer playerID);

    Player getPlayerByEmail(String email);
}
