package io.sunilbranch.springdockerintegration.config;

import io.sunilbranch.springdockerintegration.model.Player;
import io.sunilbranch.springdockerintegration.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class LoadInitialDatabase implements ApplicationRunner {

    public static Logger logger = LoggerFactory.getLogger(LoadInitialDatabase.class);

    private PlayerRepository playerRepository;

    public LoadInitialDatabase(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Loading the initial Data into database");
        playerRepository.save(new Player("sunil", "chityala", "scsunil24@gmail.com", "Male", "10.9.8.10", "http://localhost"));
    }
}
