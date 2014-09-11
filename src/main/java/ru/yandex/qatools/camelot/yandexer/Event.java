package ru.yandex.qatools.camelot.yandexer;

import java.io.Serializable;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 11.09.14
 */
public class Event implements Serializable {
    private String key;

    public Event(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
