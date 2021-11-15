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
