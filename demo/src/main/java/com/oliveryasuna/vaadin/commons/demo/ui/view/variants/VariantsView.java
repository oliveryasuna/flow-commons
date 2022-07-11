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

package com.oliveryasuna.vaadin.commons.demo.ui.view.variants;

import com.oliveryasuna.vaadin.commons.component.button.VButton;
import com.oliveryasuna.vaadin.commons.component.checkbox.VCheckboxGroup;
import com.oliveryasuna.vaadin.commons.component.menubar.VMenuBar;
import com.oliveryasuna.vaadin.commons.component.progressbar.VProgressBar;
import com.oliveryasuna.vaadin.commons.component.radiobutton.VRadioButtonGroup;
import com.oliveryasuna.vaadin.commons.component.splitlayout.VSplitLayout;
import com.oliveryasuna.vaadin.commons.component.tabs.VTab;
import com.oliveryasuna.vaadin.commons.component.tabs.VTabs;
import com.oliveryasuna.vaadin.commons.demo.ui.layout.main.MainLayout;
import com.oliveryasuna.vaadin.commons.demo.ui.view.DemoView;
import com.oliveryasuna.vaadin.fluent.component.menubar.MenuBarFactory;
import com.oliveryasuna.vaadin.fluent.component.orderedlayout.HorizontalLayoutFactory;
import com.oliveryasuna.vaadin.fluent.component.orderedlayout.VerticalLayoutFactory;
import com.oliveryasuna.vaadin.fluent.component.progressbar.ProgressBarFactory;
import com.oliveryasuna.vaadin.fluent.component.tabs.TabsFactory;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.Route;

import java.util.function.Consumer;

@Route(value = "/variants", layout = MainLayout.class)
public final class VariantsView extends DemoView {

  // Constructors
  //--------------------------------------------------

  public VariantsView() {
    super("Variants");
  }

  // Methods
  //--------------------------------------------------

  private void createVButtonCard() {
    // begin-source-example
    // source-example-heading: VButton
    // Uses Fluent Flow: https://vaadin.com/directory/component/fluent-flow.
    String text = "VButton";

    VButton button = new VButton(text, VaadinIcon.HEART.create());

    VerticalLayout layout = new VerticalLayoutFactory()
        .setPadding(false)
        .add(button)
        .add(new HorizontalLayoutFactory()
            .getStyle().handle(style -> style.set("flex-wrap", "wrap")).back()
            .add(new Checkbox("small", event -> button.setLumoSmall(event.getValue())))
            .add(new Checkbox("large", event -> button.setLumoLarge(event.getValue())))
            .add(new Checkbox("tertiary", event -> button.setLumoTertiary(event.getValue())))
            .add(new Checkbox("tertiary-inline", event -> button.setLumoTertiaryInline(event.getValue())))
            .add(new Checkbox("primary", event -> button.setLumoPrimary(event.getValue())))
            .add(new Checkbox("success", event -> button.setLumoSuccess(event.getValue())))
            .add(new Checkbox("error", event -> button.setLumoError(event.getValue())))
            .add(new Checkbox("contrast", event -> button.setLumoContrast(event.getValue())))
            .add(new Checkbox("icon", event -> {
              if(event.getValue()) {
                button.setLumoIcon(true);
                button.setText(null);
              } else {
                button.setLumoIcon(false);
                button.setText(text);
              }
            }))
            .get())
        .get();
    // end-source-example

    addCard("VButton", layout);
  }

  private void createVCheckboxGroupCard() {
    // begin-source-example
    // source-example-heading: VCheckboxGroup
    // Uses Fluent Flow: https://vaadin.com/directory/component/fluent-flow.
    VCheckboxGroup<String> checkboxGroup = new VCheckboxGroup<>();

    checkboxGroup.setItems("Ohhhh", "Say", "Can", "You", "See", "Every", "Other", "Country", "Hates", "We");

    VerticalLayout layout = new VerticalLayoutFactory()
        .setPadding(false)
        .add(checkboxGroup)
        .add(new HorizontalLayoutFactory()
            .getStyle().handle(style -> style.set("flex-wrap", "wrap")).back()
            .add(new Checkbox("vertical", event -> checkboxGroup.setLumoVertical(event.getValue())))
            .get())
        .get();
    // end-source-example

    addCard("VCheckboxGroup", layout);
  }

