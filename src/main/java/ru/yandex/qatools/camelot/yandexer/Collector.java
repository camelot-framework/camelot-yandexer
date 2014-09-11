package ru.yandex.qatools.camelot.yandexer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.camelot.api.ClientMessageSender;
import ru.yandex.qatools.camelot.api.annotations.*;
import ru.yandex.qatools.fsm.annotations.FSM;
import ru.yandex.qatools.fsm.annotations.OnTransit;
import ru.yandex.qatools.fsm.annotations.Transit;
import ru.yandex.qatools.fsm.annotations.Transitions;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 11.09.14
 */
@Aggregate
@Filter(instanceOf = {EventResultsCount.class})
@FSM(start = State.class)
@Transitions(@Transit(on = EventResultsCount.class))
public class Collector {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ClientSender
    ClientMessageSender client;

    @OnTransit
    public void collect(State to, EventResultsCount event) {
        logger.info("Collect event with key {} and message {}", event.getKey(), event.getResultsCount());
        to.setKey(event.getKey());
        to.addText(event.getResultsCount());
    }

    @AggregationKey
    public String key(EventResultsCount eventResultsCount) {
        return eventResultsCount.getKey();
    }

    @OnTimer(cron = "*/5 * * * * ?")
    public void notifyClient(State state) {
        client.send(state);
    }
}
