package ru.yandex.qatools.camelot.yandexer;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 11.09.14
 */
public class State implements Serializable {

    private String key;
    @JsonSerialize
    private List<String> texts = new ArrayList<String>();

    public State() {
    }

    public State(String key, List<String> texts) {
        this.key = key;
        this.texts = texts;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void addText(String text) {
        this.texts.add(text);
    }
}
