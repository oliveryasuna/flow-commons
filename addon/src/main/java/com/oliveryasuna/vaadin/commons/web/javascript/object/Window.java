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

  /**
   * The name of the global object.
   */
  static final String NAME = "window";

  /**
   * The name of the global self object.
   */
  static final String SELF_NAME = "self";

  /**
   * The name of the global top object.
   */
  static final String TOP_NAME = "top";

  /**
   * The name of the global window object.
   */
  static final String WINDOW_NAME = "window";

  // Singleton
  //--------------------------------------------------

  /**
   * The instance associated with the global object.
   */
  private static Window instance;

  public static Window getInstance() {
    return (instance != null ? instance : (instance = new Window(NAME)));
  }

  /**
   * The instance associated with the global self object.
   */
  private static Window selfInstance;

  public static Window getSelfInstance() {
    return (selfInstance != null ? selfInstance : (selfInstance = new Window(SELF_NAME)));
  }

  /**
   * The instance associated with the global top object.
   */
  private static Window topInstance;

  public static Window getTopInstance() {
    return (topInstance != null ? topInstance : (topInstance = new Window(TOP_NAME)));
  }

  /**
   * The instance associated with the global window object.
   */
  private static Window windowInstance;

  public static Window getWindowInstance() {
    return (windowInstance != null ? windowInstance : (windowInstance = new Window(WINDOW_NAME)));
  }

  // Constructors
  //--------------------------------------------------

  /**
   * Creates an instance specifying the name of the object.
   *
   * @param name The name of the object.
   */
  protected Window(final String name) {
    super(name);
  }

  /**
   * Creates an instance specifying the parent object and the name of this object.
   *
   * @param parent The parent object.
   * @param name   The name of this object.
   */
  Window(final NamedJavaScriptObject parent, final String name) {
    super(parent.getObjectName() + "." + name);
  }

  // Fields
  //--------------------------------------------------

  /**
   * The stored instance of the object representing the {@code console} property.
   */
  protected Console console;

  /**
   * The stored instance of the object representing the {@code document} property.
   */
  protected Document document;

  /**
   * The stored instance of the object representing the {@code history} property.
   */
  protected History history;

  /**
   * The stored instance of the object representing the {@code navigator} property.
   */
  protected Navigator navigator;

  /**
   * The stored instance of the object representing the {@code self} property.
   */
  protected Window self;

  /**
   * The stored instance of the object representing the {@code top} property.
   */
  protected Window top;

  /**
   * The stored instance of the object representing the {@code window} property.
   */
  protected Window window;

  /**
   * The stored instance of the object representing the {@code localStorage} property.
   */
  protected Storage localStorage;

  /**
   * The stored instance of the object representing the {@code sessionStorage} property.
   */
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
