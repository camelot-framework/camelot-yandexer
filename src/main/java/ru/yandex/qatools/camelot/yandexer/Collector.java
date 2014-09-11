package ru.yandex.qatools.camelot.yandexer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.camelot.api.annotations.Aggregate;
import ru.yandex.qatools.camelot.api.annotations.AggregationKey;
import ru.yandex.qatools.camelot.api.annotations.Filter;
import ru.yandex.qatools.fsm.annotations.FSM;
import ru.yandex.qatools.fsm.annotations.OnTransit;
import ru.yandex.qatools.fsm.annotations.Transit;
import ru.yandex.qatools.fsm.annotations.Transitions;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 11.09.14
 */
@Filter(instanceOf = {EventWithText.class})
@FSM(start = State.class)
@Transitions(
        @Transit(on = EventWithText.class)
)
@Aggregate
public class Collector {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @OnTransit
    public void collect(State to, EventWithText event) {
        logger.info("Collect event with key {} and message {}", event.getKey(), event.getText());
        to.getTexts().add(event.getText());
    }

    @AggregationKey
    public String key(EventWithText eventWithText) {
        return eventWithText.getKey();
    }
}
