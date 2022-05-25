/*
 * Copyright 2021 Oliver Yasuna
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

package com.oliveryasuna.vaadin.commons.server;

import com.oliveryasuna.commons.language.exception.UnsupportedInstantiationException;
import com.oliveryasuna.commons.language.marker.Utility;
import com.vaadin.flow.server.StreamResource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Various {@link StreamResource} utilities.
 *
 * @author Oliver Yasuna
 */
@Utility
public final class StreamResourceUtils {

  // Static utility methods
  //--------------------------------------------------

  /**
   * Creates a new {@link StreamResource} from an {@link InputStream}.
   *
   * @param filename    The resource's filename.
   * @param inputStream The input stream.
   *
   * @return A new {@link StreamResource}.
   */
  public static StreamResource fromInputStream(final String filename, final InputStream inputStream) {
    return new StreamResource(filename, () -> inputStream);
  }

  /**
   * Creates a new {@link StreamResource} from an array of {@code byte}s.
   *
   * @param filename The resource's filename.
   * @param bytes    The input bytes.
   *
   * @return A new {@link StreamResource}.
   */
  public static StreamResource fromBytes(final String filename, final byte[] bytes) {
    return fromInputStream(filename, new ByteArrayInputStream(bytes));
  }

  /**
   * Creates a new {@link StreamResource} from a string.
   *
   * @param filename The resource's filename.
   * @param string   The input string.
   * @param charset  The input character set.
   *
   * @return A new {@link StreamResource}.
   */
  public static StreamResource fromString(final String filename, final String string, final Charset charset) {
    return fromBytes(filename, string.getBytes(charset));
  }

  // Constructors
  //--------------------------------------------------

  private StreamResourceUtils() {
    super();

    throw new UnsupportedInstantiationException();
  }

}
