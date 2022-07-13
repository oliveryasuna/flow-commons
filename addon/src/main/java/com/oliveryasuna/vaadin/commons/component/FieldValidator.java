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

package com.oliveryasuna.vaadin.commons.component;

import com.oliveryasuna.commons.language.condition.Arguments;
import com.oliveryasuna.commons.language.marker.Immutable;
import com.oliveryasuna.commons.language.pattern.Registration;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValidation;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.binder.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Wraps a component and uses {@link Validator}s to determine validity.
 *
 * @param <C> The type of component.
 * @param <E> The type of event.
 * @param <V> The type of value.
 *
 * @author Oliver Yasuna
 * @since 4.0.0-beta
 */
@Immutable
public class FieldValidator<C extends Component & HasValue<E, V> & HasValidation, E extends HasValue.ValueChangeEvent<V>, V>
    implements HasValue.ValueChangeListener<E> {

  // Constructors
  //--------------------------------------------------

  public FieldValidator(final C component) {
    super();

    Arguments.requireNotNull(component, "Must specify a component.");

    this.component = component;
  }

  // Fields
  //--------------------------------------------------

  private final C component;

  private final List<Validator<V>> validators = new ArrayList<>();

  // Methods
  //--------------------------------------------------

  public Registration addValidation(final Validator<V> validator) {
    Arguments.requireNotNull(validator, "Must specify a validator.");

    validators.add(validator);

    return (() -> validators.remove(validator));
  }

  // Overrides
  //--------------------------------------------------

  // ValueChangeListener
  //

  @Override
  public void valueChanged(final E event) {
    final V value = event.getValue();

    for(final Validator<V> validator : validators) {
      final ValidationResult result = validator.apply(value, null);

      if(result.isError()) {
        final C component = getComponent();

        component.setErrorMessage(result.getErrorMessage());
        component.setInvalid(true);

        return;
      }
    }

    component.setInvalid(false);
  }

  // Getters
  //--------------------------------------------------

  public C getComponent() {
    return component;
  }

  public List<Validator<V>> getValidators() {
    return validators;
  }

}
