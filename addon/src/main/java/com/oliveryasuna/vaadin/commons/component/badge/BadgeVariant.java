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

import com.oliveryasuna.commons.language.condition.Arguments;
import com.oliveryasuna.vaadin.commons.component.theme.ThemeVariant;
import com.vaadin.flow.component.HasElement;

/**
 * Badge theme variants.
 *
 * @author Oliver Yasuna
 */
public enum BadgeVariant implements ThemeVariant {

  // Values
  //--------------------------------------------------

  // Sizes
  //

  /**
   * The {@code small} variant.
   */
  SMALL("small"),

  // Colors
  //

  /**
   * The {@code primary} variant.
   */
  PRIMARY("primary"),

  /**
   * The {@code success} variant.
   */
  SUCCESS("success"),

  /**
   * The {@code error} variant.
   */
  ERROR("error"),

  /**
   * The {@code contrast} variant.
   */
  CONTRAST("contrast"),

  // Shapes
  //

  /**
   * The {@code pill} variant.
   */
  PILL("pill");

  // Constructors
  //--------------------------------------------------

  /**
   * Creates a value specifying the variant name.
   *
   * @param variantName The variant name.
   */
  BadgeVariant(final String variantName) {
    this.variantName = variantName;
  }

  // Fields
  //--------------------------------------------------

  /**
   * The variant name.
   */
  private final String variantName;

  // Methods
  //--------------------------------------------------

  /**
   * If you don't want to use {@link com.oliveryasuna.vaadin.commons.component.badge.Badge}.
   *
   * @param hasElement The element.
   * @param present    If {@code true}, adds the variant. Otherwise, removes the variant.
   */
  public final void apply(final HasElement hasElement, final boolean present) {
    Arguments.requireNotNull(hasElement, "Must specify an argument.");

    hasElement.getElement().getThemeList().set(variantName, present);
  }

  @Override
  public final String getVariantName() {
    return variantName;
  }

}
