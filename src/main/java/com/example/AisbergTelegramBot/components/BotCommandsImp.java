package com.example.AisbergTelegramBot.components;

import com.example.AisbergTelegramBot.config.BotCommandsConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.ArrayList;
import java.util.List;

@Component
public class BotCommandsImp implements BotCommands{

    private final BotCommandsConfig botCommandsConfig;
    private List<BotCommand> listOfCommands = new ArrayList<>();

    public BotCommandsImp(BotCommandsConfig botCommandsConfig) {
        this.botCommandsConfig = botCommandsConfig;
        botCommandsConfig.getCommands().entrySet()
                .forEach(entry -> listOfCommands.add(new BotCommand("/" + entry.getKey(), entry.getValue())));
    }
    public List<BotCommand> getListOfCommands(){
        return listOfCommands;
    }
}
