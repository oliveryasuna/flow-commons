/*
 * Copyright 2021 Oliver Yasuna
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this software without
 *      specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
