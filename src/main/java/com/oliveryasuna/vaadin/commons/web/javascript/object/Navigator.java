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

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

/**
 * Utilities for working with the {@code Navigator} API.
 *
 * @author Oliver Yasuna
 * @since 3.1.0
 */
@Singleton
public class Navigator extends NamedJavaScriptObject {

  // Static fields
  //--------------------------------------------------

  private static final String NAME = "navigator";

  // Singleton
  //--------------------------------------------------

  private static final Navigator INSTANCE = new Navigator();

  public static Navigator getInstance() {
    return INSTANCE;
  }

  // Constructors
  //--------------------------------------------------

  protected Navigator() {
    super(NAME);
  }

  // Methods
  //--------------------------------------------------

  // JavaScript properties
  //

  // TODO: clipboard?

  public CompletableFuture<Boolean> isCookieEnabled(final UI ui) {
    return getProperty(ui, Boolean.class, "cookieEnabled");
  }

  public CompletableFuture<Boolean> isCookieEnabled() {
    return isCookieEnabled(UI.getCurrent());
  }

  // TODO: credentials?

  // TODO: geolocation?

  // TODO: hid?

  public CompletableFuture<Integer> getHardwareConcurrency(final UI ui) {
    return getProperty(ui, Integer.class, "hardwareConcurrency");
  }

  public CompletableFuture<Integer> getHardwareConcurrency() {
    return getHardwareConcurrency(UI.getCurrent());
  }

  public CompletableFuture<String> getLanguage(final UI ui) {
    return getProperty(ui, String.class, "language");
  }

  public CompletableFuture<String> getLanguage() {
    return getLanguage(UI.getCurrent());
  }

  public CompletableFuture<String> getMaxTouchPoints(final UI ui) {
    return getProperty(ui, String.class, "maxTouchPoints");
  }

  public CompletableFuture<String> getMaxTouchPoints() {
    return getMaxTouchPoints(UI.getCurrent());
  }

  // TODO: mediaDevices?

  public CompletableFuture<String> getOnLine(final UI ui) {
    return getProperty(ui, String.class, "onLine");
  }

  public CompletableFuture<String> getOnLine() {
    return getOnLine(UI.getCurrent());
  }

  public CompletableFuture<String> getPdfViewerEnabled(final UI ui) {
    return getProperty(ui, String.class, "pdfViewerEnabled");
  }

  public CompletableFuture<String> getPdfViewerEnabled() {
    return getPdfViewerEnabled(UI.getCurrent());
  }

  // TODO: storage?

  public CompletableFuture<String> getUserAgent(final UI ui) {
    return getProperty(ui, String.class, "userAgent");
  }

  public CompletableFuture<String> getUserAgent() {
    return getUserAgent(UI.getCurrent());
  }

  // TODO: userAgentData?

  // TODO: windowControlsOverlay?

  // JavaScript methods
  //

  protected CompletableFuture<Boolean> canShare(final UI ui, final Serializable... arguments) {
    return callMethod(ui, Boolean.class, "canShare", arguments);
  }

  public CompletableFuture<Boolean> canShare(final UI ui) {
    return canShare(ui, (Serializable[])null);
  }

  public CompletableFuture<Boolean> canShare() {
    return canShare(UI.getCurrent());
  }

  public CompletableFuture<Boolean> canShare(final UI ui, final String urlOrTextOrTitle) {
    return canShare(ui, (Serializable)urlOrTextOrTitle);
  }

  public CompletableFuture<Boolean> canShare(final String urlOrTextOrTitle) {
    return canShare(UI.getCurrent(), urlOrTextOrTitle);
  }

  // TODO: canShare(File[])?

  // TODO: clearAppBadge()?

  // TODO: getBattery()?

  public CompletableFuture<Void> registerProtocolHandler(final UI ui, final String scheme, final String url) {
    return callMethod(ui, Void.class, "registerProtocolHandler", scheme, url);
  }

  public CompletableFuture<Void> registerProtocolHandler(final String scheme, final String url) {
    return registerProtocolHandler(UI.getCurrent(), scheme, url);
  }

  // TODO: requestMediaKeySystemAccess()?

  // TODO: requestMIDIAccess()?

  public CompletableFuture<Boolean> sendBeacon(final UI ui, final String url) {
    return callMethod(ui, Boolean.class, "sendBeacon", url);
  }

  public CompletableFuture<Boolean> sendBeacon(final String url) {
    return sendBeacon(UI.getCurrent(), url);
  }

  // TODO: sendBeacon(url, data)?

  // TODO: setAppBadge()?

  // TODO: share()?

  // TODO: vibrate()?

}
