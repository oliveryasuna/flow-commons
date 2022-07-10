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
import com.vaadin.flow.data.renderer.BasicRenderer;
import com.vaadin.flow.function.ValueProvider;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * A {@link com.vaadin.flow.data.renderer.Renderer} for {@link TemporalAccessor}.
 *
 * @param <SOURCE> The type of input model object.
 *
 * @author Oliver Yasuna
 * @since 3.0.0
 */
public class TemporalRenderer<SOURCE> extends BasicRenderer<SOURCE, TemporalAccessor> {

  // Static fields
  //--------------------------------------------------

  /**
   * The default representation of {@code null}.
   */
  private static final String DEFAULT_NULL_REPRESENTATION = "";

  // Constructors
  //--------------------------------------------------

  /**
   * Creates a new instance.
   *
   * @param valueProvider      The provider of a temporal value given the input model object.
   * @param formatter          The temporal value formatter.
   * @param nullRepresentation The physical value to display if the value provider returns {@code null}.
   */
  public TemporalRenderer(final ValueProvider<SOURCE, TemporalAccessor> valueProvider, final DateTimeFormatter formatter, final String nullRepresentation) {
    super(valueProvider);

    Arguments.requireNotNull(formatter, "Must specify a formatter.");

    this.formatter = formatter;

    this.nullRepresentation = nullRepresentation;
  }

  /**
   * Creates a new instance with the default null representation {@link #DEFAULT_NULL_REPRESENTATION}.
   *
   * @param valueProvider The provider of a temporal value given the input model object.
   * @param formatter     The temporal value formatter.
   */
  public TemporalRenderer(final ValueProvider<SOURCE, TemporalAccessor> valueProvider, final DateTimeFormatter formatter) {
    this(valueProvider, formatter, DEFAULT_NULL_REPRESENTATION);
  }


  // Fields
  //--------------------------------------------------

  /**
   * The temporal value formatter.
   */
  private final DateTimeFormatter formatter;

  /**
   * The physical value to display if the value provider returns {@code null}.
   */
  private final String nullRepresentation;

  // Overrides
  //--------------------------------------------------

  // BasicRenderer
  //

  @Override
  protected String getFormattedValue(final TemporalAccessor object) {
    return (object != null ? formatter.format(object) : nullRepresentation);
  }

}
