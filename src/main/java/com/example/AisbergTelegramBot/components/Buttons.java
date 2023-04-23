package com.example.AisbergTelegramBot.components;

import com.example.AisbergTelegramBot.config.BotCommandsConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class Buttons {
    private final BotCommandsConfig botCommandsConfig;

    public Buttons(BotCommandsConfig botCommandsConfig) {
        this.botCommandsConfig = botCommandsConfig;
    }

    //Получить список со списками кнопок, где кол-во = кол-во строк с кнопками в боте
    //вложенные списки содержат кнопки для отображения
    //@param listCommands - список комманд для кнопок для привязик
    //@param splitSize - кол-во кнопок в одной строке
    private List<List<InlineKeyboardButton>> getListRowsButtonsInLine(List<String> listCommands, int splitSize) {
        //Список со списками комманд по которому создаем список кнопок
        List<List<String>>  rowInLineCommand = splitArray(listCommands, splitSize);
        //Список со списками кнопок
        return rowInLineCommand
                .stream()
                .map(array -> array.stream()
                        .map(el ->{
                            InlineKeyboardButton button = new InlineKeyboardButton(el);
                            button.setCallbackData("/"+el);
                            return button;
                        })
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private <T> List<List <T>> splitArray(List<T> array, int splitSize) {

        int numberOfArrays = array.size() / splitSize;
        int remainder = array.size() % splitSize;

        int start = 0;
        int end = 0;

        List<List<T>> list = new ArrayList<>();
        for (int i = 0; i < numberOfArrays; i++) {
            end += splitSize;
            list.add(array.subList(start, end));
            start = end;
        }

        if(remainder > 0) {
            list.add(array.subList(start, array.size()));
        }
        return list;
    }

    public InlineKeyboardMarkup inlineMarkup() {

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(getListRowsButtonsInLine(botCommandsConfig.getListCommands().stream().toList(),2));

        return markupInline;
    }
}