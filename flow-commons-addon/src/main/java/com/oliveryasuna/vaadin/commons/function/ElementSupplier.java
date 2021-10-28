package com.oliveryasuna.vaadin.commons.function;

import com.vaadin.flow.dom.Element;

import java.util.function.Supplier;

/**
 * Supplies a {@link Element} or subclass.
 *
 * @author Oliver Yasuna
 */
@FunctionalInterface
public interface ElementSupplier extends Supplier<Element> {

}
