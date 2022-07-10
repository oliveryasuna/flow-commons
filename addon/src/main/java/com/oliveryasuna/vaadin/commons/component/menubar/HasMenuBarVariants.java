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

package com.oliveryasuna.vaadin.commons.component.menubar;

import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.menubar.MenuBarVariant;

/**
 * Ease-of-use for components with {@link MenuBarVariant}s.
 *
 * @author Oliver Yasuna
 * @since 3.0.0
 */
public interface HasMenuBarVariants extends HasTheme {

  // Methods
  //--------------------------------------------------

  default boolean isLumoSmall() {
    return getThemeNames().contains(MenuBarVariant.LUMO_SMALL.getVariantName());
  }

  default void setLumoSmall(final boolean lumoSmall) {
    getThemeNames().set(MenuBarVariant.LUMO_SMALL.getVariantName(), lumoSmall);
  }

  default boolean isLumoLarge() {
    return getThemeNames().contains(MenuBarVariant.LUMO_LARGE.getVariantName());
  }

  default void setLumoLarge(final boolean lumoLarge) {
    getThemeNames().set(MenuBarVariant.LUMO_LARGE.getVariantName(), lumoLarge);
  }

  default boolean isLumoTertiary() {
    return getThemeNames().contains(MenuBarVariant.LUMO_TERTIARY.getVariantName());
  }

  default void setLumoTertiary(final boolean lumoTertiary) {
    getThemeNames().set(MenuBarVariant.LUMO_TERTIARY.getVariantName(), lumoTertiary);
  }

  default boolean isLumoTertiaryInline() {
    return getThemeNames().contains(MenuBarVariant.LUMO_TERTIARY_INLINE.getVariantName());
  }

  default void setLumoTertiaryInline(final boolean lumoTertiaryInline) {
    getThemeNames().set(MenuBarVariant.LUMO_TERTIARY_INLINE.getVariantName(), lumoTertiaryInline);
  }

  default boolean isLumoPrimary() {
    return getThemeNames().contains(MenuBarVariant.LUMO_PRIMARY.getVariantName());
  }

  default void setLumoPrimary(final boolean lumoPrimary) {
    getThemeNames().set(MenuBarVariant.LUMO_PRIMARY.getVariantName(), lumoPrimary);
  }

  default boolean isLumoContrast() {
    return getThemeNames().contains(MenuBarVariant.LUMO_CONTRAST.getVariantName());
  }

  default void setLumoContrast(final boolean lumoContrast) {
    getThemeNames().set(MenuBarVariant.LUMO_CONTRAST.getVariantName(), lumoContrast);
  }

  default boolean isLumoIcon() {
    return getThemeNames().contains(MenuBarVariant.LUMO_ICON.getVariantName());
  }

  default void setLumoIcon(final boolean lumoIcon) {
    getThemeNames().set(MenuBarVariant.LUMO_ICON.getVariantName(), lumoIcon);
  }

  default boolean isMaterialContained() {
    return getThemeNames().contains(MenuBarVariant.MATERIAL_CONTAINED.getVariantName());
  }

  default void setMaterialContained(final boolean materialContained) {
    getThemeNames().set(MenuBarVariant.MATERIAL_CONTAINED.getVariantName(), materialContained);
  }

  default boolean isMaterialOutlined() {
    return getThemeNames().contains(MenuBarVariant.MATERIAL_OUTLINED.getVariantName());
  }

  default void setMaterialOutlined(final boolean materialOutlined) {
    getThemeNames().set(MenuBarVariant.MATERIAL_OUTLINED.getVariantName(), materialOutlined);
  }

}
