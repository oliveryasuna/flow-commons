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
import com.vaadin.flow.component.UI;

import java.util.concurrent.CompletableFuture;

/**
 * Represents the {@code Storage} interface.
 *
 * @author Oliver Yasuna
 * @since 4.0.0
 */
public interface IStorage extends JavaScriptObject {

  // Methods
  //--------------------------------------------------

  // JavaScript properties

  default CompletableFuture<Integer> getLength(final UI ui) {
    return getProperty(ui, Integer.class, "length");
  }

  default CompletableFuture<Integer> getLength() {
    return getLength(UI.getCurrent());
  }

  // JavaScript methods
  //

  default CompletableFuture<String> key(final UI ui, final int index) {
    return callMethod(ui, String.class, "key", index);
  }

  default CompletableFuture<String> key(final int index) {
    return key(UI.getCurrent(), index);
  }

  default CompletableFuture<String> getItem(final UI ui, final String key) {
    Arguments.requireNotNull(key, "Must specify a key.");

    return callMethod(ui, String.class, "getItem", key);
  }

  default CompletableFuture<String> getItem(final String key) {
    return getItem(UI.getCurrent(), key);
  }

  default CompletableFuture<Void> setItem(final UI ui, final String key, final String value) {
    Arguments.requireNotNull(key, "Must specify a key.");

    return callMethod(ui, Void.class, "setItem", key, value);
  }

  default CompletableFuture<Void> setItem(final String key, final String value) {
    return setItem(UI.getCurrent(), key, value);
  }

  default CompletableFuture<Void> removeItem(final UI ui, final String key) {
    Arguments.requireNotNull(key, "Must specify a key.");

    return callMethod(ui, Void.class, "removeItem", key);
  }

  default CompletableFuture<Void> removeItem(final String key) {
    return removeItem(UI.getCurrent(), key);
  }

  default CompletableFuture<Void> clear(final UI ui) {
    return callMethod(ui, Void.class, "clear");
  }

  default CompletableFuture<Void> clear() {
    return clear(UI.getCurrent());
  }

}