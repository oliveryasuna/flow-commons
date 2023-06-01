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

package com.oliveryasuna.vaadin.commons.data.binder;

import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.data.binder.*;
import com.vaadin.flow.function.ValueProvider;
import com.vaadin.flow.shared.Registration;

import java.io.Serializable;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * A view of a {@link Binder}, wherein most is unmodifiable.
 *
 * @param <BEAN> The bean type.
 *
 * @author Oliver Yasuna
 * @since 5.5.0
 */
// TODO: Move to `flow-commons`.
public class BinderView<BEAN> implements Serializable {

  // Constructors
  //--------------------------------------------------

  public BinderView(final Binder<BEAN> binder) {
    super();

    this.binder = binder;
  }

  // Fields
  //--------------------------------------------------

  private final Binder<BEAN> binder;

  // Methods
  //--------------------------------------------------

  public BEAN getBean() {
    return getBinder().getBean();
  }

  public BinderValidationStatus<BEAN> validate() {
    return getBinder().validate();
  }

  public boolean isValid() {
    return getBinder().isValid();
  }

  public Optional<HasText> getStatusLabel() {
    return getBinder().getStatusLabel();
  }

  public BinderValidationStatusHandler<BEAN> getValidationStatusHandler() {
    return getBinder().getValidationStatusHandler();
  }

  public BinderValidationErrorHandler getValidationErrorHandler() {
    return getBinder().getValidationErrorHandler();
  }

  public Registration addStatusChangeListener(final StatusChangeListenerView listener) {
    return getBinder().addStatusChangeListener(event -> listener.statusChange(new StatusChangeEventView(event)));
  }

  public Registration addValueChangeListener(final HasValue.ValueChangeListener<? super HasValue.ValueChangeEvent<?>> listener) {
    return getBinder().addValueChangeListener(listener);
  }

  public boolean hasChanges() {
    return getBinder().hasChanges();
  }

  public Optional<BindingView<BEAN, ?>> getBinding(final String propertyName) {
    return getBinder().getBinding(propertyName)
        .map(BindingView::new);
  }

  public Stream<HasValue<?, ?>> getFields() {
    return getBinder().getFields();
  }

  public boolean isValidatorsDisabled() {
    return getBinder().isValidatorsDisabled();
  }

  public boolean isFieldsValidationStatusChangeListenerEnabled() {
    return getBinder().isFieldsValidationStatusChangeListenerEnabled();
  }

  public BindingExceptionHandler getBindingExceptionHandler() {
    return getBinder().getBindingExceptionHandler();
  }

  // Getters/setters
  //--------------------------------------------------

  protected Binder<BEAN> getBinder() {
    return binder;
  }

  // Nested
  //--------------------------------------------------

  public static class BindingView<BEAN, TARGET> implements Serializable {

    // Constructors
    //--------------------------------------------------

    public BindingView(final Binder.Binding<BEAN, TARGET> binding) {
      super();

      this.binding = binding;
    }

    // Fields
    //--------------------------------------------------

    private final Binder.Binding<BEAN, TARGET> binding;

    // Methods
    //--------------------------------------------------

    public HasValue<?, ?> getField() {
      return getBinding().getField();
    }

    public BindingValidationStatus<TARGET> validate() {
      return getBinding().validate();
    }

    public BindingValidationStatus<TARGET> validate(final boolean fireEvent) {
      return getBinding().validate(fireEvent);
    }

    public BindingValidationStatusHandler getValidationStatusHandler() {
      return getBinding().getValidationStatusHandler();
    }

    public boolean isReadOnly() {
      return getBinding().isReadOnly();
    }

    public ValueProvider<BEAN, TARGET> getGetter() {
      return getBinding().getGetter();
    }

    public Setter<BEAN, TARGET> getSetter() {
      return getBinding().getSetter();
    }

    public boolean isAsRequiredEnabled() {
      return getBinding().isAsRequiredEnabled();
    }

    public boolean isValidatorsDisabled() {
      return getBinding().isValidatorsDisabled();
    }

    // Getters/setters
    //--------------------------------------------------

    protected Binder.Binding<BEAN, TARGET> getBinding() {
      return binding;
    }

  }

}
