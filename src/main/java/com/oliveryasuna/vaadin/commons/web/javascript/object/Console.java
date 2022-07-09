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

import com.oliveryasuna.commons.language.marker.Singleton;
import com.vaadin.flow.component.UI;

import java.util.concurrent.CompletableFuture;

/**
 * Represents a {@code console} object.
 *
 * @author Oliver Yasuna
 * @since 4.0.0
 */
@Singleton
public class Console extends NamedJavaScriptObject {

  // Static fields
  //--------------------------------------------------

  static final String NAME = "console";

  // Singleton
  //--------------------------------------------------

  private static final Console INSTANCE = new Console();

  public static Console getInstance() {
    return INSTANCE;
  }

  // Constructors
  //--------------------------------------------------

  protected Console() {
    super(NAME);
  }

  Console(final NamedJavaScriptObject parent) {
    super(parent.getName() + "." + NAME);
  }

  // Methods
  //--------------------------------------------------

  // JavaScript methods
  //

  // TODO: assert()?

  public CompletableFuture<Void> clear(final UI ui) {
    return callMethod(ui, Void.class, "clear");
  }

  public CompletableFuture<Void> clear() {
    return clear(UI.getCurrent());
  }

  // TODO: count()?

  // TODO: countReset()?

  // TODO: debug()?

  // TODO: dir()?

  // TODO: dirxml().

  // TODO: error().

  // TODO: group().

  // TODO: groupCollapsed().

  // TODO: groupEnd()?

  // TODO: info()?

  // TODO: log()?

  // TODO: table()?

  // TODO: time()?

  // TODO: timeEnd()?

  // TODO: timeLog()?

  // TODO: trace()?

  // TODO: warn()?

}
