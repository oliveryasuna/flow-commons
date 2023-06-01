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
 * Represents {@code HTMLElement}.
 *
 * @author Oliver Yasuna
 */
public interface IHTMLElement
    extends IElement, IDocumentAndElementEventHandlers, IElementCssInlineStyle, IElementContentEditable, IGlobalEventHandlers, IHtmlOrSvgElement {

  // Methods
  //--------------------------------------------------

  // JavaScript properties
  //

  default CompletableFuture<String> getAccessKey() {
    return getProperty("accessKey", String.class);
  }

  default CompletableFuture<Void> setAccessKey(final String accessKey) {
    return setProperty("accessKey", accessKey);
  }

  default CompletableFuture<String> getAccessKeyLabel() {
    return getProperty("accessKeyLabel", String.class);
  }

  default CompletableFuture<String> getAutocapitalize() {
    return getProperty("autocapitalize", String.class);
  }

  default CompletableFuture<Void> setAutocapitalize(final String autocapitalize) {
    return setProperty("autocapitalize", autocapitalize);
  }

  default CompletableFuture<String> getDir() {
    return getProperty("dir", String.class);
  }

  default CompletableFuture<Void> setDir(final String dir) {
    return setProperty("dir", dir);
  }

  default CompletableFuture<Boolean> getDraggable() {
    return getProperty("draggable", Boolean.class);
  }

  default CompletableFuture<Void> setDraggable(final boolean draggable) {
    return setProperty("draggable", draggable);
  }

  default CompletableFuture<Boolean> getHidden() {
    return getProperty("hidden", Boolean.class);
  }

  default CompletableFuture<Void> setHidden(final boolean hidden) {
    return setProperty("hidden", hidden);
  }

  default CompletableFuture<String> getInnerText() {
    return getProperty("innerText", String.class);
  }

  default CompletableFuture<Void> setInnerText(final String innerText) {
    return setProperty("innerText", innerText);
  }

  default CompletableFuture<String> getLang() {
    return getProperty("lang", String.class);
  }

  default CompletableFuture<Void> setLang(final String lang) {
    return setProperty("lang", lang);
  }

  default CompletableFuture<Double> getOffsetHeight() {
    return getProperty("offsetHeight", Double.class);
  }

  default CompletableFuture<Double> getOffsetLeft() {
    return getProperty("offsetLeft", Double.class);
  }

  default CompletableFuture<Double> getOffsetTop() {
    return getProperty("offsetTop", Double.class);
  }

  default CompletableFuture<Double> getOffsetWidth() {
    return getProperty("offsetWidth", Double.class);
  }

  default CompletableFuture<String> getOuterText() {
    return getProperty("outerText", String.class);
  }

  default CompletableFuture<Void> setOuterText(final String outerText) {
    return setProperty("outerText", outerText);
  }

  default CompletableFuture<Boolean> getSpellcheck() {
    return getProperty("spellcheck", Boolean.class);
  }

  default CompletableFuture<Void> setSpellcheck(final boolean spellcheck) {
    return setProperty("spellcheck", spellcheck);
  }

  default CompletableFuture<String> getTitle() {
    return getProperty("title", String.class);
  }

  default CompletableFuture<Void> setTitle(final String title) {
    return setProperty("title", title);
  }

  default CompletableFuture<Boolean> getTranslate() {
    return getProperty("translate", Boolean.class);
  }

  default CompletableFuture<Void> setTranslate(final boolean translate) {
    return setProperty("translate", translate);
  }

  // JavaScript functions
  //

  default CompletableFuture<Void> click() {
    return callFunction("click", Void.class);
  }

}
