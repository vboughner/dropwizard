package com.vanboughner;

import com.vanboughner.health.TemplateHealthCheck;
import com.vanboughner.resources.HelloWorldResource;
import com.vanboughner.resources.WeatherResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropwizardExperimentApplication extends Application<DropwizardExperimentConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropwizardExperimentApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropwizardExperiment";
    }

    @Override
    public void initialize(final Bootstrap<DropwizardExperimentConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DropwizardExperimentConfiguration configuration,
                    final Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
            configuration.getTemplate(),
            configuration.getDefaultName()
        );
        environment.jersey().register(resource);

        final WeatherResource weatherResource = new WeatherResource(
            configuration.getWeatherTemplate(),
            configuration.getDefaultWeather()
        );
        environment.jersey().register(weatherResource);

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
    }
}
