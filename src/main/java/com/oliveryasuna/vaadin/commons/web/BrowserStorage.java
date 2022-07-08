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

import com.oliveryasuna.commons.language.condition.Arguments;
import com.oliveryasuna.commons.language.exception.UnsupportedInstantiationException;
import com.oliveryasuna.commons.language.marker.Utility;
import com.vaadin.flow.component.UI;

import java.util.concurrent.CompletableFuture;

/**
 * For manipulating browser <a href="https://developer.mozilla.org/en-US/docs/Web/API/Storage">{@code Storage}</a> objects, particularly {@code localStorage}
 * and {@code sessionStorage}.
 * <p>
 * Inspired by code from <a href="https://github.com/viritin/flow-viritin">flow-viritin</a>.
 *
 * @author Oliver Yasuna
 * @since 2.0.0
 */
@Utility
public final class BrowserStorage {

  // Static utility methods
  //--------------------------------------------------

  /**
   * Gets an item in a storage.
   * <p>
   * Comparable to <a href="https://developer.mozilla.org/en-US/docs/Web/API/Storage/getItem">{@code Storage.getItem()}</a>.
   *
   * @param ui     The {@link UI} instance.
   * @param object The type of web storage.
   * @param key    The key of the item.
   *
   * @return A {@link CompletableFuture} containing the value of the item.
   */
  public static CompletableFuture<String> getItem(final UI ui, final WebStorageObject object, final String key) {
    Arguments.requireNotNull(ui);
    Arguments.requireNotNull(object);
    Arguments.requireNotNull(key);

    return ui.getPage().executeJs("return window[$0].getItem($1);", object.getJavaScriptName(), key)
        .toCompletableFuture(String.class);
  }

  /**
   * Calls {@link #getItem(UI, WebStorageObject, String)} with the specific first argument, {@code UI.getCurrent()}.
   */
  public static CompletableFuture<String> getItem(final WebStorageObject object, final String key) {
    return getItem(UI.getCurrent(), object, key);
  }

  /**
   * Sets an item in a storage.
   * <p>
   * Comparable to <a href="https://developer.mozilla.org/en-US/docs/Web/API/Storage/setItem">{@code Storage.setItem()}</a>.
   *
   * @param ui     The {@link UI} instance.
   * @param object The type of web storage.
   * @param key    The key of the item.
   * @param value  The value of the item.
   *
   * @return A {@link CompletableFuture} which can be used to determine completeness.
   */
  public static CompletableFuture<Void> setItem(final UI ui, final WebStorageObject object, final String key, final String value) {
    Arguments.requireNotNull(ui);
    Arguments.requireNotNull(object);
    Arguments.requireNotNull(key);

    return ui.getPage().executeJs("window[$0].setItem($1, $2);", object.getJavaScriptName(), key, value)
        .toCompletableFuture(Void.class);
  }

  /**
   * Calls {@link #setItem(UI, WebStorageObject, String, String)} with the specific first argument, {@code UI.getCurrent()}.
   */
  public static CompletableFuture<Void> setItem(final WebStorageObject object, final String key, final String value) {
    return setItem(UI.getCurrent(), object, key, value);
  }

  /**
   * Removes an item from a storage.
   * <p>
   * Comparable to <a href="https://developer.mozilla.org/en-US/docs/Web/API/Storage/removeItem">{@code Storage.removeItem()}</a>.
   *
   * @param ui     The {@link UI} instance.
   * @param object The type of web storage.
   * @param key    The key of the item.
   *
   * @return A {@link CompletableFuture} which can be used to determine completeness.
   */
  public static CompletableFuture<Void> removeItem(final UI ui, final WebStorageObject object, final String key) {
    Arguments.requireNotNull(ui);
    Arguments.requireNotNull(object);
    Arguments.requireNotNull(key);

    return ui.getPage().executeJs("return window[$0].removeItem($1);", object.getJavaScriptName(), key)
        .toCompletableFuture(Void.class);
  }

