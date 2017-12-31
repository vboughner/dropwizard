package com.vanboughner;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

public class DropwizardExperimentConfiguration extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }

    @NotEmpty
    private String weatherTemplate;

    @NotEmpty
    private String defaultWeather = "Partly Cloudy";

    @JsonProperty
    public String getWeatherTemplate() {
        return weatherTemplate;
    }

    @JsonProperty
    public void setWeatherTemplate(String weatherTemplate) {
        this.weatherTemplate = weatherTemplate;
    }

    @JsonProperty
    public String getDefaultWeather() {
        return defaultWeather;
    }

    @JsonProperty
    public void setDefaultWeather(String weather) {
        this.defaultWeather = weather;
    }
}
