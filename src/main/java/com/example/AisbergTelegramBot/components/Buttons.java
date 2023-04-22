package com.example.AisbergTelegramBot.components;

import com.example.AisbergTelegramBot.config.CommandsConfig;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Buttons {
    private final CommandsConfig commandsConfig;
//    private Map<String, InlineKeyboardButton> buttons = new HashMap<String, InlineKeyboardButton>();
    private static final InlineKeyboardButton START_BUTTON = new InlineKeyboardButton("Start");
    private static final InlineKeyboardButton HELP_BUTTON = new InlineKeyboardButton("Help");

    public Buttons(CommandsConfig commandsConfig) {
        this.commandsConfig = commandsConfig;
//        commands.getCommandsConfig()
//                .getCommands()
//                .keySet()
//                .forEach(key->buttons.put(key, new InlineKeyboardButton(key)));
    }

    private List<List<InlineKeyboardButton>> createButtons(List<String> listCommands){



        return null;
    }

    public InlineKeyboardMarkup inlineMarkup() {

       // buttons.entrySet().forEach(entry -> entry.getValue().setCallbackData("/"+entry.getKey()));
        List<String> listCommands =  commandsConfig.getListCommands();


        List<InlineKeyboardButton> rowInline = List.of(START_BUTTON, HELP_BUTTON);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }
}