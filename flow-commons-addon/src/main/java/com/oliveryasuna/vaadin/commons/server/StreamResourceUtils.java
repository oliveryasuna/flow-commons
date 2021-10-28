package com.oliveryasuna.vaadin.commons.server;

import com.vaadin.flow.server.StreamResource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Various {@link StreamResource} utilities.
 *
 * @author Oliver Yasuna
 */
public final class StreamResourceUtils {

  /**
   * Creates a new {@link StreamResource} from an {@link InputStream}.
   *
   * @param filename    The resource's filename.
   * @param inputStream The input stream.
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
   * @return A new {@link StreamResource}.
   */
  public static StreamResource fromString(final String filename, final String string, final Charset charset) {
    return fromBytes(filename, string.getBytes(charset));
  }

  private StreamResourceUtils() {
    throw new UnsupportedOperationException("Class cannot be instantiated.");
  }

}
