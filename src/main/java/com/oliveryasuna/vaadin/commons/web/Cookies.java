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

import com.oliveryasuna.commons.language.StreamUtils;
import com.oliveryasuna.commons.language.condition.Arguments;
import com.oliveryasuna.commons.language.exception.UnsupportedInstantiationException;
import com.oliveryasuna.commons.language.marker.Utility;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinResponse;
import com.vaadin.flow.server.VaadinService;

import javax.servlet.http.Cookie;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * For manipulating browser cookies.
 *
 * @author Oliver Yasuna
 */
@Utility
public final class Cookies {

  // Static utility methods
  //--------------------------------------------------

  /**
   * Gets all cookie key/value pairs.
   *
   * @param ui The UI.
   *
   * @return A {@link CompletableFuture} containing key/value pairs.
   */
  public static CompletableFuture<Map<String, String>> getAll(final UI ui) {
    Arguments.requireNotNull(ui);

    return ui.getPage().executeJs("return document.cookie;")
        .toCompletableFuture(String.class)
        .thenApply(result -> Arrays.stream(result.split(";\\s*"))
            .map(cookie -> {
              final String[] parts = cookie.split("=");

              return Map.entry(parts[0], parts[1]);
            })
            .collect(StreamUtils.Collectors.toUnmodifiableMap()));
  }

  /**
   * Calls {@link #getAll(UI)} with the specific first argument, {@code UI.getCurrent()}.
   */
  public static CompletableFuture<Map<String, String>> getAll() {
    return getAll(UI.getCurrent());
  }

  /**
   * Gets all cookies from a {@link VaadinRequest}.
   *
   * @param request The request.
   *
   * @return An array of {@link Cookie}s.
   */
  public static Cookie[] getAllFromRequest(final VaadinRequest request) {
    Arguments.requireNotNull(request);

    return request.getCookies();
  }

  /**
   * Calls {@link #getAllFromRequest(VaadinRequest)} with the specific first argument, {@code VaadinRequest.getCurrent()}.
   */
  public static Cookie[] getAllFromRequest() {
    return getAllFromRequest(VaadinRequest.getCurrent());
  }

  /**
   * Gets a cookie's value.
   *
   * @param ui   The UI.
   * @param name The name.
   *
   * @return A {@link CompletableFuture} containing the value.
   */
  public static CompletableFuture<String> get(final UI ui, final String name) {
    Arguments.requireNotNull(ui);
    Arguments.requireNotNull(name);

    return ui.getPage().executeJs("return document.cookie;")
        .toCompletableFuture(String.class)
        .thenApply(result -> {
          final String[] cookies = result.split(";\\s*");

          for(final String cookie : cookies) {
            final int indexOfEquals = cookie.indexOf('=');
            final String cookieKey = cookie.substring(0, indexOfEquals);

            if(name.equals(cookieKey)) return cookie.substring(indexOfEquals + 1);
          }

          return null;
        });
  }

  /**
   * Calls {@link #get(UI, String)} with the specific first argument, {@code UI.getCurrent()}.
   */
  public static CompletableFuture<String> get(final String name) {
    return get(UI.getCurrent(), name);
  }

  /**
   * Gets a cookie's value from a {@link VaadinRequest}.
   *
   * @param request The request.
   * @param name    The name of the cookie.
   *
   * @return The cookie.
   *     If no cookie was found, {@code null}.
   */
  public static Cookie getFromRequest(final VaadinRequest request, final String name) {
    Arguments.requireNotNull(request);
    Arguments.requireNotNull(name);

    for(final Cookie cookie : request.getCookies()) {
      if(name.equals(cookie.getName())) return cookie;
    }

    return null;
  }

  /**
   * Calls {@link #getFromRequest(VaadinRequest, String)} with the specific first argument, {@code VaadinRequest.getCurrent()}.
   */
  public static Cookie getFromRequest(final String name) {
    return getFromRequest(VaadinRequest.getCurrent(), name);
  }

  /**
   * Sets a cookie.
   *
   * @param ui     The UI.
   * @param cookie The cookie.
   *
   * @return A {@link CompletableFuture} which can be used to determine completeness.
   */
  public static CompletableFuture<Void> set(final UI ui, final String cookie) {
    Arguments.requireNotNull(ui);
    Arguments.requireNotNull(cookie);

    return ui.getPage().executeJs("document.cookie = $0;", cookie)
        .toCompletableFuture(Void.class);
  }

  /**
   * Calls {@link #set(UI, String)} with the specific first argument, {@code UI.getCurrent()}.
   */
  public static CompletableFuture<Void> set(final String cookie) {
    return set(UI.getCurrent(), cookie);
  }

  /**
   * Sets a cookie.
   *
   * @param ui         The UI.
   * @param name       The name of the cookie.
   * @param value      The value of the cookie.
   * @param attributes The attributes of the cookie.
   *
   * @return A {@link CompletableFuture} which can be used to determine completeness.
   */
  public static CompletableFuture<Void> set(final UI ui, final String name, final String value, final Map<String, String> attributes) {
    Arguments.requireNotNull(ui);
    Arguments.requireNotNull(name);
    Arguments.requireNotNull(value);

    final StringBuilder cookie = new StringBuilder();

    cookie.append(name).append('=').append(value);
    if(attributes != null) {
      for(final Map.Entry<String, String> attribute : attributes.entrySet()) {
        cookie.append("; ");
        cookie.append(Arguments.requireNotNull(attribute.getKey())).append('=').append(Arguments.requireNotNull(attribute.getValue()));
      }
    }

    return set(ui, cookie.toString());
  }

  /**
   * Calls {@link #set(UI, String, String, Map)} with a specific last arguments, {@code null}.
   */
  public static CompletableFuture<Void> set(final UI ui, final String name, final String value) {
    return set(ui, name, value, null);
  }

  /**
   * Calls {@link #set(UI, String, String, Map)} with a specific first argument, {@code UI.getCurrent()}.
   */
  public static CompletableFuture<Void> set(final String name, final String value, final Map<String, String> attributes) {
    return set(UI.getCurrent(), name, value, attributes);
  }

  /**
   * Calls {@link #set(UI, String, String)} with a specific first argument, {@code UI.getCurrent()}.
   */
  public static CompletableFuture<Void> set(final String name, final String value) {
    return set(UI.getCurrent(), name, value);
  }

  /**
   * Sets a cookie in a {@link VaadinResponse}.
   *
   * @param response The {@link VaadinResponse}.
   * @param cookie   The cookie.
   */
  public static void setInResponse(final VaadinResponse response, final Cookie cookie) {
    Arguments.requireNotNull(response);
    Arguments.requireNotNull(cookie);

    response.addCookie(cookie);
  }

  /**
   * Calls {@link #setInResponse(VaadinResponse, Cookie)} with a specific first argument, {@code VaadinService.getCurrentResponse()}.
   */
  public static void setInResponse(final Cookie cookie) {
    setInResponse(VaadinService.getCurrentResponse(), cookie);
  }

  // Constructors
  //--------------------------------------------------

  private Cookies() {
    super();

    throw new UnsupportedInstantiationException();
  }

}
