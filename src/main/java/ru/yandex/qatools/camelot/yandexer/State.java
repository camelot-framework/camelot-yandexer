package ru.yandex.qatools.camelot.yandexer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 11.09.14
 */
public class State implements Serializable {

    private List<String> texts;

    public State() {
    }

    public State(List<String> texts) {
        this.texts = texts;
    }

    public List<String> getTexts() {
        return texts == null ? new ArrayList<String>() : texts;
    }

    public void setTexts(List<String> texts) {
        this.texts = texts;
    }
}
