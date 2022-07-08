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

package com.oliveryasuna.vaadin.commons.component.button;

import com.oliveryasuna.commons.language.condition.Arguments;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

/**
 * A {@link Button} with an icon.
 *
 * @author Oliver Yasuna
 * @since 3.0.0
 */
public class IconButton extends VButton {

  // Constructors
  //--------------------------------------------------

  /**
   * Creates any type of {@link IconButton}.
   *
   * @param label The text or {@code aria-label}.
   * @param icon  The icon.
   * @param type  The type.
   */
  public IconButton(final String label, final Component icon, final IconButtonType type) {
    super();

    Arguments.requireNotNull(icon, "Must specify an icon.");
    Arguments.requireNotNull(icon, "Must specify a type.");

    if(type == IconButtonType.ICON_ONLY) {
      addThemeVariants(ButtonVariant.LUMO_ICON);

      setIcon(icon);

      if(label != null) getElement().setAttribute("aria-label", label);
    } else {
      setText(label);
      setIcon(icon);

      if(type == IconButtonType.LABEL_LEFT) {
        setIconAfterText(true);
      }
    }
  }

  public IconButton(final String label, final Component icon, final IconButtonType type, final ComponentEventListener<ClickEvent<Button>> clickListener) {
    this(label, icon, type);

    Arguments.requireNotNull(clickListener, "Must specify a click listener.");

    addClickListener(clickListener);
  }

  /**
   * Creates an icon-only button.
   *
   * @param label The {@code aria-label}.
   * @param icon  The icon.
   */
  public IconButton(final String label, final Component icon) {
    this(label, icon, IconButtonType.ICON_ONLY);
  }

  public IconButton(final String label, final Component icon, final ComponentEventListener<ClickEvent<Button>> clickListener) {
    this(label, icon);

    Arguments.requireNotNull(clickListener, "Must specify a click listener.");

    addClickListener(clickListener);
  }

  // Nested
  //--------------------------------------------------

  /**
   * The types.
   *
   * @author Oliver Yasuna
   * @since 3.0.0
   */
  public enum IconButtonType {

    // Values
    //--------------------------------------------------

    /**
     * Only an icon, with an optional {@code aria-label} attribute.
     */
    ICON_ONLY,

    /**
     * A button with an icon then label.
     */
    LABEL_LEFT,

    /**
     * A button with a label then icon.
     */
    LABEL_RIGHT

  }

}
