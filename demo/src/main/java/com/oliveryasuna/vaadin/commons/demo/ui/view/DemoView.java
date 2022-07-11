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

package com.oliveryasuna.vaadin.commons.demo.ui.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.NativeButton;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class DemoView extends com.vaadin.flow.demo.DemoView {

  // Static methods
  //--------------------------------------------------

  private static String getVariantButtonText(final String variantName, final boolean variantPresent) {
    return String.format(variantPresent ? "Remove '%s' variant" : "Add '%s' variant", variantName);
  }

  // Constructors
  //--------------------------------------------------

  protected DemoView(final String header) {
    super();

    addComponentAsFirst(new H1(header));
  }

  // Overrides
  //--------------------------------------------------

  // com.vaadin.flow.demo.DemoView
  //

  // Supports non-Lumo variants.
  @Override
  protected <T extends Enum<?>, C extends Component & HasTheme> void addVariantsDemo(final Supplier<C> componentSupplier, final BiConsumer<C, T> addVariant,
      final BiConsumer<C, T> removeVariant, final Function<T, String> variantToThemeName, final T... variants) {
    final C component = componentSupplier.get();

    component.setId("componentWithVariantsDemo");

    final Div message = new Div();

    message.setText("Toggle a variant to see how the component's appearance will change.");

    final Div variantToggles = new Div();

    variantToggles.setId("variantToggleButtonsDiv");

    for(final T variant : variants) {
      final String variantName = variantToThemeName.apply(variant);

      variantToggles.add(new NativeButton(getVariantButtonText(variantName, component.getThemeNames().contains(variantName)), event -> {
        final boolean variantPresent = component.getThemeNames().contains(variantName);

        if(variantPresent) {
          removeVariant.accept(component, variant);
        } else {
          addVariant.accept(component, variant);
        }

        event.getSource().setText(getVariantButtonText(variantName, !variantPresent));
      }));
    }

    addCard("Theme variants usage", message, component, variantToggles);
  }

}