  private void createVMenuBarCard() {
    // begin-source-example
    // source-example-heading: VMenuBar
    // Uses Fluent Flow: https://vaadin.com/directory/component/fluent-flow.
    Consumer<MenuBar> textItemsAdder = menuBar -> {
      menuBar.addItem("I'm");
      menuBar.addItem("a");
      menuBar.addItem("pretty");
      menuBar.addItem("girl");
      menuBar.addItem("(Futurama S03E12)");
    };

    Consumer<MenuBar> iconItemsAdder = menuBar -> {
      menuBar.addItem(VaadinIcon.HEART.create());
      menuBar.addItem(VaadinIcon.BUG.create());
      menuBar.addItem(VaadinIcon.MENU.create());
      menuBar.addItem(VaadinIcon.DIAMOND.create());
      menuBar.addItem(VaadinIcon.BOLD.create());
    };

    VMenuBar menuBar = (VMenuBar)(new MenuBarFactory(new VMenuBar())
        .complete(factory -> textItemsAdder.accept(factory.get()))
        .get());

    VerticalLayout layout = new VerticalLayoutFactory()
        .setPadding(false)
        .add(menuBar)
        .add(new HorizontalLayoutFactory()
            .getStyle().handle(style -> style.set("flex-wrap", "wrap")).back()
            .add(new Checkbox("small", event -> menuBar.setLumoSmall(event.getValue())))
            .add(new Checkbox("large", event -> menuBar.setLumoLarge(event.getValue())))
            .add(new Checkbox("tertiary", event -> menuBar.setLumoTertiary(event.getValue())))
            .add(new Checkbox("tertiary-inline", event -> menuBar.setLumoTertiaryInline(event.getValue())))
            .add(new Checkbox("primary", event -> menuBar.setLumoPrimary(event.getValue())))
            .add(new Checkbox("contrast", event -> menuBar.setLumoContrast(event.getValue())))
            .add(new Checkbox("icon", event -> {
              if(event.getValue()) {
                menuBar.setLumoIcon(true);
                menuBar.removeAll();
                iconItemsAdder.accept(menuBar);
              } else {
                menuBar.setLumoIcon(false);
                menuBar.removeAll();
                textItemsAdder.accept(menuBar);
              }
            }))
            .get())
        .get();
    // end-source-example

    addCard("VMenuBar", layout);
  }

  private void createVProgressBarCard() {
    // begin-source-example
    // source-example-heading: VProgressBar
    // Uses Fluent Flow: https://vaadin.com/directory/component/fluent-flow.
    VProgressBar progressBar = (VProgressBar)(new ProgressBarFactory(new VProgressBar())
        .setIndeterminate(true)
        .get());

    VerticalLayout layout = new VerticalLayoutFactory()
        .setPadding(false)
        .add(progressBar)
        .add(new HorizontalLayoutFactory()
            .getStyle().handle(style -> style.set("flex-wrap", "wrap")).back()
            .add(new Checkbox("contrast", event -> progressBar.setLumoContrast(event.getValue())))
            .add(new Checkbox("error", event -> progressBar.setLumoError(event.getValue())))
            .add(new Checkbox("success", event -> progressBar.setLumoSuccess(event.getValue())))
            .get())
        .get();
    // end-source-example

    addCard("VProgressBar", layout);
  }

  private void createVRadioGroupCard() {
    // begin-source-example
    // source-example-heading: VRadioGroup
    // Uses Fluent Flow: https://vaadin.com/directory/component/fluent-flow.
    VRadioButtonGroup<String> radioButtonGroup = new VRadioButtonGroup<>();

    radioButtonGroup.setItems("I", "Hate", "You");

    VerticalLayout layout = new VerticalLayoutFactory()
        .setPadding(false)
        .add(radioButtonGroup)
        .add(new HorizontalLayoutFactory()
            .getStyle().handle(style -> style.set("flex-wrap", "wrap")).back()
            .add(new Checkbox("vertical", event -> radioButtonGroup.setLumoVertical(event.getValue())))
            .get())
        .get();
    // end-source-example

    addCard("VRadioGroup", layout);
  }

