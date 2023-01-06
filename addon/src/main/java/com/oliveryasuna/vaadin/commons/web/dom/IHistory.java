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

import java.util.concurrent.CompletableFuture;

/**
 * Represents {@code History}.
 *
 * @author Oliver Yasuna
 */
public interface IHistory extends DomObject {

  // Methods
  //--------------------------------------------------

  // JavaScript properties
  //

  default CompletableFuture<Integer> getLength() {
    return getProperty("length", Integer.class);
  }

  default CompletableFuture<String> getScrollRestoration() {
    return getProperty("scrollRestoration", String.class);
  }

  default CompletableFuture<Void> setScrollRestoration(final String scrollRestoration) {
    return setProperty("scrollRestoration", scrollRestoration);
  }

  // JavaScript functions
  //

  default CompletableFuture<Void> back() {
    return callFunction("back", Void.class);
  }

  default CompletableFuture<Void> forward() {
    return callFunction("forward", Void.class);
  }

  default CompletableFuture<Void> go(final Integer delta) {
    return callFunction("go", Void.class, delta);
  }

  default CompletableFuture<Void> go() {
    return callFunction("go", Void.class);
  }

}
