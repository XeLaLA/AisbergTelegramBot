package com.example.AisbergTelegramBot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Data
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "botcommands")
public class CommandsConfig {
    Map<String, String> commands;
}
