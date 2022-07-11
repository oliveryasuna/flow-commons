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

package com.oliveryasuna.vaadin.commons.demo.ui.view.beacon;

import com.oliveryasuna.vaadin.commons.demo.ui.layout.main.MainLayout;
import com.oliveryasuna.vaadin.commons.demo.ui.view.DemoView;
import com.oliveryasuna.vaadin.commons.server.beacon.BeaconEvent;
import com.oliveryasuna.vaadin.commons.server.beacon.BeaconHandler;
import com.oliveryasuna.vaadin.commons.web.javascript.object.Navigator;
import com.oliveryasuna.vaadin.fluent.component.orderedlayout.HorizontalLayoutFactory;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "/beacon_", layout = MainLayout.class)
public final class BeaconView extends DemoView {

  // Constructors
  //--------------------------------------------------

  public BeaconView() {
    super("Beacon");
  }

  // Overrides
  //--------------------------------------------------

  // DemoView
  //

  @Override
  protected final void initView() {
    // begin-source-example
    // source-example-heading: Example
    ComponentEventListener<BeaconEvent> beaconListener = event -> event.getSource().access(() ->
        Notification.show("Received beacon from client with data: " + event.getData() + "."));

    BeaconHandler.addBeaconListener(UI.getCurrent(), beaconListener);

    TextField beaconDataField = new TextField("Data");
    // "Navigator.getInstance().sendBeacon(...)" executes "navigator.sendBeacon(...)" on the client.
    Button sendBeaconButton = new Button("Send Beacon", event -> Navigator.getInstance().sendBeacon(UI.getCurrent(), "/beacon/" + UI.getCurrent().getSession().getSession().getId(), beaconDataField.getValue()));
    // end-source-example

    final HorizontalLayout layout = new HorizontalLayoutFactory()
        .setAlignItems(FlexComponent.Alignment.END)
        .add(beaconDataField)
        .add(sendBeaconButton)
        .get();

    addCard("Example", layout);
  }

}
