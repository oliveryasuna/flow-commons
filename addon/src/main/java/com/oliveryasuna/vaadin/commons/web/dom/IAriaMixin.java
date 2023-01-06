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
 * Represents {@code ARIAMixin}.
 *
 * @author Oliver Yasuna
 */
public interface IAriaMixin extends DomObject {

  // Methods
  //--------------------------------------------------

  // JavaScript properties
  //

  default CompletableFuture<String> getAriaAtomic() {
    return getProperty("ariaAtomic", String.class);
  }

  default CompletableFuture<Void> setAriaAtomic(final String ariaAtomic) {
    return setProperty("ariaAtomic", ariaAtomic);
  }

  default CompletableFuture<String> getAriaAutoComplete() {
    return getProperty("ariaAutoComplete", String.class);
  }

  default CompletableFuture<Void> setAriaAutoComplete(final String ariaAutoComplete) {
    return setProperty("ariaAutoComplete", ariaAutoComplete);
  }

  default CompletableFuture<String> getAriaBusy() {
    return getProperty("ariaBusy", String.class);
  }

  default CompletableFuture<Void> setAriaBusy(final String ariaBusy) {
    return setProperty("ariaBusy", ariaBusy);
  }

  default CompletableFuture<String> getAriaChecked() {
    return getProperty("ariaChecked", String.class);
  }

  default CompletableFuture<Void> setAriaChecked(final String ariaChecked) {
    return setProperty("ariaChecked", ariaChecked);
  }

  default CompletableFuture<String> getAriaColCount() {
    return getProperty("ariaColCount", String.class);
  }

  default CompletableFuture<Void> setAriaColCount(final String ariaColCount) {
    return setProperty("ariaColCount", ariaColCount);
  }

  default CompletableFuture<String> getAriaColIndex() {
    return getProperty("ariaColIndex", String.class);
  }

  default CompletableFuture<Void> setAriaColIndex(final String ariaColIndex) {
    return setProperty("ariaColIndex", ariaColIndex);
  }

  default CompletableFuture<String> getAriaColSpan() {
    return getProperty("ariaColSpan", String.class);
  }

  default CompletableFuture<Void> setAriaColSpan(final String ariaColSpan) {
    return setProperty("ariaColSpan", ariaColSpan);
  }

  default CompletableFuture<String> getAriaCurrent() {
    return getProperty("ariaCurrent", String.class);
  }

  default CompletableFuture<Void> setAriaCurrent(final String ariaCurrent) {
    return setProperty("ariaCurrent", ariaCurrent);
  }

  default CompletableFuture<String> getAriaDisabled() {
    return getProperty("ariaDisabled", String.class);
  }

  default CompletableFuture<Void> setAriaDisabled(final String ariaDisabled) {
    return setProperty("ariaDisabled", ariaDisabled);
  }

  default CompletableFuture<String> getAriaExpanded() {
    return getProperty("ariaExpanded", String.class);
  }

  default CompletableFuture<Void> setAriaExpanded(final String ariaExpanded) {
    return setProperty("ariaExpanded", ariaExpanded);
  }

  default CompletableFuture<String> getAriaHasPopup() {
    return getProperty("ariaHasPopup", String.class);
  }

  default CompletableFuture<Void> setAriaHasPopup(final String ariaHasPopup) {
    return setProperty("ariaHasPopup", ariaHasPopup);
  }

  default CompletableFuture<String> getAriaHidden() {
    return getProperty("ariaHidden", String.class);
  }

  default CompletableFuture<Void> setAriaHidden(final String ariaHidden) {
    return setProperty("ariaHidden", ariaHidden);
  }

  default CompletableFuture<String> getAriaKeyShortcuts() {
    return getProperty("ariaKeyShortcuts", String.class);
  }

  default CompletableFuture<Void> setAriaKeyShortcuts(final String ariaKeyShortcuts) {
    return setProperty("ariaKeyShortcuts", ariaKeyShortcuts);
  }

  default CompletableFuture<String> getAriaLabel() {
    return getProperty("ariaLabel", String.class);
  }

  default CompletableFuture<Void> setAriaLabel(final String ariaLabel) {
    return setProperty("ariaLabel", ariaLabel);
  }

  default CompletableFuture<String> getAriaLevel() {
    return getProperty("ariaLevel", String.class);
  }

  default CompletableFuture<Void> setAriaLevel(final String ariaLevel) {
    return setProperty("ariaLevel", ariaLevel);
  }

  default CompletableFuture<String> getAriaLive() {
    return getProperty("ariaLive", String.class);
  }

  default CompletableFuture<Void> setAriaLive(final String ariaLive) {
    return setProperty("ariaLive", ariaLive);
  }

  default CompletableFuture<String> getAriaModal() {
    return getProperty("ariaModal", String.class);
  }

  default CompletableFuture<Void> setAriaModal(final String ariaModal) {
    return setProperty("ariaModal", ariaModal);
  }

  default CompletableFuture<String> getAriaMultiLine() {
    return getProperty("ariaMultiLine", String.class);
  }

