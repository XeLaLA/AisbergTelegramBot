package com.example.AisbergTelegramBot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "bot")
public class BotConfig {
    private String name;
    private String token;
    private String chatId;
}
