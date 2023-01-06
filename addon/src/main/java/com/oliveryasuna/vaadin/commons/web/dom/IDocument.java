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
 * Represents the {@code Document} interface.
 *
 * @author Oliver Yasuna
 */
public interface IDocument extends INode, IDocumentAndElementEventHandlers, IDocumentOrShadowRoot, IFontFaceSource, IGlobalEventHandlers,
    INonElementParentNode, IParentNode, IXPathEvaluatorBase {

  // Methods
  //--------------------------------------------------

  // JavaScript properties
  //

  default CompletableFuture<String> getUrl() {
    return getProperty("URL", String.class);
  }

  IHTMLElement getBody();

  default CompletableFuture<String> getCharacterSet() {
    return getProperty("characterSet", String.class);
  }

  default CompletableFuture<String> getCharset() {
    return getProperty("charset", String.class);
  }

  default CompletableFuture<String> getCompatMode() {
    return getProperty("compatMode", String.class);
  }

  default CompletableFuture<String> getContentType() {
    return getProperty("contentType", String.class);
  }

  default CompletableFuture<String> getCookie() {
    return getProperty("cookie", String.class);
  }

  default CompletableFuture<Void> setCookie(final String cookie) {
    return setProperty("cookie", cookie);
  }

  // TODO: currentScript?

  // TODO: defaultView?

  default CompletableFuture<String> getDesignMode() {
    return getProperty("designMode", String.class);
  }

  default CompletableFuture<Void> setDesignMode(final String designMode) {
    return setProperty("designMode", designMode);
  }

  default CompletableFuture<String> getDir() {
    return getProperty("dir", String.class);
  }

  default CompletableFuture<Void> setDir(final String dir) {
    return setProperty("dir", dir);
  }

  // TODO: doctype?

  // TODO: documentElement?

  default CompletableFuture<String> getDocumentUri() {
    return getProperty("documentURI", String.class);
  }

  default CompletableFuture<String> getDomain() {
    return getProperty("domain", String.class);
  }

  default CompletableFuture<Void> setDomain(final String domain) {
    return setProperty("domain", domain);
  }

  // TODO: embeds?

  // TODO: forms?

  default CompletableFuture<Boolean> isFullscreenEnabled() {
    return getProperty("fullscreenEnabled", Boolean.class);
  }

  IHTMLHeadElement getHead();

  default CompletableFuture<String> getHidden() {
    return getProperty("hidden", String.class);
  }

  // TODO: images?

  // TODO: implementation?

  default CompletableFuture<String> getInputEncoding() {
    return getProperty("inputEncoding", String.class);
  }

  default CompletableFuture<String> getLastModified() {
    return getProperty("lastModified", String.class);
  }

  // TODO: links?

  // TODO: location?

  // TODO: onfullscreenchange?

  // TODO: onfullscreenerror?

  // TODO: onpointerlockchange?

  // TODO: onpointerlockerror?

  // TODO: onreadystatechange?

  // TODO: onvisibilitychange?

  // TODO: ownerDocument?

  default CompletableFuture<Boolean> getPictureInPictureEnabled() {
    return getProperty("pictureInPictureEnabled", Boolean.class);
  }

  // TODO: plugins?

  // TODO: readyState?

  default CompletableFuture<String> getReferrer() {
    return getProperty("referrer", String.class);
  }

  // TODO: scripts?

  // TODO: scrollingElement?

  // TODO: timeline?

  default CompletableFuture<String> getTitle() {
    return getProperty("title", String.class);
  }

  default CompletableFuture<Void> setTitle(final String title) {
    return setProperty("title", title);
  }

  // TODO: visibilityState?

  // JavaScript functions
  //

  // TODO: Tons of functions.

}
