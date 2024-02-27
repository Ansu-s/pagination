package com.example.pagination.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class FlywayConfig {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    public void initial(){
        log.info("Migration started");
        executeFlyway(dataSource);
        log.info("Migration ended");
    }

    private void executeFlyway(DataSource dataSource){
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:/scripts")
                .load();
        flyway.migrate();
    }
}
