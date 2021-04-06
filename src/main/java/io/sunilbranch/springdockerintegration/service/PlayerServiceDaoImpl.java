package io.sunilbranch.springdockerintegration.service;

import io.sunilbranch.springdockerintegration.exception.PlayerNotFoundException;
import io.sunilbranch.springdockerintegration.model.Player;
import io.sunilbranch.springdockerintegration.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlayerServiceDaoImpl implements PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceDaoImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayer(Integer playerID) {
        Optional<Player> findPlayerById = playerRepository.findById(playerID);

        if (findPlayerById.isPresent()) {
            return findPlayerById.get();
        } else {
            throw new PlayerNotFoundException("Player with ID : " + playerID + " was not found");
        }
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayer(Integer playerID) {
        playerRepository.deleteById(playerID);
    }

    @Override
    public Player getPlayerByEmail(String email) {
        if (!email.isEmpty()){
            return playerRepository.findByEmail(email);
        }else {
            throw new PlayerNotFoundException("Player with email not found " + email);
        }

    }

}
