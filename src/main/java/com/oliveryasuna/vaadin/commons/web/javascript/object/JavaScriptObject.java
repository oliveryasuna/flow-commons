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

package com.oliveryasuna.vaadin.commons.web.javascript.object;

import com.vaadin.flow.component.UI;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

/**
 * Base for classes that represent JavaScript objects.
 * <p>
 * Provides methods to get and set properties, and call functions.
 *
 * @author Oliver Yasuna
 * @since 4.0.0
 */
public interface JavaScriptObject {

  // Methods
  //--------------------------------------------------

  // JavaScript properties
  //

  /**
   * Gets a property value.
   *
   * @param ui           The {@link UI} instance.
   * @param returnType   The type to interpret the property value as.
   * @param propertyName The name of the property.
   * @param <T>          The type to interpret the property value as.
   *
   * @return A {@link CompletableFuture} containing the value of the property.
   */
  <T> CompletableFuture<T> getProperty(final UI ui, final Class<T> returnType, final String propertyName);

  /**
   * Calls {@link #getProperty(UI, Class, String)} with {@code UI.getCurrent()}.
   */
  default <T> CompletableFuture<T> getProperty(final Class<T> returnType, final String propertyName) {
    return getProperty(UI.getCurrent(), returnType, propertyName);
  }

  /**
   * Sets a property value.
   *
   * @param ui            The {@link UI} instance.
   * @param propertyName  The name of the property.
   * @param propertyValue The value of the property.
   *
   * @return A {@link CompletableFuture} that completes once the UIDL is confirmed.
   */
  CompletableFuture<Void> setProperty(final UI ui, final String propertyName, final Serializable propertyValue);

  /**
   * Calls {@link #setProperty(UI, String, Serializable)} with {@code UI.getCurrent()}.
   */
  default CompletableFuture<Void> setProperty(final String propertyName, final Serializable propertyValue) {
    return setProperty(UI.getCurrent(), propertyName, propertyValue);
  }

  // JavaScript functions
  //

  /**
   * Calls a method.
   *
   * @param ui         The {@link UI} instance.
   * @param methodName The name of the method.
   * @param returnType The type of return value of the method.
   * @param arguments  The arguments to pass to the method.
   * @param <T>        The type of return value of the method.
   *
   * @return A {@link CompletableFuture} that contains the return value of the method.
   */
  <T> CompletableFuture<T> callMethod(final UI ui, final Class<T> returnType, final String methodName, final Serializable... arguments);

  /**
   * Calls {@link #callMethod(UI, Class, String, Serializable...)} with {@code UI.getCurrent()}.
   */
  default <T> CompletableFuture<T> callMethod(final String methodName, final Class<T> returnType, final Serializable... arguments) {
    return callMethod(UI.getCurrent(), returnType, methodName, arguments);
  }

}
