package com.oliveryasuna.vaadin.commons.data;

import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;
import org.apache.commons.lang3.StringUtils;

/**
 * A converter that strips strings to null for the model and empty-for-null in the presentation.
 * <p>
 * Be aware that values converted back-and-forth may lose data.
 *
 * @author Oliver Yasuna
 */
public final class StripToNullConverter implements Converter<String, String> {

  /**
   * Strips strings to null.
   *
   * @param value   The presentation value.
   * @param context The context.
   * @return See {@link StringUtils#stripToNull(String)}.
   */
  @Override
  public final Result<String> convertToModel(final String value, final ValueContext context) {
    return Result.ok(StringUtils.stripToNull(value));
  }

  /**
   * Uses an empty string for null values.
   *
   * @param value   The model value.
   * @param context The context.
   * @return See {@link StringUtils#defaultString(String)}.
   */
  @Override
  public final String convertToPresentation(final String value, final ValueContext context) {
    return (StringUtils.defaultString(value));
  }

}
