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

import com.vaadin.flow.function.ValueProvider;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * A renderer for displaying {@link TemporalAccessor} values.
 *
 * @param <S> The source type.
 *
 * @author Oliver Yasuna
 */
public class TemporalRenderer<S> extends BaseRenderer<S, TemporalAccessor> {

  // Constructors
  //--------------------------------------------------

  /**
   * Creates a new instance.
   *
   * @param valueProvider      The provider of a temporal value given the input model object.
   * @param formatter          The temporal value formatter.
   * @param nullRepresentation The physical value to display if the value provider returns {@code null}.
   */
  public TemporalRenderer(final ValueProvider<S, TemporalAccessor> valueProvider, final DateTimeFormatter formatter, final String nullRepresentation) {
    super(valueProvider, formatter::format, nullRepresentation);

    this.formatter = formatter;
  }

  // Fields
  //--------------------------------------------------

  private final DateTimeFormatter formatter;

  // Getters/setters
  //--------------------------------------------------

  public DateTimeFormatter getFormatter() {
    return formatter;
  }

}
