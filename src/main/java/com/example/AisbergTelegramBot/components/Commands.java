package com.example.AisbergTelegramBot.components;

import com.example.AisbergTelegramBot.config.CommandsConfig;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class Commands implements BotCommands{

    private final CommandsConfig commandsConfig;
    private List<BotCommand> listOfCommands = new ArrayList<>();

    public Commands(CommandsConfig commandsConfig) {
        this.commandsConfig = commandsConfig;
        commandsConfig.getCommands().entrySet()
                .forEach(entry -> listOfCommands.add(new BotCommand("/" + entry.getKey(), entry.getValue())));
    }
}
