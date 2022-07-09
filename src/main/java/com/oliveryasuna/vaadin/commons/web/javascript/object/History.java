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

import com.oliveryasuna.commons.language.marker.Immutable;
import com.oliveryasuna.commons.language.marker.Singleton;
import com.vaadin.flow.component.UI;

import java.util.concurrent.CompletableFuture;

/**
 * Represents a {@code History} object.
 *
 * @author Oliver Yasuna
 * @since 4.0.0
 */
@Singleton
public class History extends NamedJavaScriptObject {

  // Static fields
  //--------------------------------------------------

  private static final String NAME = "history";

  // Singleton
  //--------------------------------------------------

  private static final History INSTANCE = new History();

  public static History getInstance() {
    return INSTANCE;
  }

  // Constructors
  //--------------------------------------------------

  protected History() {
    super(NAME);
  }

  History(final NamedJavaScriptObject parent) {
    super(parent.getName() + "." + NAME);
  }

  // Methods
  //--------------------------------------------------

  // JavaScript properties

  public CompletableFuture<Integer> getLength(final UI ui) {
    return getProperty(ui, Integer.class, "length");
  }

  public CompletableFuture<Integer> getLength() {
    return getLength(UI.getCurrent());
  }

  public CompletableFuture<String> getScrollRestoration(final UI ui) {
    return getProperty(ui, String.class, "scrollRestoration");
  }

  public CompletableFuture<String> getScrollRestoration() {
    return getScrollRestoration(UI.getCurrent());
  }

  public CompletableFuture<Void> setScrollRestoration(final UI ui, final String scrollRestoration) {
    return setProperty(ui, "scrollRestoration", scrollRestoration);
  }

  public CompletableFuture<Void> setScrollRestoration(final String scrollRestoration) {
    return setScrollRestoration(UI.getCurrent(), scrollRestoration);
  }

  // TODO: state?

  // JavaScript methods
  //

  public CompletableFuture<Void> back(final UI ui) {
    return callMethod(ui, Void.class, "back");
  }

  public CompletableFuture<Void> back() {
    return back(UI.getCurrent());
  }

  public CompletableFuture<Void> forward(final UI ui) {
    return callMethod(ui, Void.class, "forward");
  }

  public CompletableFuture<Void> forward() {
    return forward(UI.getCurrent());
  }

  protected CompletableFuture<Void> go(final UI ui, final Integer delta) {
    if(delta != null) {
      return callMethod(ui, Void.class, "go", delta);
    } else {
      return callMethod(ui, Void.class, "go");
    }
  }

  public CompletableFuture<Void> go(final UI ui) {
    return go(ui, null);
  }

  public CompletableFuture<Void> go() {
    return go(UI.getCurrent());
  }

  public CompletableFuture<Void> go(final UI ui, final int delta) {
    return go(ui, (Integer)delta);
  }

  public CompletableFuture<Void> go(final int delta) {
    return go(UI.getCurrent(), delta);
  }

  // TODO: pushState()?

  // TODO: replaceState()?

  // Nested
  //--------------------------------------------------

  /**
   * The options for the {@code scrollRestoration} property.
   *
   * @author Oliver Yasuna
   * @since 4.0.0
   */
  @Immutable
  public enum ScrollRestoration implements JavaScriptPart {

    // Values
    //--------------------------------------------------

    AUTO("auto"),

    MANUAL("manual");

    // Constructors
    //--------------------------------------------------

    ScrollRestoration(final String javaScriptName) {
      this.javaScriptName = javaScriptName;
    }

    // Fields
    //--------------------------------------------------

    private final String javaScriptName;

    // Getters
    //--------------------------------------------------

    @Override
    public final String getJavaScriptName() {
      return javaScriptName;
    }

  }

}
