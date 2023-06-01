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
 * Represents an {@code Element}.
 *
 * @author Oliver Yasuna
 */
public interface IElement extends INode, IAriaMixin, IAnimatable, IChildNode, IInnerHtml, INonDocumentTypeChildNode, IParentNode, ISlottable {

  // Methods
  //--------------------------------------------------

  // JavaScript properties
  //

  default CompletableFuture<String> getClassName() {
    return getProperty("className", String.class);
  }

  default CompletableFuture<Void> setClassName(final String className) {
    return setProperty("className", className);
  }

  default CompletableFuture<Double> getClientHeight() {
    return getProperty("clientHeight", Double.class);
  }

  default CompletableFuture<Double> getClientLeft() {
    return getProperty("clientLeft", Double.class);
  }

  default CompletableFuture<Double> getClientTop() {
    return getProperty("clientTop", Double.class);
  }

  default CompletableFuture<Double> getClientWidth() {
    return getProperty("clientWidth", Double.class);
  }

  default CompletableFuture<String> getId() {
    return getProperty("id", String.class);
  }

  default CompletableFuture<Void> setId(final String id) {
    return setProperty("id", id);
  }

  default CompletableFuture<String> getLocalName() {
    return getProperty("localName", String.class);
  }

  default CompletableFuture<String> getNamespaceURI() {
    return getProperty("namespaceURI", String.class);
  }

  default CompletableFuture<String> getOuterHTML() {
    return getProperty("outerHTML", String.class);
  }

  default CompletableFuture<Void> setOuterHTML(final String outerHTML) {
    return setProperty("outerHTML", outerHTML);
  }

  IDocument getOwnerDocument();

  default CompletableFuture<String> getPrefix() {
    return getProperty("prefix", String.class);
  }

  default CompletableFuture<Double> getScrollHeight() {
    return getProperty("scrollHeight", Double.class);
  }

  default CompletableFuture<Double> getScrollLeft() {
    return getProperty("scrollLeft", Double.class);
  }

  default CompletableFuture<Void> setScrollLeft(final double scrollLeft) {
    return setProperty("scrollLeft", scrollLeft);
  }

  default CompletableFuture<Double> getScrollTop() {
    return getProperty("scrollTop", Double.class);
  }

  default CompletableFuture<Void> setScrollTop(final double scrollTop) {
    return setProperty("scrollTop", scrollTop);
  }

  default CompletableFuture<Double> getScrollWidth() {
    return getProperty("scrollWidth", Double.class);
  }

  default CompletableFuture<String> getSlot() {
    return getProperty("slot", String.class);
  }

  default CompletableFuture<Void> setSlot(final String slot) {
    return setProperty("slot", slot);
  }

  default CompletableFuture<String> getTagName() {
    return getProperty("tagName", String.class);
  }

  // JavaScript functions
  //

  default CompletableFuture<String> getAttribute(final String name) {
    return callFunction("getAttribute", String.class, name);
  }

  default CompletableFuture<Boolean> hasAttribute(final String name) {
    return callFunction("hasAttribute", Boolean.class, name);
  }

  default CompletableFuture<Boolean> hasAttributes() {
    return callFunction("hasAttributes", Boolean.class);
  }

  default CompletableFuture<Boolean> matches(final String selectors) {
    return callFunction("matches", Boolean.class, selectors);
  }

  default CompletableFuture<Void> removeAttribute(final String name) {
    return callFunction("removeAttribute", Void.class, name);
  }

  default CompletableFuture<Void> scroll(final double x, final double y) {
    return callFunction("scroll", Void.class, y);
  }

  default CompletableFuture<Void> scrollBy(final double x, final double y) {
    return callFunction("scrollBy", Void.class, y);
  }

  default CompletableFuture<Void> scrollTo(final double x, final double y) {
    return callFunction("scrollTo", Void.class, y);
  }

  default CompletableFuture<Void> setAttribute(final String name, final String value) {
    return callFunction("setAttribute", Void.class, name, value);
  }

  default CompletableFuture<Void> setAttributeNs(final String namespace, final String localName, final String value) {
    return callFunction("setAttributeNS", Void.class, namespace, localName, value);
  }

  default CompletableFuture<Boolean> toggleAttribute(final String name, final boolean force) {
    return callFunction("toggleAttribute", Boolean.class, name, force);
  }

  default CompletableFuture<Boolean> toggleAttribute(final String name) {
    return callFunction("toggleAttribute", Boolean.class, name);
  }

}
