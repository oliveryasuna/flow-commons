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
 * Represents the {@code WindowOrWorkerGlobalScope} interface.
 *
 * @author Oliver Yasuna
 * @since 4.0.0
 */
public interface WindowOrWorkerGlobalScope extends JavaScriptObject {

  // Methods
  //--------------------------------------------------

  // JavaScript properties
  //

  // TODO: caches?

  default CompletableFuture<Boolean> isCrossOriginIsolated(final UI ui) {
    return getProperty(ui, Boolean.class, "crossOriginIsolated");
  }

  default CompletableFuture<Boolean> isCrossOriginIsolated() {
    return isCrossOriginIsolated(UI.getCurrent());
  }

  // TODO: crypto?

  // TODO: indexedDB?

  default CompletableFuture<Boolean> isIsSecureContext(final UI ui) {
    return getProperty(ui, Boolean.class, "isSecureContext");
  }

  default CompletableFuture<Boolean> isIsSecureContext() {
    return isIsSecureContext(UI.getCurrent());
  }

  default CompletableFuture<String> getOrigin(final UI ui) {
    return getProperty(ui, String.class, "origin");
  }

  default CompletableFuture<String> getOrigin() {
    return getOrigin(UI.getCurrent());
  }

  // TODO: performance?

  // JavaScript methods
  //

  default CompletableFuture<String> atob(final UI ui, final String data) {
    return callMethod(ui, String.class, "atob", data);
  }

  default CompletableFuture<String> atob(final String data) {
    return atob(UI.getCurrent(), data);
  }

  default CompletableFuture<String> btoa(final UI ui, final String data) {
    return callMethod(ui, String.class, "btoa", data);
  }

  default CompletableFuture<String> btoa(final String data) {
    return btoa(UI.getCurrent(), data);
  }

  default CompletableFuture<Void> clearInterval(final UI ui) {
    return callMethod(ui, Void.class, "clearInterval");
  }

  default CompletableFuture<Void> clearInterval() {
    return clearInterval(UI.getCurrent());
  }

  default CompletableFuture<Void> clearInterval(final UI ui, final int handle) {
    return callMethod(ui, Void.class, "clearInterval", handle);
  }

  default CompletableFuture<Void> clearInterval(final int handle) {
    return clearInterval(UI.getCurrent(), handle);
  }

  default CompletableFuture<Void> clearTimeout(final UI ui) {
    return callMethod(ui, Void.class, "clearTimeout");
  }

  default CompletableFuture<Void> clearTimeout() {
    return clearTimeout(UI.getCurrent());
  }

  default CompletableFuture<Void> clearTimeout(final UI ui, final int handle) {
    return callMethod(ui, Void.class, "clearTimeout", handle);
  }

  default CompletableFuture<Void> clearTimeout(final int handle) {
    return clearTimeout(UI.getCurrent(), handle);
  }

  // TODO: createImageBitmap()?

  // TODO: fetch()?

  // TODO: queueMicrotask()?

  // TODO: setInterval()?

  // TODO: setTimeout()?

}
