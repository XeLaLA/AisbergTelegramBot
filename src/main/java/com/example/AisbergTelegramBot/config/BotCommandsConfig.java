package com.example.AisbergTelegramBot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Set;

@Configuration
@Data
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "botcommands")
public class BotCommandsConfig {
    private Map<String, String> commands;
    public Set<String> getListCommands(){
        if(commands == null && commands.keySet().isEmpty()) return null;
        return commands.keySet();
    }
}
