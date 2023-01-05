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

package com.oliveryasuna.vaadin.commons.data.converter;

import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

import java.util.Objects;
import java.util.function.BiFunction;

/**
 * Converter that uses a default model and presentation.
 *
 * @param <P> The type of presentation value.
 * @param <M> The type of model value.
 *
 * @author Oliver Yasuna
 */
public class DefaultConverter<P, M> implements Converter<P, M> {

  // Static methods
  //--------------------------------------------------

  public static <P, M> DefaultConverter<P, M> withEquals(final Converter<P, M> converter, final M defaultModel, final P defaultPresentation) {
    return new DefaultConverter<>(converter, (presentation, context) -> (Objects.equals(presentation, defaultPresentation) ? defaultModel : null),
        (model, context) -> (Objects.equals(model, defaultModel) ? defaultPresentation : null));
  }

  // Constructors
  //--------------------------------------------------

  public DefaultConverter(final Converter<P, M> converter, final BiFunction<P, ValueContext, M> defaultModelSupplier,
      final BiFunction<M, ValueContext, P> defaultPresentationSupplier) {
    super();

    this.converter = converter;

    this.defaultModelSupplier = defaultModelSupplier;
    this.defaultPresentationSupplier = defaultPresentationSupplier;
  }

  // Fields
  //--------------------------------------------------

  private final Converter<P, M> converter;

  private final BiFunction<P, ValueContext, M> defaultModelSupplier;

  private final BiFunction<M, ValueContext, P> defaultPresentationSupplier;

  // Methods
  //--------------------------------------------------

  @Override
  public Result<M> convertToModel(final P presentation, final ValueContext context) {
    final M defaultModel = defaultModelSupplier.apply(presentation, context);

    return (defaultModel != null ? Result.ok(defaultModel) : converter.convertToModel(presentation, context));
  }

  @Override
  public P convertToPresentation(final M model, final ValueContext context) {
    final P defaultPresentation = defaultPresentationSupplier.apply(model, context);

    return (defaultPresentation != null ? defaultPresentation : converter.convertToPresentation(model, context));
  }

  // Getters/setters
  //--------------------------------------------------

  public Converter<P, M> getConverter() {
    return converter;
  }

  public BiFunction<P, ValueContext, M> getDefaultModelSupplier() {
    return defaultModelSupplier;
  }

  public BiFunction<M, ValueContext, P> getDefaultPresentationSupplier() {
    return defaultPresentationSupplier;
  }

}
