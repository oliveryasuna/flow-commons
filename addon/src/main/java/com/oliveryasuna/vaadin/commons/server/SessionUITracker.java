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

package com.oliveryasuna.vaadin.commons.server;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.*;

import java.util.*;

/**
 * Keeps track of {@link VaadinSession} and {@link UI} instances.
 *
 * @author Oliver Yasuna
 * @since 4.0.0
 */
public final class SessionUITracker implements VaadinSessionLifecycleListener, UIInitListener {

  // Static fields
  //--------------------------------------------------

  /**
   * A map of sessions and their associated {@link UI}s.
   */
  private static final Map<VaadinSession, List<UI>> SESSION_UI_MAP = Collections.synchronizedMap(new LinkedHashMap<>());

  // Static methods
  //--------------------------------------------------

  public static Set<VaadinSession> getSessions() {
    return Collections.unmodifiableSet(SESSION_UI_MAP.keySet());
  }

  public static Map<VaadinSession, List<UI>> getSessionUiMap() {
    return Collections.unmodifiableMap(SESSION_UI_MAP);
  }

  // Constructors
  //--------------------------------------------------

  SessionUITracker() {
    super();
  }

  // VaadinSessionInitListener
  //--------------------------------------------------

  @Override
  public final void sessionInit(final SessionInitEvent event) throws ServiceException {
    SESSION_UI_MAP.put(event.getSession(), Collections.synchronizedList(new ArrayList<>()));
  }

  // VaadinSessionDestroyListener
  //

  @Override
  public final void sessionDestroy(final SessionDestroyEvent event) {
    SESSION_UI_MAP.remove(event.getSession());
  }

  // UIInitListener
  //

  @Override
  public final void uiInit(final UIInitEvent event) {
    final UI ui = event.getUI();
    final VaadinSession session = ui.getSession();

    SESSION_UI_MAP.get(session).add(ui);

    ui.addDetachListener(detachEvent -> SESSION_UI_MAP.get(session).remove(ui));
  }

}
