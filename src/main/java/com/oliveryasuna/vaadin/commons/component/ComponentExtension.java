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

package com.oliveryasuna.vaadin.commons.component;

import com.oliveryasuna.commons.language.condition.Arguments;
import com.vaadin.flow.component.*;

import java.util.Optional;

public interface ComponentExtension {

  default void fireEvent(final ComponentEvent<?> event) {
    Arguments.requireNotNull(event);

    ComponentUtil.fireEvent((Component)this, event);
  }

  default boolean removeFromParent() {
    final Optional<Component> parentOptional = ((Component)this).getParent();

    if(parentOptional.isEmpty()) return false;

    ((HasComponents)parentOptional.get()).remove((Component)this);

    return true;
  }

  default boolean insertBefore(final Component newSibling) {
    Arguments.requireNotNull(newSibling);

    final Optional<Component> parentOptional = ((Component)this).getParent();

    if(parentOptional.isEmpty() || !(parentOptional.get() instanceof HasOrderedComponents)) return false;

    final HasOrderedComponents parent = (HasOrderedComponents)parentOptional.get();

    parent.addComponentAtIndex(parent.indexOf((Component)this), newSibling);

    return true;
  }

  default boolean insertAfter(final Component newSibling) {
    Arguments.requireNotNull(newSibling);

    final Optional<Component> parentOptional = ((Component)this).getParent();

    if(parentOptional.isEmpty() || !(parentOptional.get() instanceof HasOrderedComponents)) return false;

    final HasOrderedComponents parent = (HasOrderedComponents)parentOptional.get();

    parent.addComponentAtIndex(parent.indexOf((Component)this) + 1, newSibling);

    return true;
  }

}
