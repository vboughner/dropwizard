package com.vanboughner.resources;

import com.vanboughner.api.Saying;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Path("/weather")
@Produces(MediaType.APPLICATION_JSON)
public class WeatherResource {
    private final String weatherTemplate;
    private final String defaultWeather;
    private final AtomicLong counter;

    public WeatherResource(String weatherTemplate, String defaultWeather) {
        this.weatherTemplate = weatherTemplate;
        this.defaultWeather= defaultWeather;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayWeather(@QueryParam("weather") Optional<String> name) {
        final String value = String.format(weatherTemplate, name.orElse(defaultWeather));
        return new Saying(counter.incrementAndGet(), value);
    }
}
