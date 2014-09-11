package ru.yandex.qatools.camelot.yandexer;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 11.09.14
 */
public class EventWithText extends Event {

    private String text;

    public EventWithText(String key, String text) {
        super(key);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
