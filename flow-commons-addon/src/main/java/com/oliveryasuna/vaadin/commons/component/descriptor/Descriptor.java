package com.oliveryasuna.vaadin.commons.component.descriptor;

/**
 * Basically an alias for {@link com.vaadin.flow.component.PropertyDescriptor}, but with the order of the parameterized types reversed.
 * <p>
 * <i>Getters before setters, right?</i>
 *
 * @param <G> See {@link com.vaadin.flow.component.PropertyDescriptor}.
 * @param <S> See {@link com.vaadin.flow.component.PropertyDescriptor}.
 * @author Oliver Yasuna
 */
public interface Descriptor<G, S> extends com.vaadin.flow.component.PropertyDescriptor<S, G> {

}
