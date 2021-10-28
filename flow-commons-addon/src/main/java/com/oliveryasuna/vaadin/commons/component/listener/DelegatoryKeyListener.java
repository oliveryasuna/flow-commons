package com.oliveryasuna.vaadin.commons.component.listener;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.internal.KeyboardEvent;

/**
 * A key listener that delegates the responsibility of handling different modifiers to separate methods.
 *
 * @param <E> The type of component.
 * @author Oliver Yasuna
 */
public interface DelegatoryKeyListener<E extends KeyboardEvent> extends ComponentEventListener<E> {

  /**
   * Called if the "Shift" modifier is present.
   *
   * @param event The event.
   */
  default void onShiftEvent(final E event) {
  }

  /**
   * Called if the "Control" modifier is present.
   *
   * @param event The event.
   */
  default void onControlEvent(final E event) {
  }

  /**
   * Called if the "Alt" modifier is present.
   *
   * @param event The event.
   */
  default void onAltEvent(final E event) {
  }

  /**
   * Called if the "Alt Graph" modifier is present.
   *
   * @param event The event.
   */
  default void onAltGraphEvent(final E event) {
  }

  /**
   * Called if the "Meta" modifier is present.
   *
   * @param event The event.
   */
  default void onMetaEvent(final E event) {
  }

  /**
   * Calls other methods.
   *
   * @param event The event.
   */
  @Override
  default void onComponentEvent(final E event) {
    if(event.getModifiers().contains(KeyModifier.SHIFT)) onShiftEvent(event);
    if(event.getModifiers().contains(KeyModifier.CONTROL)) onControlEvent(event);
    if(event.getModifiers().contains(KeyModifier.ALT)) onAltEvent(event);
    if(event.getModifiers().contains(KeyModifier.ALT_GRAPH)) onAltGraphEvent(event);
    if(event.getModifiers().contains(KeyModifier.META)) onMetaEvent(event);
  }

}
