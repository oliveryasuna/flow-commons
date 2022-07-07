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

package com.oliveryasuna.vaadin.commons.component.tabs;

import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.tabs.TabsVariant;

/**
 * Ease-of-use for components with {@link TabsVariant}s.
 *
 * @author Oliver Yasuna
 * @since 3.0.0
 */
public interface HasTabsVariants extends HasTheme {

  // Methods
  //--------------------------------------------------

  default boolean isLumoIconOnTop() {
    return getThemeNames().contains(TabsVariant.LUMO_ICON_ON_TOP.getVariantName());
  }

  default void setLumoIconOnTop(final boolean lumoIconOnTop) {
    getThemeNames().set(TabsVariant.LUMO_ICON_ON_TOP.getVariantName(), lumoIconOnTop);
  }

  default boolean isLumoCentered() {
    return getThemeNames().contains(TabsVariant.LUMO_CENTERED.getVariantName());
  }

  default void setLumoCentered(final boolean lumoCentered) {
    getThemeNames().set(TabsVariant.LUMO_CENTERED.getVariantName(), lumoCentered);
  }

  default boolean isLumoMinimal() {
    return getThemeNames().contains(TabsVariant.LUMO_MINIMAL.getVariantName());
  }

  default void setLumoMinimal(final boolean lumoMinimal) {
    getThemeNames().set(TabsVariant.LUMO_MINIMAL.getVariantName(), lumoMinimal);
  }

  default boolean isLumoHideScrollButtons() {
    return getThemeNames().contains(TabsVariant.LUMO_HIDE_SCROLL_BUTTONS.getVariantName());
  }

  default void setLumoHideScrollButtons(final boolean lumoHideScrollButtons) {
    getThemeNames().set(TabsVariant.LUMO_HIDE_SCROLL_BUTTONS.getVariantName(), lumoHideScrollButtons);
  }

  default boolean isLumoEqualWidthTabs() {
    return getThemeNames().contains(TabsVariant.LUMO_EQUAL_WIDTH_TABS.getVariantName());
  }

  default void setLumoEqualWidthTabs(final boolean lumoEqualWidthTabs) {
    getThemeNames().set(TabsVariant.LUMO_EQUAL_WIDTH_TABS.getVariantName(), lumoEqualWidthTabs);
  }

  default boolean isMaterialFixed() {
    return getThemeNames().contains(TabsVariant.MATERIAL_FIXED.getVariantName());
  }

  default void setMaterialFixed(final boolean materialFixed) {
    getThemeNames().set(TabsVariant.MATERIAL_FIXED.getVariantName(), materialFixed);
  }

}
