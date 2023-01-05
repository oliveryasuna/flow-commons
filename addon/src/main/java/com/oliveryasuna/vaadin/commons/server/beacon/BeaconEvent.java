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

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.UI;

/**
 * An event invoked by a {@link BeaconHandler}.
 *
 * @author Oliver Yasuna
 */
public class BeaconEvent extends ComponentEvent<UI> {

  // Constructors
  //--------------------------------------------------

  /**
   * Creates an instance specifying the source {@link UI}, whether the event was triggered by the client or not, and the data of the beacon.
   *
   * @param source     The source {@link UI}.
   * @param fromClient Whether triggered by the client.
   * @param data       The data of the beacon.
   */
  public BeaconEvent(final UI source, final boolean fromClient, final String data) {
    super(source, fromClient);

    this.data = data;
  }

  // Fields
  //--------------------------------------------------

  /**
   * The data of the beacon.
   */
  private final String data;

  // Getters/setters
  //--------------------------------------------------

  public String getData() {
    return data;
  }

}
