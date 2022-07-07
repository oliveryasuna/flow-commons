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

import com.oliveryasuna.vaadin.commons.component.ComponentExtension;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;

/**
 * A {@link Button} with extended functionality.
 *
 * @author Oliver Yasuna
 * @since 3.0.0
 */
public class VButton extends Button implements ComponentExtension, HasButtonVariants {

  // Constructors
  //--------------------------------------------------

  public VButton() {
    super();
  }

  public VButton(final String text) {
    super(text);
  }

  public VButton(final Component icon) {
    super(icon);
  }

  public VButton(final String text, final Component icon) {
    super(text, icon);
  }

  public VButton(final String text, final ComponentEventListener<ClickEvent<Button>> clickListener) {
    super(text, clickListener);
  }

  public VButton(final Component icon, final ComponentEventListener<ClickEvent<Button>> clickListener) {
    super(icon, clickListener);
  }

  public VButton(final String text, final Component icon, final ComponentEventListener<ClickEvent<Button>> clickListener) {
    super(text, icon, clickListener);
  }

}
