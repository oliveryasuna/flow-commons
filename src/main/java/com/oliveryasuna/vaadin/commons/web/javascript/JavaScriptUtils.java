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

package com.oliveryasuna.vaadin.commons.web.javascript;

import com.oliveryasuna.commons.language.condition.Arguments;
import com.oliveryasuna.commons.language.exception.UnsupportedInstantiationException;
import com.oliveryasuna.commons.language.marker.Utility;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.page.PendingJavaScriptResult;

/**
 * Various JavaScript utilities.
 *
 * @author Oliver Yasuna
 * @since 2.0.0
 */
@Utility
public final class JavaScriptUtils {

  // Static utility methods
  //--------------------------------------------------

  /**
   * Defines a JavaScript function.
   *
   * @param ui                 The {@link UI} instance.
   * @param objectName         The name of the JavaScript object to which to define this function in.
   * @param functionName       The name of the function.
   * @param functionParameters The parameters of the function.
   * @param functionBody       The body of the function.
   *
   * @return A Vaadin {@link PendingJavaScriptResult}.
   */
  public static PendingJavaScriptResult defineFunction(final UI ui, final String objectName, final String functionName, final String[] functionParameters,
      final String functionBody) {
    Arguments.requireNotNull(ui);
    Arguments.requireNotNull(functionName);
    if(functionParameters != null) Arguments.requireNotContainsSame(functionParameters, null);

    return UI.getCurrent().getPage().executeJs(
        "$0$1=($2)=>{$3};",
        objectName != null ? objectName + "." : "",
        functionName,
        functionParameters != null ? String.join(",", functionParameters) : "",
        functionBody != null ? functionBody : "");
  }

  /**
   * Calls {@link #defineFunction(UI, String, String, String[], String)} with the specific first argument, {@code UI.getCurrent()}.
   *
   * @see #defineFunction(UI, String, String, String[], String)
   */
  public static PendingJavaScriptResult defineFunction(final String objectName, final String functionName, final String[] functionParameters,
      final String functionBody) {
    return defineFunction(UI.getCurrent(), objectName, functionName, functionParameters, functionBody);
  }

  // TODO: getBounds() using getBoundedClientRect().

  // TODO: getStyle() using getComputedStyle().

  // Constructors
  //--------------------------------------------------

  private JavaScriptUtils() {
    super();

    throw new UnsupportedInstantiationException();
  }

}
