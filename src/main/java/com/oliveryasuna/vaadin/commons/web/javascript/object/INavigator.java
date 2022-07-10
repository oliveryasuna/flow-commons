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
 * Represents the {@code Navigator} interface.
 *
 * @author Oliver Yasuna
 * @since 4.0.0
 */
public interface INavigator extends JavaScriptObject {

  // Methods
  //--------------------------------------------------

  // JavaScript properties
  //

  // TODO: clipboard?

  default CompletableFuture<Boolean> isCookieEnabled(final UI ui) {
    return getProperty(ui, Boolean.class, "cookieEnabled");
  }

  default CompletableFuture<Boolean> isCookieEnabled() {
    return isCookieEnabled(UI.getCurrent());
  }

  // TODO: credentials?

  // TODO: geolocation?

  // TODO: hid?

  default CompletableFuture<Integer> getHardwareConcurrency(final UI ui) {
    return getProperty(ui, Integer.class, "hardwareConcurrency");
  }

  default CompletableFuture<Integer> getHardwareConcurrency() {
    return getHardwareConcurrency(UI.getCurrent());
  }

  default CompletableFuture<String> getLanguage(final UI ui) {
    return getProperty(ui, String.class, "language");
  }

  default CompletableFuture<String> getLanguage() {
    return getLanguage(UI.getCurrent());
  }

  default CompletableFuture<String> getMaxTouchPoints(final UI ui) {
    return getProperty(ui, String.class, "maxTouchPoints");
  }

  default CompletableFuture<String> getMaxTouchPoints() {
    return getMaxTouchPoints(UI.getCurrent());
  }

  // TODO: mediaDevices?

  default CompletableFuture<String> getOnLine(final UI ui) {
    return getProperty(ui, String.class, "onLine");
  }

  default CompletableFuture<String> getOnLine() {
    return getOnLine(UI.getCurrent());
  }

  default CompletableFuture<String> getPdfViewerEnabled(final UI ui) {
    return getProperty(ui, String.class, "pdfViewerEnabled");
  }

  default CompletableFuture<String> getPdfViewerEnabled() {
    return getPdfViewerEnabled(UI.getCurrent());
  }

  // TODO: storage?

  default CompletableFuture<String> getUserAgent(final UI ui) {
    return getProperty(ui, String.class, "userAgent");
  }

  default CompletableFuture<String> getUserAgent() {
    return getUserAgent(UI.getCurrent());
  }

  // TODO: userAgentData?

  // TODO: windowControlsOverlay?

  // JavaScript methods
  //

  default CompletableFuture<Boolean> canShare(final UI ui) {
    return callMethod(ui, Boolean.class, "canShare");
  }

  default CompletableFuture<Boolean> canShare() {
    return canShare(UI.getCurrent());
  }

  default CompletableFuture<Boolean> canShare(final UI ui, final String urlOrTextOrTitle) {
    return callMethod(ui, Boolean.class, "canShare", urlOrTextOrTitle);
  }

  default CompletableFuture<Boolean> canShare(final String urlOrTextOrTitle) {
    return canShare(UI.getCurrent(), urlOrTextOrTitle);
  }

  // TODO: canShare(File[])?

  // TODO: clearAppBadge()?

  // TODO: getBattery()?

  default CompletableFuture<Void> registerProtocolHandler(final UI ui, final String scheme, final String url) {
    return callMethod(ui, Void.class, "registerProtocolHandler", scheme, url);
  }

  default CompletableFuture<Void> registerProtocolHandler(final String scheme, final String url) {
    return registerProtocolHandler(UI.getCurrent(), scheme, url);
  }

  // TODO: requestMediaKeySystemAccess()?

  // TODO: requestMIDIAccess()?

  default CompletableFuture<Boolean> sendBeacon(final UI ui, final String url) {
    return callMethod(ui, Boolean.class, "sendBeacon", url);
  }

  default CompletableFuture<Boolean> sendBeacon(final String url) {
    return sendBeacon(UI.getCurrent(), url);
  }

  default CompletableFuture<Boolean> sendBeacon(final UI ui, final String url, final String data) {
    return callMethod(ui, Boolean.class, "sendBeacon", url, data);
  }

  default CompletableFuture<Boolean> sendBeacon(final String url, final String data) {
    return sendBeacon(UI.getCurrent(), url, data);
  }

  // TODO: sendBeacon(url, data)?

  // TODO: setAppBadge()?

  // TODO: share()?

  // TODO: vibrate()?

}
