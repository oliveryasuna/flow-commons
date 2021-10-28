package com.oliveryasuna.vaadin.commons.function;

import com.vaadin.flow.dom.Element;

import java.util.function.Consumer;

/**
 * Represents a function that accepts an {@link Element}.
 *
 * @author Oliver Yasuna
 */
@FunctionalInterface
public interface ElementConsumer extends Consumer<Element> {

}
