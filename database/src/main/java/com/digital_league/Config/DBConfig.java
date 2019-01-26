package com.digital_league.Config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.digital_league.Entity")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("com.digital_league.Repository")
public class DBConfig {

}
