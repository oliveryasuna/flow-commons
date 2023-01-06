/*
 * Copyright 2023 Oliver Yasuna
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

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

/**
 * Represents {@code Window}.
 *
 * @author Oliver Yasuna
 */
public interface IWindow extends IEventTarget, IAnimationFrameProvider, IGlobalEventHandlers, IWindowEventHandlers, IWindowLocalStorage, IWindowSessionStorage {

  // Methods
  //--------------------------------------------------

  // JavaScript properties
  //

  default CompletableFuture<Boolean> getClosed() {
    return getProperty("closed", Boolean.class);
  }

  ICustomElementRegistry getCustomElements();

  default CompletableFuture<Double> getDevicePixelRatio() {
    return getProperty("devicePixelRatio", Double.class);
  }

  IDocument getDocument();

  IWindowProxy getWindowProxy();

  default CompletableFuture<Double> getInnerHeight() {
    return getProperty("innerHeight", Double.class);
  }

  default CompletableFuture<Double> getInnerWidth() {
    return getProperty("innerWidth", Double.class);
  }

  default CompletableFuture<Integer> getLength() {
    return getProperty("length", Integer.class);
  }

  // TODO: location?

  IBarProp getLocationbar();

  IBarProp getMenubar();

  default CompletableFuture<String> getName() {
    return getProperty("name", String.class);
  }

  default CompletableFuture<Void> setName(final String name) {
    return setProperty("name", name);
  }

  INavigator getNavigator();

  default CompletableFuture<Double> getOuterHeight() {
    return getProperty("outerHeight", Double.class);
  }

  default CompletableFuture<Double> getOuterWidth() {
    return getProperty("outerWidth", Double.class);
  }

  IWindowProxy getParent();

  IBarProp getPersonalbar();

  IScreen getScreen();

  default CompletableFuture<Double> getScreenLeft() {
    return getProperty("screenLeft", Double.class);
  }

  default CompletableFuture<Double> getScreenTop() {
    return getProperty("screenTop", Double.class);
  }

  default CompletableFuture<Double> getScreenX() {
    return getProperty("screenX", Double.class);
  }

  default CompletableFuture<Double> getScreenY() {
    return getProperty("screenY", Double.class);
  }

  default CompletableFuture<Double> getScrollX() {
    return getProperty("scrollX", Double.class);
  }

  default CompletableFuture<Double> getScrollY() {
    return getProperty("scrollY", Double.class);
  }

  IBarProp getScrollbars();

  IWindow getSelf();

  ISpeechSynthesis getSpeechSynthesis();

  IBarProp getStatusbar();

  IBarProp getToolbar();

  IWindowProxy getTop();

  IVisualViewport getVisualViewport();

  IWindow getWindow();

  default CompletableFuture<Void> alert(final Serializable message) {
    return callFunction("alert", Void.class, message);
  }

  default CompletableFuture<Void> alert() {
    return callFunction("alert", Void.class);
  }

  default CompletableFuture<Void> blur() {
    return callFunction("blur", Void.class);
  }

  default CompletableFuture<Void> cancelIdleCallback(final Integer handle) {
    return callFunction("cancelIdleCallback", Void.class, handle);
  }

  default CompletableFuture<Void> close() {
    return callFunction("close", Void.class);
  }

  default CompletableFuture<Void> confirm(final Serializable message) {
    return callFunction("confirm", Void.class, message);
  }

  default CompletableFuture<Void> confirm() {
    return callFunction("confirm", Void.class);
  }

  default CompletableFuture<Void> focus() {
    return callFunction("focus", Void.class);
  }

  default CompletableFuture<Void> moveBy(final Double x, final Double y) {
    return callFunction("moveBy", Void.class, x, y);
  }

  default CompletableFuture<Void> moveTo(final Double x, final Double y) {
    return callFunction("moveTo", Void.class, x, y);
  }

  default CompletableFuture<Void> print() {
    return callFunction("print", Void.class);
  }

  default CompletableFuture<String> prompt(final String message, final String _default) {
    return callFunction("prompt", String.class, message, _default);
  }

  default CompletableFuture<String> prompt(final String message) {
    return callFunction("prompt", String.class, message);
  }

  default CompletableFuture<String> prompt() {
    return callFunction("prompt", String.class);
  }

  default CompletableFuture<Void> resizeBy(final Double x, final Double y) {
    return callFunction("resizeBy", Void.class, x, y);
  }

  default CompletableFuture<Void> resizeTo(final Double width, final Double height) {
    return callFunction("resizeTo", Void.class, width, height);
  }

  default CompletableFuture<Void> scrollBy(final Double x, final Double y) {
    return callFunction("scrollBy", Void.class, x, y);
  }

  default CompletableFuture<Void> scrollTo(final Double x, final Double y) {
    return callFunction("scrollTo", Void.class, x, y);
  }

  default CompletableFuture<Void> stop() {
    return callFunction("stop", Void.class);
  }

}
