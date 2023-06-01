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

package com.oliveryasuna.vaadin.commons.data.renderer;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.data.renderer.ComponentRenderer;

import java.util.function.Predicate;

/**
 * A {@link ComponentRenderer} to represent {@code boolean}s.
 * <p>
 * Uses a {@link Predicate} that uses the input model object to determine if {@link #trueComponent(Object)} or {@link #falseComponent(Object)} should be
 * rendered.
 *
 * @param <S> The type of input model object.
 *
 * @author Oliver Yasuna
 * @since 3.0.0
 */
public abstract class AbstractBooleanRenderer<S> extends ComponentRenderer<Component, S> {

  // Constructors
  //--------------------------------------------------

  protected AbstractBooleanRenderer(final Predicate<S> valueProvider) {
    super();

    this.valueProvider = valueProvider;
  }

  // Fields
  //--------------------------------------------------

  private final Predicate<S> valueProvider;

  // Methods
  //--------------------------------------------------

  /**
   * Gets the component which is rendered if {@link #valueProvider} returns {@code true}.
   *
   * @param item The source item.
   *
   * @return A component.
   */
  protected abstract Component trueComponent(S item);

  /**
   * Gets the component which is rendered if {@link #valueProvider} returns {@code null} or {@code false}.
   *
   * @param item The source item.
   *
   * @return A component.
   */
  protected abstract Component falseComponent(S item);

  @Override
  public Component createComponent(final S item) {
    return createComponent(item, getValueProvider().test(item));
  }

  protected Component createComponent(final S item, final boolean value) {
    return (value ? trueComponent(item) : falseComponent(item));
  }

  // Getters/setters
  //--------------------------------------------------

  public Predicate<S> getValueProvider() {
    return valueProvider;
  }

}
