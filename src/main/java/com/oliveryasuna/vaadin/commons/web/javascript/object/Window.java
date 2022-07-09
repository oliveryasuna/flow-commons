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

import com.oliveryasuna.commons.language.marker.Singleton;

/**
 * Represents a {@code Window} object.
 *
 * @author Oliver Yasuna
 * @since 4.0.0
 */
@Singleton
public class Window extends NamedJavaScriptObject implements IWindow {

  // Static fields
  //--------------------------------------------------

  static final String NAME = "window";

  static final String SELF_NAME = "self";

  static final String TOP_NAME = "top";

  static final String WINDOW_NAME = "window";

  // Singleton
  //--------------------------------------------------

  private static Window instance;

  public static Window getInstance() {
    return (instance != null ? instance : (instance = new Window(NAME)));
  }

  private static Window selfInstance;

  public static Window getSelfInstance() {
    return (selfInstance != null ? selfInstance : (selfInstance = new Window(SELF_NAME)));
  }

  private static Window topInstance;

  public static Window getTopInstance() {
    return (topInstance != null ? topInstance : (topInstance = new Window(TOP_NAME)));
  }

  private static Window windowInstance;

  public static Window getWindowInstance() {
    return (windowInstance != null ? windowInstance : (windowInstance = new Window(WINDOW_NAME)));
  }

  // Constructors
  //--------------------------------------------------

  protected Window(final String name) {
    super(name);
  }

  Window(final NamedJavaScriptObject parent, final String name) {
    super(parent.getObjectName() + "." + name);
  }

  // Fields
  //--------------------------------------------------

  protected Console console;

  protected Document document;

  protected History history;

  protected Navigator navigator;

  protected Window self;

  protected Window top;

  protected Window window;

  protected Storage localStorage;

  protected Storage sessionStorage;

  // Overrides
  //--------------------------------------------------

  // IWindow
  //

  @Override
  public Console getConsole() {
    return (console != null ? console : (console = new Console(this, Console.NAME)));
  }

  @Override
  public Document getDocument() {
    return (document != null ? document : (document = new Document(this, Document.NAME)));
  }

  @Override
  public History getHistory() {
    return (history != null ? history : (history = new History(this, History.NAME)));
  }

  @Override
  public Navigator getNavigator() {
    return (navigator != null ? navigator : (navigator = new Navigator(this, Navigator.NAME)));
  }

  @Override
  public Window getSelf() {
    return (self != null ? self : (self = new Window(this, SELF_NAME)));
  }

  @Override
  public Window getTop() {
    return (top != null ? top : (top = new Window(this, TOP_NAME)));
  }

  @Override
  public Window getWindow() {
    return (window != null ? window : (window = new Window(this, WINDOW_NAME)));
  }

  // WindowLocalStorage
  //

  @Override
  public Storage getLocalStorage() {
    return (localStorage != null ? localStorage : (localStorage = new Storage(this, Storage.LOCAL_STORAGE_NAME)));
  }

  // WindowSessionStorage
  //

  @Override
  public Storage getSessionStorage() {
    return (sessionStorage != null ? sessionStorage : (sessionStorage = new Storage(this, Storage.SESSION_STORAGE_NAME)));
  }

}
