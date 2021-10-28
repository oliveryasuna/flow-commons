package com.oliveryasuna.vaadin.commons.component.listener;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;

/**
 * A click listener that delegates the responsibility of handling different click counts to separate methods.
 *
 * @param <C> The type of component.
 * @author Oliver Yasuna
 */
public interface DelegatoryClickListener<C extends Component> extends ClickListener<C> {

  /**
   * Called when a component is clicked the first time.
   *
   * @param event The event.
   */
  default void onSingleClick(final ClickEvent<C> event) {
  }

  /**
   * Called when a component is double-clicked.
   *
   * @param event The event.
   */
  default void onDoubleClick(final ClickEvent<C> event) {
  }

  /**
   * Called when a component is clicked more than two times.
   *
   * @param event The event.
   */
  default void onMultiClick(final ClickEvent<C> event) {
  }

  /**
   * Calls either {@link #onSingleClick(ClickEvent)}, {@link #onDoubleClick(ClickEvent)}, or {@link #onMultiClick(ClickEvent)} depending on
   * {@link ClickEvent#getClickCount()}.
   *
   * @param event The event.
   */
  @Override
  default void onComponentEvent(final ClickEvent<C> event) {
    switch(event.getClickCount()) {
      case 1:
        onSingleClick(event);
        break;
      case 2:
        onDoubleClick(event);
        break;
      default:
        onMultiClick(event);
        break;
    }
  }

}
