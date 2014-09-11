package ru.yandex.qatools.camelot.yandexer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import ru.yandex.qatools.camelot.api.annotations.Filter;
import ru.yandex.qatools.camelot.api.annotations.Processor;

import java.io.UnsupportedEncodingException;

import static java.net.URLEncoder.encode;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 11.09.14
 */
@Filter(instanceOf = {Event.class})
public class Fetcher {

    @Processor
    public EventResultsCount search(Event event) throws UnsupportedEncodingException {
        WebDriver driver = new PhantomJSDriver();
        driver.get("http://yandex.ru/yandsearch?text=" + encode(event.getKey(), "UTF-8"));
        String text = driver.findElement(By.className("input__found")).getText();
        driver.quit();

        return new EventResultsCount(event.getKey(), text);
    }
}
