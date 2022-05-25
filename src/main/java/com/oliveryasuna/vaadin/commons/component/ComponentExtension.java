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

/**
 * An interface to add functionality to {@link Component}s.
 *
 * @author Oliver Yasuna
 */
public interface ComponentExtension {

  /**
   * Fires an event.
   *
   * @param event The event.
   */
  default void fireEvent(final ComponentEvent<?> event) {
    Arguments.requireNotNull(event);

    ComponentUtil.fireEvent((Component)this, event);
  }

  /**
   * Removes this component from its parent, if it has a parent and that parent implements {@link HasComponents}.
   *
   * @return {@code true}, if it was assumed to be removed.
   *     {@code false}, if this has no parent or its parent does not have children.
   */
  default boolean removeFromParent() {
    final Optional<Component> parentOptional = ((Component)this).getParent();

    if(parentOptional.isEmpty() || !(parentOptional.get() instanceof HasComponents)) return false;

    ((HasComponents)parentOptional.get()).remove((Component)this);

    return true;
  }

  /**
   * Inserts a sibling before this component, if it has a parent and that parent implements {@link HasOrderedComponents}.
   *
   * @param newSibling The new component.
   *
   * @return {@code true}, if it was assumed that the new component was added to this component's parent.
   *     {@code false}, if this component has no parent or its parent does not have ordered children.
   */
  default boolean insertBefore(final Component newSibling) {
    Arguments.requireNotNull(newSibling);

    final Optional<Component> parentOptional = ((Component)this).getParent();

    if(parentOptional.isEmpty() || !(parentOptional.get() instanceof HasOrderedComponents)) return false;

    final HasOrderedComponents parent = (HasOrderedComponents)parentOptional.get();

    parent.addComponentAtIndex(parent.indexOf((Component)this), newSibling);

    return true;
  }

  /**
   * Inserts a sibling after this component, if it has a parent and that parent implements {@link HasOrderedComponents}.
   *
   * @param newSibling The new component.
   *
   * @return {@code true}, if it was assumed that the new component was added to this component's parent.
   *     {@code false}, if this component has no parent or its parent does not have ordered children.
   */
  default boolean insertAfter(final Component newSibling) {
    Arguments.requireNotNull(newSibling);

    final Optional<Component> parentOptional = ((Component)this).getParent();

    if(parentOptional.isEmpty() || !(parentOptional.get() instanceof HasOrderedComponents)) return false;

    final HasOrderedComponents parent = (HasOrderedComponents)parentOptional.get();

    parent.addComponentAtIndex(parent.indexOf((Component)this) + 1, newSibling);

    return true;
  }

}
