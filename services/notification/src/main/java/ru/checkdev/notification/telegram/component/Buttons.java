package ru.checkdev.notification.telegram.component;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class Buttons {
    private static final InlineKeyboardButton NEW_USER = new InlineKeyboardButton("Новый пользователь");
    private static final InlineKeyboardButton USER_INFO = new InlineKeyboardButton("Информация пользователя");

    private static final InlineKeyboardButton LINK_ACCOUNT = new InlineKeyboardButton("Привязать аккаунт");

    private static final InlineKeyboardButton UNLINK_ACCOUNT = new InlineKeyboardButton("Отвязать аккаунт");

    public static InlineKeyboardMarkup inlineMarkup() {
        NEW_USER.setCallbackData("/new");
        USER_INFO.setCallbackData("/check");
        LINK_ACCOUNT.setCallbackData("/bind");
        UNLINK_ACCOUNT.setCallbackData("/unbind");

        List<InlineKeyboardButton> rowInline = List.of(NEW_USER, USER_INFO);
        List<InlineKeyboardButton> rowInline2 = List.of(LINK_ACCOUNT, UNLINK_ACCOUNT);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline, rowInline2);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }
}
