/*
 * Copyright 2021 Oliver Yasuna
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.oliveryasuna.vaadin.commons.component;

import com.oliveryasuna.vaadin.commons.component.descriptor.Descriptor;
import com.oliveryasuna.vaadin.commons.function.ComponentPredicate;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.shared.Registration;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Variant component utilities.
 *
 * @author Oliver Yasuna
 */
public final class ComponentUtils {

  /**
   * Finds all children of a component ({@code parent}) that pass a filter ({@code filter}).
   * <p>
   * If the filter ({@code filter}) is {@code null}, all children are included (which is equivalent to {@link Component#getChildren()}).
   *
   * @param parent The parent component.
   * @param filter The filter.
   * @return A stream of the matches.
   */
  public static Stream<Component> findChildren(final Component parent, final ComponentPredicate filter) {
    if(parent == null) throw new IllegalArgumentException("Argument [parent] is null.");

    return parent.getChildren()
        .filter(child -> filter == null || filter.test(child));
  }

  /**
   * Finds all children of a component ({code parent}) with a type or super type filter ({@code type}).
   *
   * @param parent    The parent component.
   * @param type      The type or super type.
   * @param baseClass If true, the parameter {@code type} can be a super type.
   * @return A stream of the matches.
   */
  public static Stream<Component> findChildrenByType(final Component parent, final Class<? extends Component> type, final boolean baseClass) {
    if(type == null) throw new IllegalArgumentException("Argument [type] is null.");

    return findChildren(parent, component -> baseClass ? type.isAssignableFrom(component.getClass()) : component.getClass().equals(type));
  }

  /**
   * Finds the first child of a component ({@code parent}) that passes a filter ({@code filter}).
   *
   * @param parent The parent component.
   * @param filter The filter.
   * @return If a match was found, then that match, else {@code null}, both wrapped in {@link Optional}.
   */
  public static Optional<Component> findFirstChild(final Component parent, final ComponentPredicate filter) {
    if(parent == null) throw new IllegalArgumentException("Argument [parent] is null.");

    for(final Component child : parent.getChildren().toArray(Component[]::new)) {
      if(filter == null || filter.test(child)) return Optional.of(child);
    }

    return Optional.empty();
  }

  /**
   * Finds all descendants of a component ({@code parent}) that pass a filter ({@code filter}).
   * <p>
   * If the filter ({@code filter}) is {@code null}, all descendants are included.
   *
   * <u>Warning</u>:
   *
   * @param parent The parent component.
   * @param filter The filter.
   * @return A stream of the matches.
   */
  public static Stream<Component> findDescendants(final Component parent, final ComponentPredicate filter) {
    if(parent == null) throw new IllegalArgumentException("Argument [parent] is null.");

    return findChildren(parent, filter)
        .flatMap(child -> findChildren(parent, filter));
  }

  /**
   * Finds all descendants of a component ({code parent}) with a type or super type filter ({@code type}).
   *
   * @param parent    The parent component.
   * @param type      The type or super type.
   * @param baseClass If true, the parameter {@code type} can be a super type.
   * @return A stream of the matches.
   */
  public static Stream<Component> findDescendantsByType(final Component parent, final Class<? extends Component> type, final boolean baseClass) {
    if(type == null) throw new IllegalArgumentException("Argument [type] is null.");

    return findDescendants(parent, component -> baseClass ? type.isAssignableFrom(component.getClass()) : component.getClass().equals(type));
  }

  public static <T> T getDescriptorValue(final Component component, final Descriptor<T, ?> descriptor) {
    if(component == null) throw new IllegalArgumentException("Argument [component] is null.");
    if(descriptor == null) throw new IllegalArgumentException("Argument [descriptor] is null.");

    return descriptor.get(component);
  }

  public static <T> T getDescriptorValue(final Component component, final com.vaadin.flow.component.PropertyDescriptor<?, T> descriptor) {
    if(component == null) throw new IllegalArgumentException("Argument [component] is null.");
    if(descriptor == null) throw new IllegalArgumentException("Argument [descriptor] is null.");

    return descriptor.get(component);
  }

  public static <T> void setDescriptorValue(final Component component, final Descriptor<?, T> descriptor, final T value) {
    if(component == null) throw new IllegalArgumentException("Argument [component] is null.");
    if(descriptor == null) throw new IllegalArgumentException("Argument [descriptor] is null.");

    descriptor.set(component, value);
  }

  public static <T> void setDescriptorValue(final Component component, final com.vaadin.flow.component.PropertyDescriptor<T, ?> descriptor, final T value) {
    if(component == null) throw new IllegalArgumentException("Argument [component] is null.");
    if(descriptor == null) throw new IllegalArgumentException("Argument [descriptor] is null.");

    descriptor.set(component, value);
  }

  @SuppressWarnings("unchecked")
  public static <E extends ComponentEvent<?>> Registration addListener(final Object component, final Class<E> eventClass,
      final ComponentEventListener<? extends E> listener) {
    if(component == null) throw new IllegalArgumentException("Argument [component] is null.");
    if(listener == null) throw new IllegalArgumentException("Argument [listener] is null.");

    if(!(component instanceof Component)) throw new IllegalStateException("Not a component [" + component.getClass() + "].");

    return ComponentUtil.addListener((Component)component, eventClass, (ComponentEventListener<E>)listener);
  }

  private ComponentUtils() {
    throw new UnsupportedOperationException("Class cannot be instantiated.");
  }

}
