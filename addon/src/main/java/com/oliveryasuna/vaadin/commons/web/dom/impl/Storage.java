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

package com.oliveryasuna.vaadin.commons.web.dom.impl;

import com.oliveryasuna.vaadin.commons.web.dom.IStorage;
import com.oliveryasuna.vaadin.commons.web.js.JavaScriptExecutor;
import com.oliveryasuna.vaadin.commons.web.js.NamedJavaScriptObject;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Represents a {@code Storage} object.
 *
 * @author Oliver Yasuna
 */
public class Storage extends NamedJavaScriptObject implements IStorage {

  // Static fields
  //--------------------------------------------------

  protected static final String LOCAL_STORAGE_NAME = "localStorage";

  protected static final String SESSION_STORAGE_NAME = "sessionStorage";

  // Singleton
  //--------------------------------------------------

  private static final Map<JavaScriptExecutor, Storage> LOCAL_STORAGE_INSTANCES = new ConcurrentHashMap<>(4);

  public static Storage getLocalStorageInstance(final JavaScriptExecutor javaScriptExecutor) {
    synchronized(LOCAL_STORAGE_INSTANCES) {
      return LOCAL_STORAGE_INSTANCES.computeIfAbsent(javaScriptExecutor, executor -> new Storage(LOCAL_STORAGE_NAME, executor));
    }
  }

  private static final Map<JavaScriptExecutor, Storage> SESSION_STORAGE_INSTANCES = new ConcurrentHashMap<>(4);

  public static Storage getSessionStorageInstance(final JavaScriptExecutor javaScriptExecutor) {
    synchronized(SESSION_STORAGE_INSTANCES) {
      return SESSION_STORAGE_INSTANCES.computeIfAbsent(javaScriptExecutor, executor -> new Storage(SESSION_STORAGE_NAME, executor));
    }
  }

  // Constructors
  //--------------------------------------------------

  protected Storage(final String name, final JavaScriptExecutor executor) {
    super(name, executor);
  }

  protected Storage(final NamedJavaScriptObject parent, final String name, final JavaScriptExecutor executor) {
    this(parent.getObjectName() + "." + name, executor);
  }

}
