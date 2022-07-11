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

package com.oliveryasuna.vaadin.commons.demo.ui.view.buttons;

import com.oliveryasuna.vaadin.commons.component.button.*;
import com.oliveryasuna.vaadin.commons.demo.ui.layout.main.MainLayout;
import com.oliveryasuna.vaadin.commons.demo.ui.view.DemoView;
import com.oliveryasuna.vaadin.fluent.component.orderedlayout.VerticalLayoutFactory;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/buttons", layout = MainLayout.class)
public final class ButtonsView extends DemoView {

  // Constructors
  //--------------------------------------------------

  public ButtonsView() {
    super("Buttons");
  }

  // Methods
  //--------------------------------------------------

  private void createIconOnlyCard() {
    // begin-source-example
    // source-example-heading: Icon-only
    // Labels for "aria-label".

    final IconButton iconButton = new IconButton("Vaadin", VaadinIcon.VAADIN_V.create());

    final CreateButton createButton = new CreateButton("Create");
    final DeleteButton deleteButton = new DeleteButton("Delete");
    final ModifyButton modifyButton = new ModifyButton("Modify");
    final SaveButton saveButton = new SaveButton("Save");
    final CloseButton closeButton = new CloseButton("Close");
    final InfoButton infoButton = new InfoButton("Info");
    // end-source-example

    addCard("Icon-only", new HorizontalLayout(iconButton, createButton, deleteButton, modifyButton, saveButton, closeButton, infoButton));
  }

  private void createLabelsFirstCard() {
    // begin-source-example
    // source-example-heading: Labels first
    final IconButton iconButton = new IconButton("Vaadin", VaadinIcon.VAADIN_V.create(), IconButton.IconButtonType.LABEL_LEFT);

    final CreateButton createButton = new CreateButton("Create", IconButton.IconButtonType.LABEL_LEFT);
    final DeleteButton deleteButton = new DeleteButton("Delete", IconButton.IconButtonType.LABEL_LEFT);
    final ModifyButton modifyButton = new ModifyButton("Modify", IconButton.IconButtonType.LABEL_LEFT);
    final SaveButton saveButton = new SaveButton("Save", IconButton.IconButtonType.LABEL_LEFT);
    final CloseButton closeButton = new CloseButton("Close", IconButton.IconButtonType.LABEL_LEFT);
    final InfoButton infoButton = new InfoButton("Info", IconButton.IconButtonType.LABEL_LEFT);
    // end-source-example

    addCard("Labels first", new VerticalLayoutFactory()
        .setPadding(false)
        .add(new HorizontalLayout(iconButton, createButton, deleteButton, modifyButton))
        .add(new HorizontalLayout(saveButton, closeButton, infoButton))
        .get());
  }

  private void createLabelsLastCard() {
    // begin-source-example
    // source-example-heading: Labels last
    final IconButton iconButton = new IconButton("Vaadin", VaadinIcon.VAADIN_V.create(), IconButton.IconButtonType.LABEL_RIGHT);

    final CreateButton createButton = new CreateButton("Create", IconButton.IconButtonType.LABEL_RIGHT);
    final DeleteButton deleteButton = new DeleteButton("Delete", IconButton.IconButtonType.LABEL_RIGHT);
    final ModifyButton modifyButton = new ModifyButton("Modify", IconButton.IconButtonType.LABEL_RIGHT);
    final SaveButton saveButton = new SaveButton("Save", IconButton.IconButtonType.LABEL_RIGHT);
    final CloseButton closeButton = new CloseButton("Close", IconButton.IconButtonType.LABEL_RIGHT);
    final InfoButton infoButton = new InfoButton("Info", IconButton.IconButtonType.LABEL_RIGHT);
    // end-source-example

    addCard("Labels last", new VerticalLayoutFactory()
        .setPadding(false)
        .add(new HorizontalLayout(iconButton, createButton, deleteButton, modifyButton))
        .add(new HorizontalLayout(saveButton, closeButton, infoButton))
        .get());
  }

  // Overrides
  //--------------------------------------------------

  // DemoView
  //

  @Override
  protected final void initView() {
    createIconOnlyCard();
    createLabelsFirstCard();
    createLabelsLastCard();
  }

}
