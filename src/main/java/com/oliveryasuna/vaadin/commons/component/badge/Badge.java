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

package com.oliveryasuna.vaadin.commons.component.badge;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;

/**
 * A badge component.
 *
 * @author Oliver Yasuna
 * @since 3.0.0
 */
public class Badge extends Span implements HasBadgeVariants {

  // Constructors
  //--------------------------------------------------

  /**
   * Creates a badge without content.
   */
  public Badge() {
    super();

    getElement().getThemeList().add("badge");

    this.iconFirst = true;
  }

  /**
   * Creates a badge with text.
   *
   * @param label The text.
   */
  public Badge(final String label) {
    this();

    add(this.label = new Span(label));
  }

  /**
   * Creates a badge with text and an icon.
   *
   * @param label     The text.
   * @param icon      The icon.
   * @param iconFirst If {@code true}, the icon is the left-most component.
   */
  public Badge(final String label, final Icon icon, final boolean iconFirst) {
    this();

    icon.getStyle().set("padding", "var(--lumo-space-xs)");

    if(iconFirst) {
      add(this.label = new Span(label));
      add(this.icon = icon);
    } else {
      add(this.icon = icon);
      add(this.label = new Span(label));
    }
  }

  // Fields
  //--------------------------------------------------

  private Span label;

  private Icon icon;

  private boolean iconFirst;

  // Methods
  //--------------------------------------------------

  public void setLabel(final String label) {
    this.label.setText(label);
  }

  // Getters/setters
  //--------------------------------------------------

  public Span getLabel() {
    return label;
  }

  public void setLabel(final Span label) {
    getLabel().getElement().removeFromParent();

    this.label = label;

    if(isIconFirst()) {
      addComponentAtIndex(getElement().getChildCount(), this.label);
    } else {
      addComponentAsFirst(this.label);
    }
  }

  public Icon getIcon() {
    return icon;
  }

  public void setIcon(final Icon icon) {
    if(getIcon() != null) getIcon().getElement().removeFromParent();

    this.icon = icon;

    if(isIconFirst()) {
      addComponentAsFirst(this.icon);
    } else {
      addComponentAtIndex(getElement().getChildCount(), this.icon);
    }
  }

  public boolean isIconFirst() {
    return iconFirst;
  }

  public void setIconFirst(final boolean iconFirst) {
    final boolean previous = this.iconFirst;

    this.iconFirst = iconFirst;

    if(this.iconFirst != previous && getIcon() != null) {
      getLabel().getElement().removeFromParent();
      getIcon().getElement().removeFromParent();

      if(this.iconFirst) {
        add(getIcon());
        add(getLabel());
      } else {
        add(getLabel());
        add(getIcon());
      }
    }
  }

}
