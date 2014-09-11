package ru.yandex.qatools.camelot.yandexer;

import ru.yandex.qatools.camelot.api.EventProducer;
import ru.yandex.qatools.camelot.api.annotations.Input;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 11.09.14
 */
@Path("search")
public class Resource {

    @Input
    public EventProducer input;

    @GET
    public Response start(@QueryParam("key") String key) {
        if (isEmpty(key)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        input.produce(new Event(key));
        return Response.ok("Success").build();
    }
}
