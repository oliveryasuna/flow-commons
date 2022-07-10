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
 * Represents the {@code Document} interface.
 *
 * @author Oliver Yasuna
 * @since 4.0.0
 */
public interface IDocument extends JavaScriptObject, INode, IDocumentAndElementEventHandlers, IDocumentOrShadowRoot, IFontFaceSource, IGlobalEventHandlers,
    INonElementParentNode, IParentNode, IXPathEvaluatorBase {

  // Methods
  //--------------------------------------------------

  // JavaScript properties
  //

  default CompletableFuture<String> getUrl(final UI ui) {
    return getProperty(ui, String.class, "URL");
  }

  default CompletableFuture<String> getUrl() {
    return getUrl(UI.getCurrent());
  }

  // TODO: body?

  default CompletableFuture<String> getCharacterSet(final UI ui) {
    return getProperty(ui, String.class, "characterSet");
  }

  default CompletableFuture<String> getCharacterSet() {
    return getCharacterSet(UI.getCurrent());
  }

  default CompletableFuture<String> getCompatMode(final UI ui) {
    return getProperty(ui, String.class, "compatMode");
  }

  default CompletableFuture<String> getCompatMode() {
    return getCompatMode(UI.getCurrent());
  }

  default CompletableFuture<String> getContentType(final UI ui) {
    return getProperty(ui, String.class, "contentType");
  }

  default CompletableFuture<String> getContentType() {
    return getContentType(UI.getCurrent());
  }

  default CompletableFuture<String> getCookie(final UI ui) {
    return getProperty(ui, String.class, "cookie");
  }

  default CompletableFuture<String> getCookie() {
    return getCookie(UI.getCurrent());
  }

  default CompletableFuture<Void> setCookie(final UI ui, final String cookie) {
    return setProperty(ui, "cookie", cookie);
  }

  default CompletableFuture<Void> setCookie(final String cookie) {
    return setCookie(UI.getCurrent(), cookie);
  }

  // TODO: currentScript?

  // TODO: defaultView?

  default CompletableFuture<String> getDesignMode(final UI ui) {
    return getProperty(ui, String.class, "designMode");
  }

  default CompletableFuture<String> getDesignMode() {
    return getDesignMode(UI.getCurrent());
  }

  default CompletableFuture<String> getDir(final UI ui) {
    return getProperty(ui, String.class, "dir");
  }

  default CompletableFuture<String> getDir() {
    return getDir(UI.getCurrent());
  }

  // TODO: doctype?

  // TODO: documentElement?

  default CompletableFuture<String> getDocumentUri(final UI ui) {
    return getProperty(ui, String.class, "documentURI");
  }

  default CompletableFuture<String> getDocumentUri() {
    return getDocumentUri(UI.getCurrent());
  }

  default CompletableFuture<String> getDomain(final UI ui) {
    return getProperty(ui, String.class, "domain");
  }

  default CompletableFuture<String> getDomain() {
    return getDomain(UI.getCurrent());
  }

  default CompletableFuture<Void> setDomain(final UI ui, final String domain) {
    return setProperty(ui, "domain", domain);
  }

  default CompletableFuture<Void> setDomain(final String domain) {
    return setDomain(UI.getCurrent(), domain);
  }

  // TODO: embeds?

  // TODO: forms?

  default CompletableFuture<Boolean> isFullscreenEnabled(final UI ui) {
    return getProperty(ui, Boolean.class, "fullscreenEnabled");
  }

  default CompletableFuture<Boolean> isFullscreenEnabled() {
    return isFullscreenEnabled(UI.getCurrent());
  }

  // TODO: head?

  default CompletableFuture<Boolean> isHidden(final UI ui) {
    return getProperty(ui, Boolean.class, "hidden");
  }

  default CompletableFuture<Boolean> isHidden() {
    return isHidden(UI.getCurrent());
  }

  // TODO: images?

  // TODO: implementation?

  default CompletableFuture<String> getLastModified(final UI ui) {
    return getProperty(ui, String.class, "lastModified");
  }

  default CompletableFuture<String> getLastModified() {
    return getLastModified(UI.getCurrent());
  }

  // TODO: links?

  // TODO: getLocation()?

  default CompletableFuture<Void> setLocation(final UI ui, final String href) {
    return setProperty(ui, "location", href);
  }

  default CompletableFuture<Void> setLocation(final String href) {
    return setLocation(UI.getCurrent(), href);
  }

  // TODO: setLocation(Location)?

  // TODO: onfullscreenchange?

  // TODO: onfullscreenerror?

  // TODO: onpointerlockchange?

  // TODO: onpointerlockerror?

  // TODO: onreadystatechange?

  // TODO: onvisibilitychange?

  // TODO: If I implement ownerDocument in Node, I need to override it here and always return null.

  default CompletableFuture<Boolean> isPictureInPictureEnabled(final UI ui) {
    return getProperty(ui, Boolean.class, "pictureInPictureEnabled");
  }

  default CompletableFuture<Boolean> isPictureInPictureEnabled() {
    return isPictureInPictureEnabled(UI.getCurrent());
  }

  // TODO: plugins?

  // TODO: readyState?

  default CompletableFuture<String> getReferrer(final UI ui) {
    return getProperty(ui, String.class, "referrer");
  }

  default CompletableFuture<String> getReferrer() {
    return getReferrer(UI.getCurrent());
  }

  // TODO: rootElement?

  // TODO: scripts?

  // TODO: scrollingElement?

  // TODO: timeline?

  default CompletableFuture<String> getTitle(final UI ui) {
    return getProperty(ui, String.class, "title");
  }

  default CompletableFuture<String> getTitle() {
    return getTitle(UI.getCurrent());
  }

  default CompletableFuture<Void> setTitle(final UI ui, final String title) {
    return setProperty(ui, "title", title);
  }

  default CompletableFuture<Void> setTitle(final String title) {
    return setTitle(UI.getCurrent(), title);
  }

  // TODO: visibilityState?

  // JavaScript methods
  //

  // TODO: Many many methods.

}
