/*
 * Copyright 2023 Oliver Yasuna
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

import com.oliveryasuna.commons.language.exception.UnsupportedInstantiationException;
import com.vaadin.flow.component.*;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.function.SerializableConsumer;
import com.vaadin.flow.shared.Registration;

import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Various component utilities.
 *
 * @author Oliver Yasuna
 */
public final class ComponentUtils {

  // Static methods
  //--------------------------------------------------

  // Finding components
  //

  /**
   * Finds all components in a given array that pass a filter.
   *
   * @param components The components to search through.
   * @param filter     The filter.
   *
   * @return A stream of the matches.
   *     If {@code components} is {@code null} or empty, an empty stream is returned.
   *     If {@code filter} is empty, a stream of all {@code components} is returned.
   */
  public static Stream<Component> findComponents(final Component[] components, final Predicate<Component> filter) {
    if(components == null || components.length == 0) return Stream.empty();

    if(filter == null) return Arrays.stream(components);

    return Arrays.stream(components)
        .filter(filter);
  }

  /**
   * Finds all children of a component that pass a filter.
   * <p>
   * Calls {@link #findComponents(Component[], Predicate)} with the specific first argument, {@code parent.getChildren().toArray(Component[]::new)}.
   *
   * @param parent The parent component.
   * @param filter The filter.
   *
   * @return A stream of the matches.
   *
   * @see #findComponents(Component[], Predicate) for a generalized method.
   * @see #findDescendents(Component, Predicate) to find all descendents.
   */
  public static Stream<Component> findChildren(final Component parent, final Predicate<Component> filter) {
    if(parent == null) return Stream.empty();

    return findComponents(parent.getChildren().toArray(Component[]::new), filter);
  }

  /**
   * Finds all descendents of a component that pass a filter.
   *
   * @param parent The parent component.
   * @param filter The filter.
   *
   * @return A stream of the matches.
   *
   * @see #findComponents(Component[], Predicate) for a generalized method.
   * @see #findChildren(Component, Predicate) for only one level of descendents.
   */
  public static Stream<Component> findDescendents(final Component parent, final Predicate<Component> filter) {
    if(parent == null) return Stream.empty();

    return findChildren(parent, filter)
        .flatMap(child -> findChildren(parent, filter));
  }

  // PropertyDescriptor
  //

  // Useful utilities relating to PropertyDescriptor.
  // Vaadin property descriptors are often encapsulated.

  /**
   * Gets the value of a property by a {@link PropertyDescriptor}.
   *
   * @param component  The component.
   * @param descriptor The {@link PropertyDescriptor}.
   * @param <T>        The type of value.
   *
   * @return The value, as specified by {@link PropertyDescriptor#get(HasElement)}.
   */
  public static <T> T getProperty(final Component component, final PropertyDescriptor<?, T> descriptor) {
    return descriptor.get(component);
  }

  /**
   * Sets the value of a property by a {@link PropertyDescriptor}.
   *
   * @param component  The component.
   * @param descriptor The {@link PropertyDescriptor}.
   * @param value      The value.
   * @param <T>        The type of value.
   */
  public static <T> void setProperty(final Component component, final PropertyDescriptor<T, ?> descriptor, final T value) {
    descriptor.set(component, value);
  }

  // Events
  //

  /**
   * Arguably unsafe way to add listeners to components.
   *
   * @param component The component.
   * @param eventType The type of event.
   * @param listener  The listener.
   * @param <E>       The type of event.
   *
   * @return The listener {@link Registration}.
   */
  public static <E extends ComponentEvent<?>> Registration addListener(final Component component, final Class<E> eventType,
      final ComponentEventListener<? extends E> listener) {
    return ComponentUtil.addListener(component, eventType, (ComponentEventListener<E>)listener);
  }

  /**
   * Fires an event.
   *
   * @param component The component.
   * @param event     The event.
   * @param <C>       The type of component.
   */
  public static <C extends Component> void fireEvent(final C component, final ComponentEvent<C> event) {
    ComponentUtil.fireEvent(component, event);
  }

  // Hierarchy
  //

  /**
   * Removes a component from its parent, if it has a parent and that parent implements {@link HasComponents}.
   *
   * @param component The component.
   *
   * @return {@code true}, if the component was assumed to be removed.
   *     {@code false}, if the component has no parent or its parent does not have children.
   */
  public static boolean removeFromParent(final Component component) {
    final Optional<Component> parentOptional = component.getParent();

    if(parentOptional.isEmpty() || !(parentOptional.get() instanceof HasComponents)) return false;

    ((HasComponents)parentOptional.get()).remove(component);

    return true;
  }

  /**
   * Inserts a component before an existing child.
   *
   * @param component  The existing child to insert the new component before.
   * @param newSibling The new child.
   *
   * @return {@code true}, if the new component was inserted.
   *     {@code false}, otherwise.
   */
  public static boolean insertBefore(final Component component, final Component newSibling) {
    final Optional<Component> parentOptional = component.getParent();

    if(parentOptional.isEmpty() || !(parentOptional.get() instanceof HasOrderedComponents)) return false;

    final HasOrderedComponents parent = (HasOrderedComponents)parentOptional.get();

    parent.addComponentAtIndex(parent.indexOf(component), newSibling);

    return true;
  }

