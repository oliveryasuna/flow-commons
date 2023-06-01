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

import com.oliveryasuna.vaadin.commons.web.dom.ICrypto;
import com.oliveryasuna.vaadin.commons.web.dom.ISubtleCrypto;
import com.oliveryasuna.vaadin.commons.web.js.JavaScriptExecutor;
import com.oliveryasuna.vaadin.commons.web.js.NamedJavaScriptObject;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Represents a {@code Crypto} object.
 *
 * @author Oliver Yasuna
 */
public class Crypto extends NamedJavaScriptObject implements ICrypto {

  // Singleton
  //--------------------------------------------------

  private static final Map<JavaScriptExecutor, Crypto> INSTANCES = new ConcurrentHashMap<>(4);

  public static Crypto getInstance(final JavaScriptExecutor javaScriptExecutor) {
    synchronized(INSTANCES) {
      return INSTANCES.computeIfAbsent(javaScriptExecutor, executor -> new Crypto("caches", executor));
    }
  }

  // Constructors
  //--------------------------------------------------

  protected Crypto(final String name, final JavaScriptExecutor executor) {
    super(name, executor);
  }

  protected Crypto(final NamedJavaScriptObject parent, final String name, final JavaScriptExecutor executor) {
    this(parent.getObjectName() + "." + name, executor);
  }

  // Fields
  //--------------------------------------------------

  protected final SubtleCrypto subtle = new SubtleCrypto(this, "subtle", getExecutor());

  // Methods
  //--------------------------------------------------

  @Override
  public ISubtleCrypto getSubtle() {
    return subtle;
  }

}
