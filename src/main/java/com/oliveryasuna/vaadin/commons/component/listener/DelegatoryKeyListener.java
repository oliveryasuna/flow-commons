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
