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

package com.oliveryasuna.vaadin.commons.demo.ui.view.badge;

import com.oliveryasuna.vaadin.commons.component.badge.Badge;
import com.oliveryasuna.vaadin.commons.demo.ui.layout.main.MainLayout;
import com.oliveryasuna.vaadin.commons.demo.ui.view.AbstractView;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/badge", layout = MainLayout.class)
public final class BadgeView extends AbstractView {

  // Constructors
  //--------------------------------------------------

  public BadgeView() {
    super("Badge");
  }

  // Methods
  //--------------------------------------------------

  private void createBasicCard() {
    // begin-source-example
    // source-example-heading: Basic
    final Badge pendingBadge = new Badge("Pending");

    final Badge confirmedBadge = new Badge("Confirmed");
    confirmedBadge.setSuccess(true);

    final Badge deniedBadge = new Badge("Denied");
    deniedBadge.setError(true);

    final Badge onHoldBadge = new Badge("On hold");
    onHoldBadge.setContrast(true);
    // end-source-example

    addCard("Basic", new HorizontalLayout(pendingBadge, confirmedBadge, deniedBadge, onHoldBadge));
  }

  private void createLabelAndIconCard() {
    // begin-source-example
    // source-example-heading: Icons
    final Badge pendingBadgeIconFirst = new Badge("Pending", VaadinIcon.CLOCK.create(), true);

    final Badge confirmedBadgeIconFirst = new Badge("Confirmed", VaadinIcon.CLOCK.create(), true);
    confirmedBadgeIconFirst.setSuccess(true);

    final Badge deniedBadgeIconFirst = new Badge("Denied", VaadinIcon.CLOCK.create(), true);
    deniedBadgeIconFirst.setError(true);

    final Badge onHoldBadgeIconFirst = new Badge("On hold", VaadinIcon.CLOCK.create(), true);
    onHoldBadgeIconFirst.setContrast(true);

    final Badge pendingBadgeLabelFirst = new Badge("Pending", VaadinIcon.CLOCK.create(), false);

    final Badge confirmedBadgeLabelFirst = new Badge("Confirmed", VaadinIcon.CLOCK.create(), false);
    confirmedBadgeLabelFirst.setSuccess(true);

    final Badge deniedBadgeLabelFirst = new Badge("Denied", VaadinIcon.CLOCK.create(), false);
    deniedBadgeLabelFirst.setError(true);

    final Badge onHoldBadgeLabelFirst = new Badge("On hold", VaadinIcon.CLOCK.create(), false);
    onHoldBadgeLabelFirst.setContrast(true);
    // end-source-example

    addCard("Icons", new VerticalLayout(
        new HorizontalLayout(pendingBadgeIconFirst, confirmedBadgeIconFirst, deniedBadgeIconFirst, onHoldBadgeIconFirst),
        new HorizontalLayout(pendingBadgeLabelFirst, confirmedBadgeLabelFirst, deniedBadgeLabelFirst, onHoldBadgeLabelFirst)
    ));
  }

  // Overrides
  //--------------------------------------------------

  // DemoView
  //

  @Override
  protected final void initView() {
    createBasicCard();
    createLabelAndIconCard();
  }

}
