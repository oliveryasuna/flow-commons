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

package com.oliveryasuna.vaadin.commons.component.badge;

import com.oliveryasuna.vaadin.commons.component.AbstractComposite;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;

/**
 * A badge component.
 * <p>
 * Demonstrated in the <a href="https://vaadin.com/docs/latest/components/badge">Vaadin docs</a>.
 *
 * @author Oliver Yasuna
 */
@JsModule("@vaadin/vaadin-lumo-styles/badge.js")
@CssImport(value = "./styles/badge.css", include = "lumo-badge")
public class Badge extends AbstractComposite<Span> implements HasBadgeVariants {

  // Constructors
  //--------------------------------------------------

  protected Badge(final boolean iconFirst) {
    super();

    this.iconFirst = iconFirst;
  }

  /**
   * Creates a badge without content.
   */
  public Badge() {
    this(true);
  }

  /**
   * Creates a badge with the given text content.
   *
   * @param label The text content.
   */
  public Badge(final String label) {
    this();

    setLabel(label);
  }

  /**
   * Creates a badge with an icon.
   *
   * @param icon The icon.
   */
  public Badge(final Icon icon) {
    this();

    setIcon(icon);
  }

  /**
   * Creates a badge with text and an icon.
   *
   * @param label     The text.
   * @param icon      The icon.
   * @param iconFirst If {@code true}, the icon is the left-most component.
   */
  public Badge(final String label, final Icon icon, final boolean iconFirst) {
    this(iconFirst);

    setLabel(label);
    setIcon(icon);
  }

  // Fields
  //--------------------------------------------------

  private Span label;

  private Icon icon;

  private boolean iconFirst;

  // Methods
  //--------------------------------------------------

  /**
   * Sets the text of the existing {@link #label} component.
   *
   * @param label The text.
   */
  public void setLabel(final String label) {
    final Span labelSpan = getLabel();

    if(labelSpan != null) {
      if(label != null) {
        labelSpan.setText(label);
      } else {
        setLabel((Span)null);
      }
    } else {
      if(label != null) {
        setLabel(new Span(label));
      } else {
        setLabel((Span)null);
      }
    }
  }

  protected void setIconOnly(final boolean iconOnly) {
    getElement().getThemeList().set("icon-only", iconOnly);
  }

  @Override
  protected Span initContent() {
    final Span span = new Span();

    span.getElement().getThemeList().add("badge");

    return span;
  }

  // Getters/setters
  //--------------------------------------------------

  public Span getLabel() {
    return label;
  }

  public void setLabel(final Span label) {
    final Span oldLabel = getLabel();

    if(oldLabel != null) oldLabel.getElement().removeFromParent();

    this.label = label;

    if(this.label != null) {
      if(isIconFirst()) {
        getContent().addComponentAtIndex(getElement().getChildCount(), this.label);
      } else {
        getContent().addComponentAsFirst(this.label);
      }
    } else if(getIcon() != null) {
      setIconOnly(true);
    }
  }

  public Icon getIcon() {
    return icon;
  }

  public void setIcon(final Icon icon) {
    final Icon oldIcon = getIcon();

    if(oldIcon != null) oldIcon.getElement().removeFromParent();

    this.icon = icon;

    if(this.icon != null) {
      if(isIconFirst()) {
        getContent().addComponentAsFirst(this.icon);
      } else {
        getContent().addComponentAtIndex(getElement().getChildCount(), this.icon);
      }

      setIconOnly(getLabel() == null);
    } else {
      setIconOnly(false);
    }
  }

  public boolean isIconFirst() {
    return iconFirst;
  }

  public void setIconFirst(final boolean iconFirst) {
    final boolean previous = this.iconFirst;

    this.iconFirst = iconFirst;

    if(this.iconFirst != previous) {
      final Icon icon = getIcon();

      if(icon != null) {
        final Span label = getLabel();

        label.getElement().removeFromParent();
        icon.getElement().removeFromParent();

        final Span content = getContent();

        if(this.iconFirst) {
          content.add(icon);
          content.add(label);
        } else {
          content.add(label);
          content.add(icon);
        }
      }
    }
  }

}
