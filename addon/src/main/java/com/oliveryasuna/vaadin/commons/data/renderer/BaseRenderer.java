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

import com.vaadin.flow.data.renderer.BasicRenderer;
import com.vaadin.flow.function.ValueProvider;

import java.util.function.Function;

/**
 * A renderer that has a default null representation and conversion function for the returned object.
 *
 * @param <S> The type of the source object.
 * @param <T> The type of the value to be rendered.
 *
 * @author Oliver Yasuna
 */
public class BaseRenderer<S, T> extends BasicRenderer<S, T> {

  // Constructors
  //--------------------------------------------------

  public BaseRenderer(final ValueProvider<S, T> valueProvider, final Function<T, String> converter, final String nullRepresentation) {
    super(valueProvider);

    this.converter = converter;
    this.nullRepresentation = nullRepresentation;
  }

  // Fields
  //--------------------------------------------------

  private final Function<T, String> converter;

  private final String nullRepresentation;

  // Methods
  //--------------------------------------------------

  @Override
  protected String getFormattedValue(final T object) {
    return (object != null ? getConverter().apply(object) : getNullRepresentation());
  }

  // Getters/setters
  //--------------------------------------------------

  public Function<T, String> getConverter() {
    return converter;
  }

  public String getNullRepresentation() {
    return nullRepresentation;
  }

}
