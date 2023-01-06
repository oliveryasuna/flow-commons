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
 * Represents {@code Node}.
 *
 * @author Oliver Yasuna
 */
public interface INode extends IEventTarget {

  // Methods
  //--------------------------------------------------

  // JavaScript properties
  //

  default CompletableFuture<String> getBaseUri() {
    return getProperty("baseURI", String.class);
  }

  // TODO: childNodes?

  // TODO: firstChild?

  default CompletableFuture<Boolean> getIsConnected() {
    return getProperty("isConnected", Boolean.class);
  }

  // TODO: lastChild?

  // TODO: nextSibling?

  default CompletableFuture<String> getNodeName() {
    return getProperty("nodeName", String.class);
  }

  default CompletableFuture<Integer> getNodeType() {
    return getProperty("nodeType", Integer.class);
  }

  default CompletableFuture<String> getNodeValue() {
    return getProperty("nodeValue", String.class);
  }

  default CompletableFuture<Void> setNodeValue(final String nodeValue) {
    return setProperty("nodeValue", nodeValue);
  }

  // TODO: ownerDocument?

  // TODO: parentElement?

  // TODO: parentNode?

  // TODO: previousSibling?

  default CompletableFuture<String> getTextContent() {
    return getProperty("textContent", String.class);
  }

  default CompletableFuture<Void> setTextContent(final String textContent) {
    return setProperty("textContent", textContent);
  }

  // JavaScript functions
  //

  // TODO: appendChild()?

  // TODO: cloneNode()?

  // TODO: compareDocumentPosition()?

  // TODO: contains()?

  // TODO: getRootNode()?

  default CompletableFuture<Boolean> hasChildNodes() {
    return callFunction("hasChildNodes", Boolean.class);
  }

  // TODO: insertBefore()?

  // TODO: isDefaultNamespace()?

  // TODO: isEqualNode()?

  // TODO: isSameNode()?

  // TODO: lookupNamespaceURI()?

  // TODO: lookupPrefix()?

  // TODO: normalize()?

  // TODO: removeChild()?

  // TODO: replaceChild()?

}
