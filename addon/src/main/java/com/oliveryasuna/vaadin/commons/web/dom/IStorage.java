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

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

/**
 * Represents {@code Storage}.
 *
 * @author Oliver Yasuna
 */
public interface IStorage extends DomObject {

  // Methods
  //--------------------------------------------------

  // JavaScript properties
  //

  default <T> CompletableFuture<T> getIndexed(final String key, final Class<T> type) {
    return getProperty(key, type);
  }

  default <T extends Serializable> CompletableFuture<Void> setIndexed(final String key, final T value) {
    return setProperty(key, value);
  }

  default CompletableFuture<Integer> getLength() {
    return getProperty("length", Integer.class);
  }

  // JavaScript functions
  //

  default CompletableFuture<Void> clear() {
    return callFunction("clear", Void.class);
  }

  default CompletableFuture<String> getItem(final String key) {
    return callFunction("getItem", String.class, key);
  }

  default CompletableFuture<String> key(final int index) {
    return callFunction("key", String.class, index);
  }

  default CompletableFuture<Void> removeItem(final String key) {
    return callFunction("removeItem", Void.class, key);
  }

  default CompletableFuture<Void> setItem(final String key, final String value) {
    return callFunction("setItem", Void.class, value);
  }

}
