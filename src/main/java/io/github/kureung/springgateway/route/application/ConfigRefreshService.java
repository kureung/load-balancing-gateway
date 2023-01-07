package io.github.kureung.springgateway.route.application;

import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ConfigRefreshService {
    private final ApplicationEventPublisher applicationEventPublisher;

    public ConfigRefreshService(final ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void execute() {
        applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));
    }
}