  /**
   * Inserts a component after an existing child.
   *
   * @param component  The existing child to insert the new component after.
   * @param newSibling The new child.
   *
   * @return {@code true}, if the new component was inserted.
   *     {@code false}, otherwise.
   */
  public static boolean insertAfter(final Component component, final Component newSibling) {
    final Optional<Component> parentOptional = component.getParent();

    if(parentOptional.isEmpty() || !(parentOptional.get() instanceof HasOrderedComponents)) return false;

    final HasOrderedComponents parent = (HasOrderedComponents)parentOptional.get();

    parent.addComponentAtIndex(parent.indexOf(component) + 1, newSibling);

    return true;
  }

  // TODO: Apache StringUtils like methods.
  //       E.g., `add` that ignored `null`.

  public static void addTo(final Component parent, final Component... children) {
    if(parent instanceof HasComponents) {
      ((HasComponents)parent).add(children);
    } else {
      final Element parentElement = parent.getElement();

      for(final Component child : children) {
        parentElement.appendChild(child.getElement());
      }
    }
  }

  public static void removeFrom(final Component parent, final Component... children) {
    if(parent instanceof HasComponents) {
      ((HasComponents)parent).remove(children);
    } else {
      final Element parentElement = parent.getElement();

      for(final Component component : children) {
        parentElement.removeChild(component.getElement());
      }
    }
  }

  public static void remove(final Component... children) {
    for(final Component component : children) {
      component.getElement().removeFromParent();
    }
  }

  public static void addSlotted(final Component parent, final String slot, final Component... children) {
    if(parent instanceof HasComponents) {
      final HasComponents hasComponents = (HasComponents)parent;

      setSlot(slot, children);
      hasComponents.add(children);
    } else {
      final Element parentElement = parent.getElement();

      for(final Component component : children) {
        setSlot(slot, component);
        parentElement.appendChild(component.getElement());
      }
    }
  }

  public static void setSlot(final String slot, final Component... components) {
    for(final Component component : components) {
      component.getElement().setAttribute("slot", slot);
    }
  }

  public static void resetSlot(final Component... components) {
    for(final Component component : components) {
      component.getElement().removeAttribute("slot");
    }
  }

  public static Stream<Component> getSlotted(final Component parent) {
    return parent.getChildren()
        .filter(child -> child.getElement().hasAttribute("slot"));
  }

  public static Stream<Component> getSlotted(final Component parent, final String slot) {
    return parent.getChildren()
        .filter(child -> slot.equals(child.getElement().getAttribute("slot")));
  }

  public static Stream<Component> getUnslotted(final Component parent) {
    return parent.getChildren()
        .filter(child -> !child.getElement().hasAttribute("slot"));
  }

  public static void removeAllUnslotted(final Component parent) {
    if(parent instanceof HasComponents) {
      final HasComponents hasComponents = (HasComponents)parent;

      parent.getChildren()
          .filter(child -> !child.getElement().hasAttribute("slot"))
          .forEach(hasComponents::remove);
    } else {
      parent.getChildren()
          .filter(child -> !child.getElement().hasAttribute("slot"))
          .forEach(ComponentUtils::remove);
    }
  }

  public static <C extends Component> Future<Void> access(final C component, final BiConsumer<C, UI> command) {
    final UI componentUI = component.getUI().orElse(null);
    final UI threadLocalUI = UI.getCurrent();

    UI ui = null;

    // The thread-local `UI` is not always set in non-UI threads.
    if(componentUI != null && !componentUI.equals(threadLocalUI)) {
      // The component is attached to a UI, and
      // the component's UI is not the same as the thread-local UI (which could be `null`).

      ui = componentUI;

      UI.setCurrent(ui);
    } else if(componentUI == null && threadLocalUI != null) {
      // The component is not attached to a UI, and
      // the thread-local UI is set.

      ui = threadLocalUI;
    }

    try {
      if(ui == null) {
        throw new IllegalStateException("No UI available.");
      }

      final UI finalUI = ui;

      return finalUI.access(() -> command.accept(component, finalUI));
    } finally {
      if(ui != null && !ui.equals(threadLocalUI)) {
        UI.setCurrent(threadLocalUI);
      }
    }
  }

  public static void runBeforeClientResponse(final Component component, final SerializableConsumer<UI> command) {
    component.getElement().getNode()
        .runWhenAttached(ui -> ui.beforeClientResponse(component, context -> command.accept(ui)));
  }

  public static void runWhenAttachedBeforeClientResponse(final Component component, final SerializableConsumer<UI> command) {
    component.getElement().getNode()
        .runWhenAttached(ui -> ui.beforeClientResponse(component, context -> command.accept(ui)));
  }

  public static boolean hasData(final Component component, final Class<?> type) {
    return (ComponentUtil.getData(component, type) != null);
  }

  public static boolean hasData(final Component component, final String key) {
    return (ComponentUtil.getData(component, key) != null);
  }

  // Constructors
  //--------------------------------------------------

  private ComponentUtils() {
    super();

    throw new UnsupportedInstantiationException();
  }

}
