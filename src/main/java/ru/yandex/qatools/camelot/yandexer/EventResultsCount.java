package ru.yandex.qatools.camelot.yandexer;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 11.09.14
 */
public class EventResultsCount extends Event {

    private String resultsCount;

    public EventResultsCount(String key, String resultsCount) {
        super(key);
        this.resultsCount = resultsCount;
    }

    public String getResultsCount() {
        return resultsCount;
    }

    public void setResultsCount(String resultsCount) {
        this.resultsCount = resultsCount;
    }
}
