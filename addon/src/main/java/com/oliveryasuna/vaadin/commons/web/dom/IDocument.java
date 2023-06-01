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

  default CompletableFuture<String> getContentType() {
    return getProperty("contentType", String.class);
  }

  default CompletableFuture<String> getCookie() {
    return getProperty("cookie", String.class);
  }

  default CompletableFuture<Void> setCookie(final String cookie) {
    return setProperty("cookie", cookie);
  }

  default CompletableFuture<String> getDir() {
    return getProperty("dir", String.class);
  }

  default CompletableFuture<Void> setDir(final String dir) {
    return setProperty("dir", dir);
  }

  IHTMLElement getDocumentElement();

  default CompletableFuture<String> getDocumentURI() {
    return getProperty("documentURI", String.class);
  }

  default CompletableFuture<String> getDomain() {
    return getProperty("domain", String.class);
  }

  default CompletableFuture<Void> setDomain(final String domain) {
    return setProperty("domain", domain);
  }

  default CompletableFuture<Boolean> isFullscreenEnabled() {
    return getProperty("fullscreenEnabled", Boolean.class);
  }

  IHTMLHeadElement getHead();

  default CompletableFuture<String> getHidden() {
    return getProperty("hidden", String.class);
  }

  default CompletableFuture<String> getInputEncoding() {
    return getProperty("inputEncoding", String.class);
  }

  default CompletableFuture<String> getLastModified() {
    return getProperty("lastModified", String.class);
  }

  default CompletableFuture<Boolean> getPictureInPictureEnabled() {
    return getProperty("pictureInPictureEnabled", Boolean.class);
  }

  default CompletableFuture<String> getReadyState() {
    return getProperty("readyState", String.class);
  }

  default CompletableFuture<String> getReferrer() {
    return getProperty("referrer", String.class);
  }

  default CompletableFuture<String> getTitle() {
    return getProperty("title", String.class);
  }

  default CompletableFuture<Void> setTitle(final String title) {
    return setProperty("title", title);
  }

  default CompletableFuture<String> getVisibilityState() {
    return getProperty("visibilityState", String.class);
  }

  // JavaScript functions
  //

  default CompletableFuture<Void> close() {
    return callFunction("close", Void.class);
  }

  default CompletableFuture<Boolean> hasFocus() {
    return callFunction("hasFocus", Boolean.class);
  }

}
