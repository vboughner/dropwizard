package io.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.health.TemplateHealthCheck;
import io.dropwizard.resources.HelloWorldResource;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropwizardTutorialApplication extends Application<DropwizardTutorialConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropwizardTutorialApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropwizardTutorial";
    }

    @Override
    public void initialize(final Bootstrap<DropwizardTutorialConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DropwizardTutorialConfiguration configuration,
                    final Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
            configuration.getTemplate(),
            configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }
}
