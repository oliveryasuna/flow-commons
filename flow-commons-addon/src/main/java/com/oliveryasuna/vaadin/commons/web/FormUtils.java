package com.oliveryasuna.vaadin.commons.web;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.UI;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.AbstractMap;
import java.util.stream.Collectors;

/**
 * Various HTML form utilities.
 *
 * @author Oliver Yasuna
 */
public final class FormUtils {

  private static final String SUBMIT_GET_JS_FORMAT = "" +
      "fetch('%s', {" +
      "  method: 'get'," +
      "  headers: {" +
      "    'Content-Type': 'application/x-www-form-urlencoded'" +
      "  }," +
      "  redirect: 'follow'," +
      "})" +
      "  .then(response => {" +
      "    if(response.redirected) {" +
      "      window.location.href = response.url;" +
      "    }" +
      "  });;";

  private static final String SUBMIT_POST_JS_FORMAT = "" +
      "fetch('%s', {" +
      "  method: 'post'," +
      "  headers: {" +
      "    'Content-Type': 'application/x-www-form-urlencoded'" +
      "  }," +
      "  redirect: 'follow'," +
      "  body: '%s'" +
      "})" +
      "  .then(response => {" +
      "    if(response.redirected) {" +
      "      window.location.href = response.url;" +
      "    }" +
      "  });;";

  /**
   * Simulates HTML form submission.
   *
   * @param component The component representing an HTML form.
   * @param action    The action.
   * @param method    The method ({@code get} or {@code post}).
   * @param charset   The charset.
   */
  public static void submit(final Component component, final String action, final String method, final Charset charset) {
    if(component == null) throw new IllegalArgumentException("Requires a component.");
    if(action == null) throw new IllegalArgumentException("Requires an action.");
    if(method == null) throw new IllegalArgumentException("Requires a method.");

    final String formData = serialize(component, charset);

    if(method.equalsIgnoreCase("get")) {
      UI.getCurrent().getPage().executeJs(String.format(SUBMIT_GET_JS_FORMAT, action + "?" + formData));
    } else if(method.equalsIgnoreCase("post")) {
      UI.getCurrent().getPage().executeJs(String.format(SUBMIT_POST_JS_FORMAT, action, formData));
    } else {
      throw new IllegalArgumentException("Unsupported method.");
    }
  }

  /**
   * Serializes a component's children into a string concatenation representing {@code FormData}.
   *
   * @param component The component.
   * @param charset   The charset.
   * @return String representation of {@code FormData}.
   */
  public static String serialize(final Component component, final Charset charset) {
    if(component == null) throw new IllegalArgumentException("Requires a component.");

    final Charset charset_ = charset != null ? charset : Charset.defaultCharset();

    return component.getChildren()
        // Must have a value.
        .filter(child -> child instanceof HasValue)
        // Must have a "name" attribute.
        .filter(child -> child.getElement().hasAttribute("name"))
        // Map to entries that are URL encoded.
        .map(child -> {
          try {
            return new AbstractMap.SimpleImmutableEntry<>(
                URLEncoder.encode(child.getElement().getAttribute("name"), charset_.name()),
                URLEncoder.encode(((HasValue<?, ?>)child).getValue().toString(), charset_.name())
            );
          } catch(final UnsupportedEncodingException e) {
            throw new IllegalStateException("Cannot continue.");
          }
        })
        // Concatenate.
        .map(parameter -> parameter.getKey() + "=" + parameter.getValue())
        // Collect.
        .collect(Collectors.joining("&"));
  }

  private FormUtils() {
    throw new UnsupportedOperationException("Class cannot be instantiated.");
  }

}
