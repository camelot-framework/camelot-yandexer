package ru.yandex.qatools.camelot.yandexer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import ru.yandex.qatools.camelot.api.annotations.Filter;
import ru.yandex.qatools.camelot.api.annotations.Processor;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 11.09.14
 */
@Filter(instanceOf = {Event.class})
public class Fetcher {

    @Processor
    public EventResultsCount search(Event event) {
        WebDriver driver = new PhantomJSDriver();
        driver.get("http://yandex.ru/yandsearch?text=" + event.getKey());
        String text = driver.findElement(By.className("input__found_visibility_visible")).getText();
        driver.quit();

        return new EventResultsCount(event.getKey(), text);
    }
}
