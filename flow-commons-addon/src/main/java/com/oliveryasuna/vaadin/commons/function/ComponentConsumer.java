package com.oliveryasuna.vaadin.commons.function;

import com.vaadin.flow.component.Component;

import java.util.function.Consumer;

/**
 * Represents a function that accepts a {@link Component}.
 *
 * @author Oliver Yasuna
 */
@FunctionalInterface
public interface ComponentConsumer extends Consumer<Component> {

}
