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
 * Represents a {@code Console} object.
 *
 * @author Oliver Yasuna
 * @since 4.0.0
 */
@Singleton
public class Console extends NamedJavaScriptObject implements IConsole {

  // Static fields
  //--------------------------------------------------

  /**
   * The name of the global object.
   */
  static final String NAME = "console";

  // Singleton
  //--------------------------------------------------

  /**
   * The instance associated with the global object.
   */
  private static Console instance;

  public static Console getInstance() {
    return (instance != null ? instance : (instance = new Console(NAME)));
  }

  // Constructors
  //--------------------------------------------------

  /**
   * Creates an instance specifying the name of the object.
   *
   * @param name The name of the object.
   */
  protected Console(final String name) {
    super(name);
  }

  /**
   * Creates an instance specifying the parent object and the name of this object.
   *
   * @param parent The parent object.
   * @param name   The name of this object.
   */
  Console(final NamedJavaScriptObject parent, final String name) {
    super(parent.getObjectName() + "." + name);
  }

}
