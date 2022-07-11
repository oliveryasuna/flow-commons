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

package com.oliveryasuna.vaadin.commons.component.badge;

import com.oliveryasuna.vaadin.commons.component.theme.HasThemeVariants;

/**
 * Ease-of-use for components with {@link BadgeVariant}s.
 *
 * @author Oliver Yasuna
 * @since 3.0.0
 */
public interface HasBadgeVariants extends HasThemeVariants<BadgeVariant> {

  // Methods
  //--------------------------------------------------

  default boolean isSmall() {
    return getThemeNames().contains(BadgeVariant.SMALL.getVariantName());
  }

  default void setSmall(final boolean small) {
    getThemeNames().set(BadgeVariant.SMALL.getVariantName(), small);
  }

  default boolean isPrimary() {
    return getThemeNames().contains(BadgeVariant.PRIMARY.getVariantName());
  }

  default void setPrimary(final boolean primary) {
    getThemeNames().set(BadgeVariant.PRIMARY.getVariantName(), primary);
  }

  default boolean isSuccess() {
    return getThemeNames().contains(BadgeVariant.SUCCESS.getVariantName());
  }

  default void setSuccess(final boolean success) {
    getThemeNames().set(BadgeVariant.SUCCESS.getVariantName(), success);
  }

  default boolean isError() {
    return getThemeNames().contains(BadgeVariant.ERROR.getVariantName());
  }

  default void setError(final boolean error) {
    getThemeNames().set(BadgeVariant.ERROR.getVariantName(), error);
  }

  default boolean isContrast() {
    return getThemeNames().contains(BadgeVariant.CONTRAST.getVariantName());
  }

  default void setContrast(final boolean contrast) {
    getThemeNames().set(BadgeVariant.CONTRAST.getVariantName(), contrast);
  }

  default boolean isPill() {
    return getThemeNames().contains(BadgeVariant.PILL.getVariantName());
  }

  default void setPill(final boolean pill) {
    getThemeNames().set(BadgeVariant.PILL.getVariantName(), pill);
  }

}
