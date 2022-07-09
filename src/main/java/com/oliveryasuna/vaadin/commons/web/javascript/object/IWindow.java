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

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

/**
 * Represents the {@code Window} interface.
 *
 * @author Oliver Yasuna
 * @since 4.0.0
 */
public interface IWindow extends JavaScriptObject, EventTarget, AnimationFrameProvider, GlobalEventHandlers, WindowEventHandlers, WindowLocalStorage,
    WindowOrWorkerGlobalScope, WindowSessionStorage {

  // Methods
  //--------------------------------------------------

  // JavaScript properties
  //

  default CompletableFuture<Boolean> isClosed(final UI ui) {
    return getProperty(ui, Boolean.class, "closed");
  }

  default CompletableFuture<Boolean> isClosed() {
    return isClosed(UI.getCurrent());
  }

  IConsole getConsole();

  // TODO: customElements?

  default CompletableFuture<Double> getDevicePixelRatio(final UI ui) {
    return getProperty(ui, Double.class, "devicePixelRatio");
  }

  default CompletableFuture<Double> getDevicePixelRatio() {
    return getDevicePixelRatio(UI.getCurrent());
  }

  // TODO: document?

  // TODO: frameElement?

  // TODO: frames?

  IHistory getHistory();

  default CompletableFuture<Double> getInnerHeight(final UI ui) {
    return getProperty(ui, Double.class, "innerHeight");
  }

  default CompletableFuture<Double> getInnerHeight() {
    return getInnerHeight(UI.getCurrent());
  }

  default CompletableFuture<Double> getInnerWidth(final UI ui) {
    return getProperty(ui, Double.class, "innerWidth");
  }

  default CompletableFuture<Double> getInnerWidth() {
    return getInnerWidth(UI.getCurrent());
  }

  default CompletableFuture<Double> getLength(final UI ui) {
    return getProperty(ui, Double.class, "length");
  }

  default CompletableFuture<Double> getLength() {
    return getLength(UI.getCurrent());
  }

  // TODO: location?

  // TODO: locationbar?

  // TODO: menubar?

  default CompletableFuture<String> getName(final UI ui) {
    return getProperty(ui, String.class, "name");
  }

  default CompletableFuture<String> getName() {
    return getName(UI.getCurrent());
  }

  default CompletableFuture<Void> setName(final UI ui, final String name) {
    return setProperty(ui, "name", name);
  }

  default CompletableFuture<Void> setName(final String name) {
    return setName(UI.getCurrent(), name);
  }

  INavigator getNavigator();

  // TODO: opener?

  default CompletableFuture<Double> getOuterHeight(final UI ui) {
    return getProperty(ui, Double.class, "outerHeight");
  }

  default CompletableFuture<Double> getOuterHeight() {
    return getOuterHeight(UI.getCurrent());
  }

  default CompletableFuture<Double> getOuterWidth(final UI ui) {
    return getProperty(ui, Double.class, "outerWidth");
  }

  default CompletableFuture<Double> getOuterWidth() {
    return getOuterWidth(UI.getCurrent());
  }

  default CompletableFuture<Double> getPageXOffset(final UI ui) {
    return getProperty(ui, Double.class, "pageXOffset");
  }

  default CompletableFuture<Double> getPageXOffset() {
    return getPageXOffset(UI.getCurrent());
  }

  default CompletableFuture<Double> getPageYOffset(final UI ui) {
    return getProperty(ui, Double.class, "pageYOffset");
  }

  default CompletableFuture<Double> getPageYOffset() {
    return getPageYOffset(UI.getCurrent());
  }

  // TODO: parent?

  // TODO: personalbar?

  // TODO: screen?

  default CompletableFuture<Double> getScreenLeft(final UI ui) {
    return getProperty(ui, Double.class, "screenLeft");
  }

  default CompletableFuture<Double> getScreenLeft() {
    return getScreenLeft(UI.getCurrent());
  }

  default CompletableFuture<Double> getScreenTop(final UI ui) {
    return getProperty(ui, Double.class, "screenTop");
  }

  default CompletableFuture<Double> getScreenTop() {
    return getScreenTop(UI.getCurrent());
  }

  default CompletableFuture<Double> getScreenX(final UI ui) {
    return getProperty(ui, Double.class, "screenX");
  }

  default CompletableFuture<Double> getScreenX() {
    return getScreenX(UI.getCurrent());
  }

  default CompletableFuture<Double> getScreenY(final UI ui) {
    return getProperty(ui, Double.class, "screenY");
  }

  default CompletableFuture<Double> getScreenY() {
    return getScreenY(UI.getCurrent());
  }

  default CompletableFuture<Double> getScrollX(final UI ui) {
    return getProperty(ui, Double.class, "scrollX");
  }

  default CompletableFuture<Double> getScrollX() {
    return getScrollX(UI.getCurrent());
  }

  default CompletableFuture<Double> getScrollY(final UI ui) {
    return getProperty(ui, Double.class, "scrollY");
  }

  default CompletableFuture<Double> getScrollY() {
    return getScrollY(UI.getCurrent());
  }

  // TODO: scrollbars?

  IWindow getSelf();

  // TODO: speechSynthesis?

  // TODO: statusbar?

  // TODO: toolbar?

  IWindow getTop();

  // TODO: visualViewport?

  IWindow getWindow();

  // JavaScript methods
  //

  default CompletableFuture<Void> alert(final UI ui) {
    return callMethod(ui, Void.class, "alert");
  }

  default CompletableFuture<Void> alert() {
    return alert(UI.getCurrent());
  }

  default CompletableFuture<Void> alert(final UI ui, final Serializable message) {
    return callMethod(ui, Void.class, "alert", message);
  }

  default CompletableFuture<Void> alert(final Serializable message) {
    return alert(UI.getCurrent(), message);
  }

  default CompletableFuture<Void> blur(final UI ui) {
    return callMethod(ui, Void.class, "blur");
  }

  default CompletableFuture<Void> blur() {
    return blur(UI.getCurrent());
  }

  default CompletableFuture<Void> cancelIdleCallback(final UI ui, final int handle) {
    return callMethod(ui, Void.class, "cancelIdleCallback", handle);
  }

  default CompletableFuture<Void> cancelIdleCallback(final int handle) {
    return cancelIdleCallback(UI.getCurrent(), handle);
  }

  default CompletableFuture<Void> close(final UI ui) {
    return callMethod(ui, Void.class, "close");
  }

  default CompletableFuture<Void> close() {
    return close(UI.getCurrent());
  }

  default CompletableFuture<Void> confirm(final UI ui) {
    return callMethod(ui, Void.class, "confirm");
  }

  default CompletableFuture<Void> confirm() {
    return confirm(UI.getCurrent());
  }

  default CompletableFuture<Void> confirm(final UI ui, final String message) {
    return callMethod(ui, Void.class, "confirm", message);
  }

  default CompletableFuture<Void> confirm(final String message) {
    return confirm(UI.getCurrent(), message);
  }

  default CompletableFuture<Void> focus(final UI ui) {
    return callMethod(ui, Void.class, "focus");
  }

  default CompletableFuture<Void> focus() {
    return focus(UI.getCurrent());
  }

  // TODO: getComputedStyle()?

  // TODO: getSelection()?

  // TODO: matchMedia()?

  default CompletableFuture<Void> moveBy(final UI ui, final Double x, final Double y) {
    return callMethod(ui, Void.class, "moveBy", x, y);
  }

  default CompletableFuture<Void> moveBy(final Double x, final Double y) {
    return moveBy(UI.getCurrent(), x, y);
  }

  default CompletableFuture<Void> moveTo(final UI ui, final Double x, final Double y) {
    return callMethod(ui, Void.class, "moveTo", x, y);
  }

  default CompletableFuture<Void> moveTo(final Double x, final Double y) {
    return moveTo(UI.getCurrent(), x, y);
  }

  // TODO: open()?

  // TODO: postMessage()?

  default CompletableFuture<Void> print(final UI ui) {
    return callMethod(ui, Void.class, "print");
  }

  default CompletableFuture<Void> print() {
    return print(UI.getCurrent());
  }

  default CompletableFuture<String> prompt(final UI ui) {
    return callMethod(ui, String.class, "prompt");
  }

  default CompletableFuture<String> prompt() {
    return prompt(UI.getCurrent());
  }

  default CompletableFuture<String> prompt(final UI ui, final String message) {
    return callMethod(ui, String.class, "prompt", message);
  }

  default CompletableFuture<String> prompt(final String message) {
    return prompt(UI.getCurrent(), message);
  }

  default CompletableFuture<String> prompt(final UI ui, final String message, final String _default) {
    return callMethod(ui, String.class, "prompt", message, _default);
  }

  default CompletableFuture<String> prompt(final String message, final String _default) {
    return prompt(UI.getCurrent(), message, _default);
  }

  // TODO: requestIdleCallback()?

  default CompletableFuture<Void> resizeBy(final UI ui, final Double x, final Double y) {
    return callMethod(ui, Void.class, "resizeBy", x, y);
  }

  default CompletableFuture<Void> resizeBy(final Double x, final Double y) {
    return resizeBy(UI.getCurrent(), x, y);
  }

  default CompletableFuture<Void> resizeTo(final UI ui, final Double width, final Double height) {
    return callMethod(ui, Void.class, "resizeTo", width, height);
  }

  default CompletableFuture<Void> resizeTo(final Double width, final Double height) {
    return resizeTo(UI.getCurrent(), width, height);
  }

  // TODO: scroll(ScrollToOptions?)?

  default CompletableFuture<Void> scroll(final UI ui, final Double x, final Double y) {
    return callMethod(ui, Void.class, "scroll", x, y);
  }

  default CompletableFuture<Void> scroll(final Double x, final Double y) {
    return scroll(UI.getCurrent(), x, y);
  }

  // TODO: scrollBy(ScrollToOptions?)?

  default CompletableFuture<Void> scrollBy(final UI ui, final Double x, final Double y) {
    return callMethod(ui, Void.class, "scrollBy", x, y);
  }

  default CompletableFuture<Void> scrollBy(final Double x, final Double y) {
    return scrollBy(UI.getCurrent(), x, y);
  }

  // TODO: scrollTo(ScrollToOptions?)?

  default CompletableFuture<Void> scrollTo(final UI ui, final Double x, final Double y) {
    return callMethod(ui, Void.class, "scrollTo", x, y);
  }

  default CompletableFuture<Void> scrollTo(final Double x, final Double y) {
    return scrollTo(UI.getCurrent(), x, y);
  }

  default CompletableFuture<Void> stop(final UI ui) {
    return callMethod(ui, Void.class, "stop");
  }

  default CompletableFuture<Void> stop() {
    return stop(UI.getCurrent());
  }

  // TODO: addEventListener()?

  // TODO: removeEventListener()?

  // JavaScript indexed
  //

  // TODO: window[0], window[1], etc?

}