  private void createVSplitLayoutCard() {
    // begin-source-example
    // source-example-heading: VSplitLayout
    // Uses Fluent Flow: https://vaadin.com/directory/component/fluent-flow.
    VSplitLayout splitLayout = new VSplitLayout(new Span("PRIMARY"), new Span("SECONDARY"));

    splitLayout.setWidthFull();

    VerticalLayout layout = new VerticalLayoutFactory()
        .setPadding(false)
        .add(splitLayout)
        .add(new HorizontalLayoutFactory()
            .getStyle().handle(style -> style.set("flex-wrap", "wrap")).back()
            .add(new Checkbox("small", event -> splitLayout.setLumoSmall(event.getValue())))
            .add(new Checkbox("minimal", event -> splitLayout.setLumoMinimal(event.getValue())))
            .get())
        .get();
    // end-source-example

    addCard("VSplitLayout", layout);
  }

  private void createVTabCard() {
    // begin-source-example
    // source-example-heading: VTab
    // Uses Fluent Flow: https://vaadin.com/directory/component/fluent-flow.
    VTab tab = new VTab(VaadinIcon.BUG.create(), new Span("Bug"));

    VerticalLayout layout = new VerticalLayoutFactory()
        .setPadding(false)
        .add(tab)
        .add(new HorizontalLayoutFactory()
            .getStyle().handle(style -> style.set("flex-wrap", "wrap")).back()
            .add(new Checkbox("icon-on-top", event -> tab.setLumoIconOnTop(event.getValue())))
            .get())
        .get();
    // end-source-example

    addCard("VTab", layout);
  }

  private void createVTabsCard() {
    // begin-source-example
    // source-example-heading: VTabs
    // Uses Fluent Flow: https://vaadin.com/directory/component/fluent-flow.
    VTabs tabs = (VTabs)(new TabsFactory(new VTabs())
        .setWidthFull()
        .add(new Tab(VaadinIcon.BUG.create(), new Span("Bug")))
        .add(new Tab(VaadinIcon.DIAMOND.create(), new Span("Ohhh Shiny")))
        .add(new Tab(VaadinIcon.CLOSE.create(), new Span("Exit")))
        .add(new Tab(VaadinIcon.UMBRELLA.create(), new Span("It's Raining")))
        .add(new Tab(VaadinIcon.BAN.create(), new Span("GO AWAY!!!")))
        .add(new Tab(VaadinIcon.ASTERISK.create(), new Span("Did you read the fine print?")))
        .get());

    VerticalLayout layout = new VerticalLayoutFactory()
        .setPadding(false)
        .add(tabs)
        .add(new HorizontalLayoutFactory()
            .getStyle().handle(style -> style.set("flex-wrap", "wrap")).back()
            .add(new Checkbox("icon-on-top", event -> tabs.setLumoIconOnTop(event.getValue())))
            .add(new Checkbox("centered", event -> tabs.setLumoCentered(event.getValue())))
            .add(new Checkbox("minimal", event -> tabs.setLumoMinimal(event.getValue())))
            .add(new Checkbox("hide-scroll-buttons", event -> tabs.setLumoHideScrollButtons(event.getValue())))
            .add(new Checkbox("equal-width-tabs", event -> tabs.setLumoEqualWidthTabs(event.getValue())))
            .get())
        .get();
    // end-source-example

    addCard("VTabs", layout);
  }

  // Overrides
  //--------------------------------------------------

  // DemoView
  //

  @Override
  protected final void initView() {
    createVButtonCard();
    createVCheckboxGroupCard();
    createVMenuBarCard();
    createVProgressBarCard();
    createVRadioGroupCard();
    createVSplitLayoutCard();
    createVTabCard();
    createVTabsCard();
  }

}
