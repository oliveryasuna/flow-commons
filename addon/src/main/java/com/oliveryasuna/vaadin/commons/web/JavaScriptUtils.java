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

package com.oliveryasuna.vaadin.commons.web;

import com.oliveryasuna.commons.language.exception.UnsupportedInstantiationException;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.component.page.PendingJavaScriptResult;
import com.vaadin.flow.dom.Element;

import java.io.Serializable;

/**
 * JavaScript utilities.
 *
 * @author Oliver Yasuna
 */
public final class JavaScriptUtils {

  // Static methods
  //--------------------------------------------------

  public static PendingJavaScriptResult executeJs(final Element element, final String expression, final Serializable... parameters) {
    return element.executeJs(expression, parameters);
  }

  public static PendingJavaScriptResult executeJs(final HasElement hasElement, final String expression, final Serializable... parameters) {
    return executeJs(hasElement.getElement(), expression, parameters);
  }

  public static PendingJavaScriptResult executeJs(final Page page, final String expression, final Serializable... parameters) {
    return page.executeJs(expression, parameters);
  }

  // Constructors
  //--------------------------------------------------

  private JavaScriptUtils() {
    super();

    throw new UnsupportedInstantiationException();
  }

}
