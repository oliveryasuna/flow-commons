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

package com.oliveryasuna.vaadin.commons.component.clipboard;

import com.oliveryasuna.commons.language.function.Action;
import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.html.Span;

import java.util.function.Consumer;

/**
 * A component for working with the clipboard.
 *
 * @author Oliver Yasuna
 * @since 4.0.0
 */
public class Clipboard extends Span {

  // Constructors
  //--------------------------------------------------

  /**
   * Creates an instance.
   *
   * @param getCallback Called when the clipboard is read.
   * @param setCallback Called when the clipboard is set.
   */
  public Clipboard(final Consumer<String> getCallback, final Action setCallback) {
    super();

    getStyle().set("display", "none");

    this.getCallback = getCallback;
    this.setCallback = setCallback;
  }

  // Fields
  //--------------------------------------------------

  /**
   * The callback for when the clipboard is read.
   */
  protected final Consumer<String> getCallback;

  /**
   * The callback for when the clipboard is set.
   */
  protected final Action setCallback;

  // Methods
  //--------------------------------------------------

  /**
   * Gets the text value of the clipboard.
   * <p>
   * Executes JavaScript which will call {@link #getCallback(String)}.
   */
  public void get() {
    getUI().ifPresent(ui -> ui.getPage().executeJs("navigator.clipboard.readText().then(text => $0.$server.getCallback(text));", getElement()));
  }

  /**
   * Called by the client when the clipboard is read.
   * Then calls {@link #getCallback}.
   *
   * @param text The clipboard text.
   */
  @ClientCallable
  public void getCallback(final String text) {
    if(getCallback != null) getCallback.accept(text);
  }

  /**
   * Sets the text value of the clipboard.
   * <p>
   * Executes JavaScript which will call {@link #setCallback()}.
   *
   * @param text The clipboard text.
   */
  public void set(final String text) {
    getUI().ifPresent(ui -> ui.getPage().executeJs("navigator.clipboard.writeText($0).then(() => $0.$server.setCallback());", getElement()));
  }

  /**
   * Called by the client when the clipboard is set.
   * Then calls {@link #setCallback}.
   */
  @ClientCallable
  public void setCallback() {
    if(setCallback != null) setCallback.perform();
  }

}
