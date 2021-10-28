package com.oliveryasuna.vaadin.commons.function;

import com.vaadin.flow.component.Component;

import java.util.function.Supplier;

/**
 * Supplies a {@link Component} or subclass.
 *
 * @author Oliver Yasuna
 */
@FunctionalInterface
public interface ComponentSupplier extends Supplier<Component> {

}
