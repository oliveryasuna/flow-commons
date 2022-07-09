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

import java.util.concurrent.CompletableFuture;

/**
 * Represents the {@code History} interface.
 *
 * @author Oliver Yasuna
 * @since 4.0.0
 */
public interface IHistory extends JavaScriptObject {

  // Methods
  //--------------------------------------------------

  // JavaScript properties
  //

  default CompletableFuture<Integer> getLength(final UI ui) {
    return getProperty(ui, Integer.class, "length");
  }

  default CompletableFuture<Integer> getLength() {
    return getLength(UI.getCurrent());
  }

  default CompletableFuture<String> getScrollRestoration(final UI ui) {
    return getProperty(ui, String.class, "scrollRestoration");
  }

  default CompletableFuture<String> getScrollRestoration() {
    return getScrollRestoration(UI.getCurrent());
  }

  default CompletableFuture<Void> setScrollRestoration(final UI ui, final String scrollRestoration) {
    return setProperty(ui, "scrollRestoration", scrollRestoration);
  }

  default CompletableFuture<Void> setScrollRestoration(final String scrollRestoration) {
    return setScrollRestoration(UI.getCurrent(), scrollRestoration);
  }

  // TODO: state?

  // JavaScript methods
  //

  default CompletableFuture<Void> back(final UI ui) {
    return callMethod(ui, Void.class, "back");
  }

  default CompletableFuture<Void> back() {
    return back(UI.getCurrent());
  }

  default CompletableFuture<Void> forward(final UI ui) {
    return callMethod(ui, Void.class, "forward");
  }

  default CompletableFuture<Void> forward() {
    return forward(UI.getCurrent());
  }

  default CompletableFuture<Void> go(final UI ui) {
    return callMethod(ui, Void.class, "go");
  }

  default CompletableFuture<Void> go() {
    return go(UI.getCurrent());
  }

  default CompletableFuture<Void> go(final UI ui, final int delta) {
    return callMethod(ui, Void.class, "go", delta);
  }

  default CompletableFuture<Void> go(final int delta) {
    return go(UI.getCurrent(), delta);
  }

  // TODO: pushState()?

  // TODO: replaceState()?

}
