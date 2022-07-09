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

package com.oliveryasuna.vaadin.commons.server.beacon;

import com.oliveryasuna.commons.language.condition.Arguments;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.SynchronizedRequestHandler;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinResponse;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.shared.Registration;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

/**
 * Handles beacon requests.
 * <p>
 * Inspired by <a href="https://cookbook.vaadin.com/notice-closed">https://cookbook.vaadin.com/notice-closed</a>.
 *
 * @author Oliver Yasuna
 * @since 4.0.0
 */
public class BeaconHandler extends SynchronizedRequestHandler {

  // Static methods
  //--------------------------------------------------

  /**
   * Adds a beacon listener to a {@link UI}.
   *
   * @param ui       The {@link UI} instance.
   * @param listener The listener.
   *
   * @return A new {@link Registration} object.
   */
  public static Registration addBeaconListener(final UI ui, final ComponentEventListener<BeaconEvent> listener) {
    Arguments.requireNotNull(ui, "Must specify a UI.");
    Arguments.requireNotNull(listener, "Must specify a listener.");

    registerHandlerForUi(ui);

    return ComponentUtil.addListener(ui, BeaconEvent.class, listener);
  }

  private static void registerHandlerForUi(final UI ui) {
    if(ComponentUtil.getData(ui, BeaconHandler.class) != null) return;

    final BeaconHandler beaconHandler = new BeaconHandler(ui);

    final VaadinSession session = ui.getSession();

    session.addRequestHandler(beaconHandler);

    ui.addDetachListener(event -> session.removeRequestHandler(beaconHandler));

    ComponentUtil.setData(ui, BeaconHandler.class, beaconHandler);
  }

  // Constructors
  //--------------------------------------------------

  public BeaconHandler(final UI ui) {
    super();

    Arguments.requireNotNull(ui, "Must specify a UI.");

    this.ui = ui;

    this.path = "/beacon/" + ui.getSession().getSession().getId();
  }

  // Fields
  //--------------------------------------------------

  private final UI ui;

  private final String path;

  // Overrides
  //--------------------------------------------------

  // SynchronizedRequestHandler
  //

  @Override
  public boolean synchronizedHandleRequest(final VaadinSession session, final VaadinRequest request, final VaadinResponse response) throws IOException {
    final String data = IOUtils.toString(request.getReader());

    ComponentUtil.fireEvent(ui, new BeaconEvent(ui, true, data));

    return true;
  }

  @Override
  protected boolean canHandleRequest(final VaadinRequest request) {
    return path.equals(request.getPathInfo());
  }

  // RequestHandler
  //

}
