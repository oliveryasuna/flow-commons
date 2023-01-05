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

import java.util.function.Predicate;

/**
 * A {@link AbstractBooleanRenderer} that takes {@link Component}s for the {@code true} and {@code false} values.
 *
 * @param <S> The type of input model object.
 *
 * @author Oliver Yasuna
 */
public class StaticBooleanRenderer<S> extends AbstractBooleanRenderer<S> {

  // Constructors
  //--------------------------------------------------

  public StaticBooleanRenderer(final Predicate<S> valueProvider, final Component trueComponent,
      final Component falseComponent) {
    super(valueProvider);

    this.trueComponent = trueComponent;
    this.falseComponent = falseComponent;
  }

  // Fields
  //--------------------------------------------------

  private final Component trueComponent;

  private final Component falseComponent;

  @Override
  protected Component trueComponent(final S item) {
    return getTrueComponent();
  }

  @Override
  protected Component falseComponent(final S item) {
    return getFalseComponent();
  }

  // Methods
  //--------------------------------------------------

  public Component getTrueComponent() {
    return trueComponent;
  }

  public Component getFalseComponent() {
    return falseComponent;
  }

}
