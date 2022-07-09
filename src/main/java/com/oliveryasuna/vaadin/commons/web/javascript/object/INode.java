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
 * Represents the {@code Node} interface.
 *
 * @author Oliver Yasuna
 * @since 4.0.0
 */
public interface INode extends JavaScriptObject, IEventTarget {

  // Methods
  //--------------------------------------------------

  // JavaScript properties
  //

  default CompletableFuture<String> getBaseUri(final UI ui) {
    return getProperty(ui, String.class, "baseURI");
  }

  default CompletableFuture<String> getBaseUri() {
    return getBaseUri(UI.getCurrent());
  }

  // TODO: childNodes?

  // TODO: firstChild?

  default CompletableFuture<Boolean> isIsConnected(final UI ui) {
    return getProperty(ui, Boolean.class, "isConnected");
  }

  default CompletableFuture<Boolean> isIsConnected() {
    return isIsConnected(UI.getCurrent());
  }

  // TODO: lastChild?

  // TODO: nextSibling?

  default CompletableFuture<String> getNodeName(final UI ui) {
    return getProperty(ui, String.class, "nodeName");
  }

  default CompletableFuture<String> getNodeName() {
    return getNodeName(UI.getCurrent());
  }

  default CompletableFuture<Integer> getNodeType(final UI ui) {
    return getProperty(ui, Integer.class, "nodeType");
  }

  default CompletableFuture<Integer> getNodeType() {
    return getNodeType(UI.getCurrent());
  }

  default CompletableFuture<String> getNodeValue(final UI ui) {
    return getProperty(ui, String.class, "nodeValue");
  }

  default CompletableFuture<String> getNodeValue() {
    return getNodeValue(UI.getCurrent());
  }

  default CompletableFuture<Void> setNodeValue(final UI ui, final String nodeValue) {
    return setProperty(ui, "nodeValue", nodeValue);
  }

  default CompletableFuture<Void> setNodeValue(final String nodeValue) {
    return setNodeValue(UI.getCurrent(), nodeValue);
  }

  // TODO: ownerDocument?

  // TODO: parentElement?

  // TODO: parentNode?

  // TODO: previousSibling?

  default CompletableFuture<String> getTextContent(final UI ui) {
    return getProperty(ui, String.class, "textContent");
  }

  default CompletableFuture<String> getTextContent() {
    return getTextContent(UI.getCurrent());
  }

  default CompletableFuture<Void> setTextContent(final UI ui, final String textContent) {
    return setProperty(ui, "textContent", textContent);
  }

  default CompletableFuture<Void> setTextContent(final String textContent) {
    return setTextContent(UI.getCurrent(), textContent);
  }

  // JavaScript methods
  //

  // TODO: JavaScript methods.

}
