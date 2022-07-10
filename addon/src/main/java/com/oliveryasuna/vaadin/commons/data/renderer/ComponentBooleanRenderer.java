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

package com.oliveryasuna.vaadin.commons.data.renderer;

import com.oliveryasuna.commons.language.condition.Arguments;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.function.ValueProvider;

import java.util.function.Supplier;

/**
 * A {@link AbstractBooleanRenderer}.
 *
 * @param <SOURCE> The type of input model object.
 *
 * @author Oliver Yasuna
 * @since 3.0.0
 */
public class ComponentBooleanRenderer<SOURCE> extends AbstractBooleanRenderer<SOURCE> {

  // Constructors
  //--------------------------------------------------

  /**
   * Creates an instance specifying a value provider and two component suppliers.
   *
   * @param valueProvider          The value provider.
   * @param trueComponentSupplier  The supplier of a component when the value provider returns {@code true}.
   * @param falseComponentSupplier The supplier of a component when the value provider returns {@code null} or {@code false}.
   */
  public ComponentBooleanRenderer(final ValueProvider<SOURCE, Boolean> valueProvider, final Supplier<Component> trueComponentSupplier,
      final Supplier<Component> falseComponentSupplier) {
    super(valueProvider);

    Arguments.requireNotNull(trueComponentSupplier, "Must specify a true component supplier.");
    Arguments.requireNotNull(falseComponentSupplier, "Must specify a false component supplier.");

    this.trueComponentSupplier = trueComponentSupplier;
    this.falseComponentSupplier = falseComponentSupplier;
  }

  // Fields
  //--------------------------------------------------

  /**
   * The supplier of a component when the value provider returns {@code true}.
   */
  private final Supplier<Component> trueComponentSupplier;

  /**
   * The supplier of a component when the value provider returns {@code null} or {@code false}.
   */
  private final Supplier<Component> falseComponentSupplier;

  /**
   * The saved component from a call to {@link #trueComponentSupplier}.
   */
  private Component trueComponent;

  /**
   * The saved component from a call to {@link #falseComponentSupplier}.
   */
  private Component falseComponent;

  // Overrides
  //--------------------------------------------------

  // BooleanRenderer
  //

  @Override
  protected Component trueComponent() {
    return (trueComponent != null ? trueComponent : (trueComponent = trueComponentSupplier.get()));
  }

  @Override
  protected Component falseComponent() {
    return (falseComponent != null ? falseComponent : (falseComponent = falseComponentSupplier.get()));
  }

}
