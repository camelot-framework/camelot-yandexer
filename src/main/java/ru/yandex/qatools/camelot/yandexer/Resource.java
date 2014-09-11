package ru.yandex.qatools.camelot.yandexer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.camelot.api.AggregatorRepository;
import ru.yandex.qatools.camelot.api.EventProducer;
import ru.yandex.qatools.camelot.api.annotations.Input;
import ru.yandex.qatools.camelot.api.annotations.Repository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 11.09.14
 */
@Path("search")
public class Resource {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Input
    public EventProducer input;

    @Repository
    AggregatorRepository<State> repo;

    @GET
    @Path("results")
    public List<State> results() {
        List<State> results = new ArrayList<State>();
        for (String key : repo.keys()) {
            results.add(repo.get(key));
        }
        return results;
    }

    @GET
    public Response start(@QueryParam("key") String key) {
        logger.info("Search at yandex by key: " + key);
        if (isEmpty(key)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        input.produce(new Event(key));
        return Response.ok("Successfully").build();
    }
}
