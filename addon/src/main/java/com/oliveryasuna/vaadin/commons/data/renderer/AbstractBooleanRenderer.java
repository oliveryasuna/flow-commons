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
import com.oliveryasuna.commons.language.marker.Immutable;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.function.ValueProvider;

import java.util.function.Function;

/**
 * A {@link ComponentRenderer} to represent {@code boolean}s.
 * <p>
 * Uses a {@link ValueProvider} that uses the input model object to determine if {@link #trueComponent()} or {@link #falseComponent()} should be rendered.
 *
 * @param <SOURCE> The type of input model object.
 *
 * @author Oliver Yasuna
 * @since 3.0.0
 */
@Immutable
public abstract class AbstractBooleanRenderer<SOURCE> extends ComponentRenderer<Component, SOURCE> {

  // Constructors
  //--------------------------------------------------

  /**
   * Creates an instance with a value provider.
   *
   * @param valueProvider The value provider.
   */
  public AbstractBooleanRenderer(final ValueProvider<SOURCE, Boolean> valueProvider) {
    super();

    Arguments.requireNotNull(valueProvider, "Must specify a value provider.");

    this.valueProvider = valueProvider;
  }


  // Fields
  //--------------------------------------------------

  /**
   * The value provider.
   */
  private final Function<SOURCE, Boolean> valueProvider;

  // Methods
  //--------------------------------------------------

  /**
   * Gets the component which is rendered if {@link #valueProvider} returns {@code true}.
   *
   * @return A component.
   */
  protected abstract Component trueComponent();

  /**
   * Gets the component which is rendered if {@link #valueProvider} returns {@code null} or {@code false}.
   *
   * @return A component.
   */
  protected abstract Component falseComponent();

  // Overrides
  //--------------------------------------------------

  // ComponentRenderer
  //

  @Override
  public Component createComponent(final SOURCE item) {
    final Boolean value = valueProvider.apply(item);

    if(value == null || !value) {
      return falseComponent();
    }

    return trueComponent();
  }

}
