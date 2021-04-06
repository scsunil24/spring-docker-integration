package io.sunilbranch.springdockerintegration.repository;

import io.sunilbranch.springdockerintegration.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Player findByEmail(String email);
}
