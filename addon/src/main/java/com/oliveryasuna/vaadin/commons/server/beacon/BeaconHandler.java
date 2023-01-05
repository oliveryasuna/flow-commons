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

package com.oliveryasuna.vaadin.commons.server.beacon;

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
 * <p>
 * This handles requests sent to {@code /beacon/&lt;session_id&gt;}.
 * Text data is supported and is passed down to listeners in {@link BeaconEvent}.
 *
 * @author Oliver Yasuna
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
    registerHandlerForUi(ui);

    return ComponentUtil.addListener(ui, BeaconEvent.class, listener);
  }

  /**
   * Creates a {@link BeaconHandler} for a {@link UI} if the {@link UI} does not already have one.
   *
   * @param ui The {@link UI} instance.
   */
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

  /**
   * Creates an instance for a specific {@link UI}.
   *
   * @param ui The {@link UI} instance.
   */
  public BeaconHandler(final UI ui) {
    super();

    this.ui = ui;

    this.path = "/beacon/" + ui.getSession().getSession().getId();
  }

  // Fields
  //--------------------------------------------------

  /**
   * The {@link UI} instance.
   */
  private final UI ui;

  /**
   * The path that this handler handles.
   */
  private final String path;

  // Methods
  //--------------------------------------------------

  /**
   * Gets the data of the beacon request and fires a {@link BeaconEvent} on {@link #ui}.
   *
   * @param session  The session.
   * @param request  The request.
   * @param response The response.
   *
   * @return {@code true}, always.
   *
   * @throws IOException If an IO exception occurred.
   */
  @Override
  public boolean synchronizedHandleRequest(final VaadinSession session, final VaadinRequest request, final VaadinResponse response) throws IOException {
    final String data = IOUtils.toString(request.getReader());
    final UI ui = getUi();

    ComponentUtil.fireEvent(ui, new BeaconEvent(ui, true, data));

    return true;
  }

  /**
   * Determines if this handler should handle a request.
   * <p>
   * This handler will handle the request if the request's path is equal to {@link #path}.
   *
   * @param request The request.
   *
   * @return {@code true}, if this handler should handle the request.
   *     {@code false}, otherwise.
   */
  @Override
  protected boolean canHandleRequest(final VaadinRequest request) {
    return getPath().equals(request.getPathInfo());
  }

  // Getters/setters
  //--------------------------------------------------

  public UI getUi() {
    return ui;
  }

  public String getPath() {
    return path;
  }

}