  /**
   * Calls {@link #removeItem(UI, WebStorageObject, String)} with the specific first argument, {@code UI.getCurrent()}.
   */
  public static CompletableFuture<Void> removeItem(final WebStorageObject object, final String key) {
    return removeItem(UI.getCurrent(), object, key);
  }

  /**
   * Clears all items from a storage.
   * <p>
   * Comparable to <a href="https://developer.mozilla.org/en-US/docs/Web/API/Storage/clear">{@code Storage.clear()}</a>.
   *
   * @param ui     The {@link UI} instance.
   * @param object The type of web storage.
   *
   * @return A {@link CompletableFuture} which can be used to determine completeness.
   */
  public static CompletableFuture<Void> clear(final UI ui, final WebStorageObject object) {
    Arguments.requireNotNull(ui);
    Arguments.requireNotNull(object);

    return ui.getPage().executeJs("window[$0].clear();", object.getJavaScriptName())
        .toCompletableFuture(Void.class);
  }

  /**
   * Calls {@link #clear(UI, WebStorageObject)} with the specific first argument, {@code UI.getCurrent()}.
   */
  public static CompletableFuture<Void> clear(final WebStorageObject object) {
    return clear(UI.getCurrent(), object);
  }

  /**
   * Gets the name of a key by index.
   * <p>
   * Comparable to <a href="https://developer.mozilla.org/en-US/docs/Web/API/Storage/key">{@code Storage.key()}</a>.
   *
   * @param ui     The {@link UI} instance.
   * @param object The type of web storage.
   * @param index  The index of the item.
   *
   * @return A {@link CompletableFuture} containing the name of the item.
   */
  public static CompletableFuture<String> key(final UI ui, final WebStorageObject object, final int index) {
    Arguments.requireNotNull(ui);
    Arguments.requireNotNull(object);
    Arguments.requireGreaterOrSame(index, 0);

    return ui.getPage().executeJs("return window[$0].key($1);", object.getJavaScriptName(), index)
        .toCompletableFuture(String.class);
  }

  /**
   * Calls {@link #key(UI, WebStorageObject, int)} with the specific first argument, {@code UI.getCurrent()}.
   */
  public static CompletableFuture<String> key(final WebStorageObject object, final int index) {
    return key(UI.getCurrent(), object, index);
  }

  /**
   * Gets the length of a storage.
   * <p>
   * Comparable to <a href="https://developer.mozilla.org/en-US/docs/Web/API/Storage/length">{@code Storage.length}</a>.
   *
   * @param ui     The {@link UI} instance.
   * @param object The type of web storage.
   *
   * @return A {@link CompletableFuture} containing the length of the storage.
   */
  public static CompletableFuture<Integer> length(final UI ui, final WebStorageObject object) {
    Arguments.requireNotNull(ui);
    Arguments.requireNotNull(object);

    return ui.getPage().executeJs("return window[$0].length;", object.getJavaScriptName())
        .toCompletableFuture(Integer.class);
  }

  /**
   * Calls {@link #length(UI, WebStorageObject)} with the specific first argument, {@code UI.getCurrent()}.
   */
  public static CompletableFuture<Integer> length(final WebStorageObject object) {
    return length(UI.getCurrent(), object);
  }

  // Constructors
  //--------------------------------------------------

  private BrowserStorage() {
    super();

    throw new UnsupportedInstantiationException();
  }

  // Nested
  //--------------------------------------------------

  /**
   * The web storage objects.
   *
   * @author Oliver Yasuna
   */
  public enum WebStorageObject {

    // Values
    //--------------------------------------------------

    LOCAL_STORAGE("localStorage"),

    SESSION_STORAGE("sessionStorage");

    // Constructors
    //--------------------------------------------------

    WebStorageObject(final String javaScriptName) {
      this.javaScriptName = javaScriptName;
    }

    // Fields
    //--------------------------------------------------

    private final String javaScriptName;

    // Getters
    //--------------------------------------------------

    public final String getJavaScriptName() {
      return javaScriptName;
    }
  }

}
