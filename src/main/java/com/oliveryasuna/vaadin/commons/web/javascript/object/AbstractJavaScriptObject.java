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

import com.oliveryasuna.commons.language.condition.Arguments;
import com.oliveryasuna.commons.language.marker.Immutable;
import com.vaadin.flow.component.UI;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Base implementation of {@link JavaScriptObject}.
 *
 * @author Oliver Yasuna
 * @since 4.0.0
 */
@Immutable
public abstract class AbstractJavaScriptObject implements JavaScriptObject {

  // Constructors
  //--------------------------------------------------

  public AbstractJavaScriptObject() {
    super();
  }

  // Methods
  //--------------------------------------------------

  protected String buildPropertyReturnStatement(final String propertyName) {
    return ("return " + buildPath(propertyName) + ";");
  }

  protected String buildPropertyAssignStatement(final String propertyName) {
    return (buildPath(propertyName) + " = $0;");
  }

  protected String buildMethodCallStatement(final Class<?> returnType, final String methodName, final Serializable... arguments) {
    return ((Void.class.equals(returnType) ? "" : "return ") + buildPath(methodName) + "(" + buildMethodArguments(arguments) + ");");
  }

  protected String buildMethodArguments(final Serializable... arguments) {
    if(arguments == null) return "";

    return IntStream.range(0, arguments.length)
        .mapToObj(i -> "$" + i)
        .collect(Collectors.joining(", "));
  }

  protected abstract String buildPath(final String name);

  // Overrides
  //--------------------------------------------------

  // JavaScriptObject
  //

  @Override
  public <T> CompletableFuture<T> getProperty(final UI ui, final Class<T> returnType, final String propertyName) {
    Arguments.requireNotNull(ui, "Must specify a UI.");
    Arguments.requireNotNull(returnType, "Must specify a return type.");
    Arguments.requireNotNull(propertyName, "Must specify a property name.");

    return ui.getPage().executeJs(buildPropertyReturnStatement(propertyName))
        .toCompletableFuture(returnType);
  }

  @Override
  public CompletableFuture<Void> setProperty(final UI ui, final String propertyName, final Serializable propertyValue) {
    Arguments.requireNotNull(ui, "Must specify a UI.");
    Arguments.requireNotNull(propertyName, "Must specify a property name.");

    return ui.getPage().executeJs(buildPropertyAssignStatement(propertyName), propertyValue)
        .toCompletableFuture(Void.class);
  }

  @Override
  public <T> CompletableFuture<T> callMethod(final UI ui, final Class<T> returnType, final String methodName, final Serializable... arguments) {
    Arguments.requireNotNull(ui, "Must specify a UI.");
    Arguments.requireNotNull(returnType, "Must specify a return type.");
    Arguments.requireNotNull(methodName, "Must specify a method name.");

    if(arguments != null) {
      return ui.getPage().executeJs(buildMethodCallStatement(returnType, methodName, arguments), arguments)
          .toCompletableFuture(returnType);
    } else {
      return ui.getPage().executeJs(buildMethodCallStatement(returnType, methodName, (Serializable[])null))
          .toCompletableFuture(returnType);
    }
  }

}
