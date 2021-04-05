package io.sunilbranch.springdockerintegration.controller;

import io.sunilbranch.springdockerintegration.model.Player;
import io.sunilbranch.springdockerintegration.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/player/")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> allPlayers = playerService.getAllPlayers();

        if (allPlayers.isEmpty()) {
            System.out.println("List is empty no players found in database. Please insert into the database.");
            return new ResponseEntity<List<Player>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Player>>(allPlayers, HttpStatus.OK);
    }

    @PostMapping(value = "save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Player> savePlayer(@Valid @RequestBody Player player) {
        Player savePlayer = playerService.savePlayer(player);
        return new ResponseEntity<Player>(savePlayer, HttpStatus.CREATED);
    }

    @GetMapping(value = "{playerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Player> getPlayerById(@PathVariable Integer playerId) {
        Player player = playerService.getPlayer(playerId);
        return new ResponseEntity<Player>(player, HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{playerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deletePlayer(@PathVariable Integer playerId) {
        Player player = playerService.getPlayer(playerId);

        if (player.getId() > 0 && player.getId().equals(playerId)) {
            playerService.deletePlayer(playerId);
            return new ResponseEntity<String>("successfully deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("please check", HttpStatus.NOT_FOUND);
        }
    }
}
