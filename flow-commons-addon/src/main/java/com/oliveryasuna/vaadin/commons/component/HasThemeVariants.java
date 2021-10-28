package com.oliveryasuna.vaadin.commons.component;

import com.vaadin.flow.component.HasTheme;

import java.util.Arrays;

public interface HasThemeVariants<V extends Enum<V> & ThemeVariant> extends HasTheme {

  default void addThemeVariants(final V... variants) {
    Arrays.stream(variants).map(ThemeVariant::getVariantName).forEachOrdered(getThemeNames()::add);
  }

  default void removeThemVariants(final V... variants) {
    Arrays.stream(variants).map(ThemeVariant::getVariantName).forEachOrdered(getThemeNames()::remove);
  }

}
