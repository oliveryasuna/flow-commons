/*
 * Copyright 2022 Oliver Yasuna
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
import com.oliveryasuna.commons.language.marker.Utility;
import com.oliveryasuna.vaadin.commons.server.SessionUITracker;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinSession;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Various utilities for {@link UI}.
 *
 * @author Oliver Yasuna
 * @since 4.0.0
 */
@Utility
public final class UIUtils {

  // Static utility methods
  //--------------------------------------------------

  /**
   * Performs an action on each {@link UI} instance.
   *
   * @param action The action.
   */
  public static void forEach(final Consumer<UI> action) {
    final Map<VaadinSession, List<UI>> sessionUiMap = SessionUITracker.getSessionUiMap();

    sessionUiMap.forEach((session, uis) -> uis.forEach(action));
  }

  // Constructors
  //--------------------------------------------------

  private UIUtils() {
    super();

    throw new UnsupportedInstantiationException();
  }

}
