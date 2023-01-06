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

package com.oliveryasuna.vaadin.commons.web.dom;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

/**
 * A JavaScript object.
 *
 * @author Oliver Yasuna
 */
public interface DomObject {

  // Methods
  //--------------------------------------------------

  /**
   * Gets a property value.
   *
   * @param <T>        The type to interpret the property value as.
   * @param name       The name of the property.
   * @param returnType The type to interpret the property value as.
   *
   * @return A {@link CompletableFuture} containing the value of the property.
   */
  <T> CompletableFuture<T> getProperty(String name, final Class<T> returnType);

  /**
   * Sets a property value.
   *
   * @param name  The name of the property.
   * @param value The value to set.
   *
   * @return A {@link CompletableFuture} containing the value of the property.
   */
  CompletableFuture<Void> setProperty(String name, Serializable value);

  /**
   * Calls a function.
   *
   * @param <T>        The type of return value of the function.
   * @param name       The name of the function.
   * @param returnType The type of return value of the function.
   * @param arguments  The arguments to pass to the function.
   *
   * @return A {@link CompletableFuture} that contains the return value of the function.
   */
  <T> CompletableFuture<T> callFunction(String name, Class<T> returnType, Serializable... arguments);

}
