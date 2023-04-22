package com.example.AisbergTelegramBot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@Data
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "botcommands")
public class CommandsConfig {
    private Map<String, String> commands;
    public List<String> getListCommands() {
        return (List<String>) commands.keySet();
    }

    public
}
