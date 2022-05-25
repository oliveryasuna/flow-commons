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

package com.oliveryasuna.vaadin.commons.element;

import com.oliveryasuna.commons.language.condition.Arguments;
import com.oliveryasuna.commons.language.exception.UnsupportedInstantiationException;
import com.oliveryasuna.commons.language.marker.Utility;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.server.AbstractStreamResource;
import elemental.json.JsonValue;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Various utilities for working with {@link Element}s.
 *
 * @author Oliver Yasuna
 */
@Utility
public final class ElementUtils {

  // Static utility methods
  //--------------------------------------------------

  // Children
  //

  /**
   * Gets slotted children.
   *
   * @param element  The parent element.
   * @param slotName The name of the slot. If {@code null}, all children are returned.
   *
   * @return A stream of matched elements.
   */
  public static Stream<Element> getSlotted(final Element element, final String slotName) {
    Arguments.requireNotNull(element);

    return element.getChildren()
        .filter(child -> slotName == null || slotName.equals(child.getAttribute("slot")));
  }

  /**
   * Removes all slotted elements in a specific slot.
   *
   * @param element  The parent element.
   * @param slotName The name of the slot. Per {@link #getSlotted(Element, String)}, if {@code null}, all children are removed.
   */
  public static void clearSlot(final Element element, final String slotName) {
    getSlotted(element, slotName)
        .forEach(element::removeChild);
  }

  // Attributes
  //

  /**
   * Sets or removes an elements {@link String} attribute.
   *
   * @param element The element.
   * @param name    The name of the attribute.
   * @param value   The value of the attribute. {@code null} removes the attribute.
   *
   * @return The element.
   */
  public static Element setAttribute(final Element element, final String name, final String value) {
    Arguments.requireNotNull(element);
    Arguments.requireNotNull(name);

    return (value != null ? element.setAttribute(name, value) : element.removeAttribute(name));
  }

  /**
   * Sets or removes an elements {@code boolean} attribute.
   *
   * @param element The element.
   * @param name    The name of the attribute.
   * @param value   The value of the attribute. {@code null} removes the attribute.
   *
   * @return The element.
   */
  public static Element setAttribute(final Element element, final String name, final Boolean value) {
    Arguments.requireNotNull(element);
    Arguments.requireNotNull(name);

    return (value != null ? element.setAttribute(name, value) : element.removeAttribute(name));
  }

  /**
   * Sets or removes an elements {@link AbstractStreamResource} attribute.
   *
   * @param element The element.
   * @param name    The name of the attribute.
   * @param value   The value of the attribute. {@code null} removes the attribute.
   *
   * @return The element.
   */
  public static Element setAttribute(final Element element, final String name, final AbstractStreamResource value) {
    Arguments.requireNotNull(element);
    Arguments.requireNotNull(name);

    return (value != null ? element.setAttribute(name, value) : element.removeAttribute(name));
  }

  /**
   * Sets or removes an elements {@link String} property.
   *
   * @param element The element.
   * @param name    The name of the property.
   * @param value   The value of the property. {@code null} removes the property.
   *
   * @return The element.
   */
  public static Element setProperty(final Element element, final String name, final String value) {
    Arguments.requireNotNull(element);
    Arguments.requireNotNull(name);

    return (value != null ? element.setProperty(name, value) : element.removeProperty(name));
  }

  // Properties
  //

  /**
   * Sets or removes an elements {@code boolean} property.
   *
   * @param element The element.
   * @param name    The name of the property.
   * @param value   The value of the property. {@code null} removes the property.
   *
   * @return The element.
   */
  public static Element setProperty(final Element element, final String name, final Boolean value) {
    Arguments.requireNotNull(element);
    Arguments.requireNotNull(name);

    return (value != null ? element.setProperty(name, value) : element.removeProperty(name));
  }

  /**
   * Sets or removes an elements {@code double} property.
   *
   * @param element The element.
   * @param name    The name of the property.
   * @param value   The value of the property. {@code null} removes the property.
   *
   * @return The element.
   */
  public static Element setProperty(final Element element, final String name, final Double value) {
    Arguments.requireNotNull(element);
    Arguments.requireNotNull(name);

    return (value != null ? element.setProperty(name, value) : element.removeProperty(name));
  }

  /**
   * Sets or removes an elements {@link JsonValue} property.
   *
   * @param element The element.
   * @param name    The name of the property.
   * @param value   The value of the property. {@code null} removes the property.
   *
   * @return The element.
   */
  public static Element setPropertyJson(final Element element, final String name, final JsonValue value) {
    Arguments.requireNotNull(element);
    Arguments.requireNotNull(name);

    return (value != null ? element.setPropertyJson(name, value) : element.removeProperty(name));
  }

  /**
   * Alias for {@link #setPropertyJson(Element, String, JsonValue)}.
   */
  public static Element setProperty(final Element element, final String name, final JsonValue value) {
    return setPropertyJson(element, name, value);
  }

  /**
   * Sets or removes an elements {@link Object} property.
   *
   * @param element The element.
   * @param name    The name of the property.
   * @param value   The value of the property. {@code null} removes the property.
   *
   * @return The element.
   */
  public static Element setPropertyBean(final Element element, final String name, final Object value) {
    Arguments.requireNotNull(element);
    Arguments.requireNotNull(name);

    return (value != null ? element.setPropertyBean(name, value) : element.removeProperty(name));
  }

  /**
   * Alias for {@link #setPropertyBean(Element, String, Object)}.
   */
  public static Element setProperty(final Element element, final String name, final Object value) {
    return setPropertyBean(element, name, value);
  }

  /**
   * Sets or removes an elements {@link List} property.
   *
   * @param element The element.
   * @param name    The name of the property.
   * @param value   The value of the property. {@code null} removes the property.
   *
   * @return The element.
   */
  public static <T> Element setPropertyList(final Element element, final String name, final List<T> value) {
    Arguments.requireNotNull(element);
    Arguments.requireNotNull(name);

    return (value != null ? element.setPropertyList(name, value) : element.removeProperty(name));
  }

  /**
   * Alias for {@link #setPropertyList(Element, String, List)}.
   */
  public static <T> Element setProperty(final Element element, final String name, final List<T> value) {
    return setPropertyList(element, name, value);
  }

  /**
   * Sets or removes an elements {@link Map} property.
   *
   * @param element The element.
   * @param name    The name of the property.
   * @param value   The value of the property. {@code null} removes the property.
   *
   * @return The element.
   */
  public static Element setPropertyMap(final Element element, final String name, final Map<String, ?> value) {
    Arguments.requireNotNull(element);
    Arguments.requireNotNull(name);

    return (value != null ? element.setPropertyMap(name, value) : element.removeProperty(name));
  }

  /**
   * Alias for {@link #setPropertyMap(Element, String, Map)}.
   */
  public static Element setProperty(final Element element, final String name, final Map<String, ?> value) {
    return setPropertyMap(element, name, value);
  }

  // Constructors
  //--------------------------------------------------

  private ElementUtils() {
    super();

    throw new UnsupportedInstantiationException();
  }

}
