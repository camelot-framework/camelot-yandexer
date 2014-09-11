package ru.yandex.qatools.camelot.yandexer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.camelot.api.EventProducer;
import ru.yandex.qatools.camelot.api.annotations.Input;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 11.09.14
 */
@Path("search")
public class Resource {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Input
    public EventProducer input;

    @GET
    public Response start(@QueryParam("key") String key) {
        logger.info("Search at yandex by key: " + key);
        input.produce(new Event(key));
        return Response.ok("Successfully").build();
    }
}