  default CompletableFuture<Void> setAriaMultiLine(final String ariaMultiLine) {
    return setProperty("ariaMultiLine", ariaMultiLine);
  }

  default CompletableFuture<String> getAriaMultiSelectable() {
    return getProperty("ariaMultiSelectable", String.class);
  }

  default CompletableFuture<Void> setAriaMultiSelectable(final String ariaMultiSelectable) {
    return setProperty("ariaMultiSelectable", ariaMultiSelectable);
  }

  default CompletableFuture<String> getAriaOrientation() {
    return getProperty("ariaOrientation", String.class);
  }

  default CompletableFuture<Void> setAriaOrientation(final String ariaOrientation) {
    return setProperty("ariaOrientation", ariaOrientation);
  }

  default CompletableFuture<String> getAriaPlaceholder() {
    return getProperty("ariaPlaceholder", String.class);
  }

  default CompletableFuture<Void> setAriaPlaceholder(final String ariaPlaceholder) {
    return setProperty("ariaPlaceholder", ariaPlaceholder);
  }

  default CompletableFuture<String> getAriaPosInSet() {
    return getProperty("ariaPosInSet", String.class);
  }

  default CompletableFuture<Void> setAriaPosInSet(final String ariaPosInSet) {
    return setProperty("ariaPosInSet", ariaPosInSet);
  }

  default CompletableFuture<String> getAriaPressed() {
    return getProperty("ariaPressed", String.class);
  }

  default CompletableFuture<Void> setAriaPressed(final String ariaPressed) {
    return setProperty("ariaPressed", ariaPressed);
  }

  default CompletableFuture<String> getAriaReadOnly() {
    return getProperty("ariaReadOnly", String.class);
  }

  default CompletableFuture<Void> setAriaReadOnly(final String ariaReadOnly) {
    return setProperty("ariaReadOnly", ariaReadOnly);
  }

  default CompletableFuture<String> getAriaRequired() {
    return getProperty("ariaRequired", String.class);
  }

  default CompletableFuture<Void> setAriaRequired(final String ariaRequired) {
    return setProperty("ariaRequired", ariaRequired);
  }

  default CompletableFuture<String> getAriaRoleDescription() {
    return getProperty("ariaRoleDescription", String.class);
  }

  default CompletableFuture<Void> setAriaRoleDescription(final String ariaRoleDescription) {
    return setProperty("ariaRoleDescription", ariaRoleDescription);
  }

  default CompletableFuture<String> getAriaRowCount() {
    return getProperty("ariaRowCount", String.class);
  }

  default CompletableFuture<Void> setAriaRowCount(final String ariaRowCount) {
    return setProperty("ariaRowCount", ariaRowCount);
  }

  default CompletableFuture<String> getAriaRowIndex() {
    return getProperty("ariaRowIndex", String.class);
  }

  default CompletableFuture<Void> setAriaRowIndex(final String ariaRowIndex) {
    return setProperty("ariaRowIndex", ariaRowIndex);
  }

  default CompletableFuture<String> getAriaRowSpan() {
    return getProperty("ariaRowSpan", String.class);
  }

  default CompletableFuture<Void> setAriaRowSpan(final String ariaRowSpan) {
    return setProperty("ariaRowSpan", ariaRowSpan);
  }

  default CompletableFuture<String> getAriaSelected() {
    return getProperty("ariaSelected", String.class);
  }

  default CompletableFuture<Void> setAriaSelected(final String ariaSelected) {
    return setProperty("ariaSelected", ariaSelected);
  }

  default CompletableFuture<String> getAriaSetSize() {
    return getProperty("ariaSetSize", String.class);
  }

  default CompletableFuture<Void> setAriaSetSize(final String ariaSetSize) {
    return setProperty("ariaSetSize", ariaSetSize);
  }

  default CompletableFuture<String> getAriaSort() {
    return getProperty("ariaSort", String.class);
  }

  default CompletableFuture<Void> setAriaSort(final String ariaSort) {
    return setProperty("ariaSort", ariaSort);
  }

  default CompletableFuture<String> getAriaValueMax() {
    return getProperty("ariaValueMax", String.class);
  }

  default CompletableFuture<Void> setAriaValueMax(final String ariaValueMax) {
    return setProperty("ariaValueMax", ariaValueMax);
  }

  default CompletableFuture<String> getAriaValueMin() {
    return getProperty("ariaValueMin", String.class);
  }

  default CompletableFuture<Void> setAriaValueMin(final String ariaValueMin) {
    return setProperty("ariaValueMin", ariaValueMin);
  }

  default CompletableFuture<String> getAriaValueNow() {
    return getProperty("ariaValueNow", String.class);
  }

  default CompletableFuture<Void> setAriaValueNow(final String ariaValueNow) {
    return setProperty("ariaValueNow", ariaValueNow);
  }

  default CompletableFuture<String> getAriaValueText() {
    return getProperty("ariaValueText", String.class);
  }

  default CompletableFuture<Void> setAriaValueText(final String ariaValueText) {
    return setProperty("ariaValueText", ariaValueText);
  }

}
