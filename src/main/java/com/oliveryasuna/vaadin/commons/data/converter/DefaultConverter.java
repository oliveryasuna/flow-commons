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

package com.oliveryasuna.vaadin.commons.data.converter;

import com.oliveryasuna.commons.language.condition.Arguments;
import com.oliveryasuna.commons.language.marker.Immutable;
import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

import java.util.Objects;

/**
 * Converter that uses a default model and presentation.
 *
 * @param <P> The type of presentation value.
 * @param <M> The type of model value.
 *
 * @author Oliver Yasuna
 * @since 2.0.0
 */
@Immutable
public class DefaultConverter<P, M> implements Converter<P, M> {

  // Constructors
  //--------------------------------------------------

  public DefaultConverter(final P defaultPresentation, final M defaultModel, final Converter<P, M> converter) {
    super();

    Arguments.requireNotNull(converter);

    this.defaultPresentation = defaultPresentation;
    this.defaultModel = defaultModel;

    this.converter = converter;
  }

  // Fields
  //--------------------------------------------------

  protected final P defaultPresentation;

  protected final M defaultModel;

  protected final Converter<P, M> converter;

  // Overrides
  //--------------------------------------------------

  // Converters
  //

  @Override
  public Result<M> convertToModel(final P value, final ValueContext context) {
    return (Objects.equals(value, defaultPresentation) ? Result.ok(defaultModel) : converter.convertToModel(value, context));
  }

  @Override
  public P convertToPresentation(final M value, final ValueContext context) {
    return (Objects.equals(value, defaultModel) ? defaultPresentation : convertToPresentation(value, context));
  }

}
