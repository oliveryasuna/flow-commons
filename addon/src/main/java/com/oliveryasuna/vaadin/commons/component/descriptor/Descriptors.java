/*
 * Copyright 2023 Oliver Yasuna
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

package com.oliveryasuna.vaadin.commons.component.descriptor;

import com.oliveryasuna.commons.language.condition.Arguments;
import com.oliveryasuna.commons.language.exception.UnsupportedInstantiationException;
import com.oliveryasuna.commons.language.marker.Utility;
import com.vaadin.flow.dom.Element;
import elemental.json.Json;
import elemental.json.JsonValue;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * Arguably better usage of {@link com.vaadin.flow.component.PropertyDescriptor}.
 *
 * @author Oliver Yasuna
 */
@Utility
public final class Descriptors {

  // Static utility methods
  //--------------------------------------------------

  // TODO: Review inconsistent naming of methods.

  /**
   * Creates a {@link Descriptor} for an HTML empty attribute.
   * <p>
   * An empty attribute has no value (or an empty double-quoted value).
   * In a way, it represents a boolean, in that its presence denotes {@code true}, and lack thereof {@code false}.
   * More details can be found <a href="https://html.spec.whatwg.org/multipage/syntax.html#attributes-2">here</a>.
   * <p>
   * Vaadin will always use an empty double-quoted value.
   *
   * @param name The attribute's name.
   *
   * @return A new {@link Descriptor}.
   */
  public static Descriptor<Boolean, Boolean> emptyAttribute(final String name) {
    Arguments.requireNotNull(name);

    return new DescriptorImpl<>(
        name,
        element -> element.hasAttribute(name),
        (element, concrete) -> element.setAttribute(name, concrete),
        element -> element.hasAttribute(name),
        element -> element.removeAttribute(name)
    );
  }

  /**
   * Creates a {@link Descriptor} for an HTML double-quoted attribute.
   * <p>
   * A double-quoted attribute has a value that is a string surrounded by quotes.
   * More details can be found <a href="https://html.spec.whatwg.org/multipage/syntax.html#attributes-2">here</a>.
   *
   * @param name            The attribute's name.
   * @param getterConverter A function that takes the raw attribute value (,which is a string,) and produces a value of type {@code <G>}.
   * @param setterConverter A function that takes a value of type {@code <S>} and produces a raw attribute value (, which is a string).
   * @param <G>             The type used when getting the property's value.
   * @param <S>             The type used when setting the property's value.
   *
   * @return A new {@link Descriptor}.
   */
  public static <G, S> Descriptor<G, S> quotedAttribute(final String name, final Function<String, G> getterConverter,
      final Function<S, String> setterConverter) {
    Arguments.requireNotNull(name);
    Arguments.requireNotNull(getterConverter);
    Arguments.requireNotNull(setterConverter);

    return new DescriptorImpl<>(
        name,
        element -> getterConverter.apply(element.getAttribute(name)),
        (element, concrete) -> element.setAttribute(name, setterConverter.apply(concrete)),
        element -> element.hasAttribute(name),
        element -> element.removeAttribute(name)
    );
  }

  /**
   * Creates a {@link Descriptor} for string containing delimited elements.
   *
   * @param name            The attribute's name.
   * @param delimiter       The element delimiter.
   * @param getterConverter A function that takes the raw attribute value element (,which is a string,) and produces a value of type {@code <G>}.
   * @param setterConverter A function that takes a value of type {@code <S>} and produces a raw attribute value element (, which is a string).
   * @param <G>             The type used when getting the property's value.
   * @param <S>             The type used when setting the property's value.
   * @param generator       A function that produces a new array of the desired type and the provided length.
   *
   * @return A new {@link Descriptor}.
   */
  // TODO: Since the {@code delimiter} argument is passed into {@link String#split(String)} for the getter converter, it can be a pattern, producing unexpected
  //       behavior in the setter converter.
  public static <G, S> Descriptor<G[], S[]> listAttribute(final String name, final String delimiter, final Function<String, G> getterConverter,
      final Function<S, String> setterConverter, final IntFunction<G[]> generator) {
    return quotedAttribute(
        name,
        raw -> {
          final String[] rawList = raw.split(delimiter);
          final G[] concreteList = generator.apply(rawList.length);

          for(int i = 0; i < concreteList.length; i++) {
            concreteList[i] = getterConverter.apply(rawList[i]);
          }

          return concreteList;
        },
        concrete -> Arrays.stream(concrete).map(setterConverter).collect(Collectors.joining(delimiter))
    );
  }

  /**
   * Creates a {@link Descriptor} for a string.
   *
   * @param name The attribute's name.
   *
   * @return A new {@link Descriptor}.
   */
  public static Descriptor<String, String> stringAttribute(final String name) {
    return quotedAttribute(name, raw -> raw, concrete -> concrete);
  }

  public static Descriptor<String[], String[]> stringListAttribute(final String name, final String delimiter) {
    return listAttribute(name, delimiter, raw -> raw, concrete -> concrete, String[]::new);
  }

  public static Descriptor<Boolean, Boolean> booleanProperty(final String name, final boolean defaultValue) {
    Arguments.requireNotNull(name);

    return new DescriptorImpl<>(
        name,
        element -> element.getProperty(name, defaultValue),
        (element, concrete) -> element.setProperty(name, concrete),
        element -> element.hasProperty(name),
        element -> element.removeProperty(name)
    );
  }

  public static Descriptor<Integer, Integer> integerProperty(final String name, final int defaultValue) {
    Arguments.requireNotNull(name);

    return new DescriptorImpl<>(
        name,
        element -> element.getProperty(name, defaultValue),
        (element, concrete) -> element.setProperty(name, concrete),
        element -> element.hasProperty(name),
        element -> element.removeProperty(name)
    );
  }

  public static Descriptor<Double, Double> doubleProperty(final String name, final double defaultValue) {
    Arguments.requireNotNull(name);

    return new DescriptorImpl<>(
        name,
        element -> element.getProperty(name, defaultValue),
        (element, concrete) -> element.setProperty(name, concrete),
        element -> element.hasProperty(name),
        element -> element.removeProperty(name)
    );
  }

  public static Descriptor<String, String> stringProperty(final String name, final String defaultValue) {
    Arguments.requireNotNull(name);

    return new DescriptorImpl<>(
        name,
        element -> element.getProperty(name, defaultValue),
        (element, concrete) -> element.setProperty(name, concrete),
        element -> element.hasProperty(name),
        element -> element.removeProperty(name)
    );
  }

  public static Descriptor<String, String> stringProperty(final String name) {
    Arguments.requireNotNull(name);

    return new DescriptorImpl<>(
        name,
        element -> element.getProperty(name),
        (element, concrete) -> element.setProperty(name, concrete),
        element -> element.hasProperty(name),
        element -> element.removeProperty(name)
    );
  }

  public static Descriptor<JsonValue, JsonValue> jsonProperty(final String name) {
    Arguments.requireNotNull(name);

    return new DescriptorImpl<>(
        name,
        element -> Json.parse(element.getProperty(name)),
        (element, concrete) -> element.setPropertyJson(name, concrete),
        element -> element.hasProperty(name),
        element -> element.removeProperty(name)
    );
  }

  public static Descriptor<String, String> styleProperty(final String name) {
    Arguments.requireNotNull(name);
    return new DescriptorImpl<>(
        name,
        element -> element.getStyle().get(name),
        (element, concrete) -> element.getStyle().set(name, concrete),
        element -> element.getStyle().has(name),
        element -> element.getStyle().remove(name)
    );
  }

  public static Descriptor<Boolean, Boolean> classProperty(final String name) {
    Arguments.requireNotNull(name);

    return new DescriptorImpl<>(
        name,
        element -> element.getClassList().contains(name),
        (element, concrete) -> element.getClassList().set(name, concrete),
        element -> element.getClassList().contains(name),
        element -> element.getClassList().set(name, false)
    );
  }

  // Constructors
  //--------------------------------------------------

  private Descriptors() {
    super();

    throw new UnsupportedInstantiationException();
  }

  // Nested
  //--------------------------------------------------

  /**
   * A new implementation of {@link Descriptor}.
   *
   * @param <G> The type used when getting the property's value.
   * @param <S> The type used when setting the property's value.
   *
   * @author Oliver Yasuna
   */
  private static final class DescriptorImpl<G, S> implements Descriptor<G, S> {

    // Constructors
    //--------------------------------------------------

    /**
     * Creates a new {@link DescriptorImpl}.
     *
     * @param name    The property's name.
     * @param getter  The getter function.
     * @param setter  The setter function.
     * @param has     The presence function.
     * @param remover The remover function.
     */
    private DescriptorImpl(final String name, final Function<Element, G> getter, final BiConsumer<Element, S> setter, final Predicate<Element> has,
        final Consumer<Element> remover) {
      super();

      this.name = name;

      this.getter = getter;
      this.setter = setter;

      this.has = has;
      this.remover = remover;
    }

    // Fields
    //--------------------------------------------------

    /**
     * The property's name.
     */
    private final String name;

    /**
     * The getter function.
     */
    private final Function<Element, G> getter;

    /**
     * The setter function.
     */
    private final BiConsumer<Element, S> setter;

    /**
     * The presence function.
     * <p>
     * Returns {@code true} if the element has the property.
     */
    private final Predicate<Element> has;

    /**
     * The remover function.
     * <p>
     * Removes the property from the element.
     */
    private final Consumer<Element> remover;

    // Overrides
    //--------------------------------------------------

    // Descriptor
    //

    @Override
    public final void remove(final Element element) {
      set(element, null);
    }

    // PropertyDescriptor
    //

    /**
     * @return If the element has the property, then the property's value, otherwise {@code null}.
     */
    @Override
    public final G get(final Element element) {
      Arguments.requireNotNull(element);

      return has.test(element) ? getter.apply(element) : null;
    }

    /**
     * If the value is {@code null}, then the property is removed from the element.
     */
    @Override
    public final void set(final Element element, final S value) {
      Arguments.requireNotNull(element);

      if(value != null) {
        setter.accept(element, value);
      } else {
        remover.accept(element);
      }
    }

    @Override
    public final String getPropertyName() {
      return name;
    }

    // Object methods
    //--------------------------------------------------

    @Override
    public final boolean equals(final Object other) {
      if(this == other) return true;
      if(other == null || getClass() != other.getClass()) return false;

      final DescriptorImpl<?, ?> otherCasted = (DescriptorImpl<?, ?>)other;

      return new EqualsBuilder()
          .append(name, otherCasted.name)
          .append(getter, otherCasted.getter)
          .append(setter, otherCasted.setter)
          .append(has, otherCasted.has)
          .append(remover, otherCasted.remover)
          .isEquals();
    }

    @Override
    public final int hashCode() {
      return new HashCodeBuilder(17, 37)
          .append(name)
          .append(getter)
          .append(setter)
          .append(has)
          .append(remover)
          .toHashCode();
    }

    @Override
    public final String toString() {
      return new ToStringBuilder(this)
          .append("name", name)
          .append("getter", getter)
          .append("setter", setter)
          .append("has", has)
          .append("remover", remover)
          .toString();
    }

  }

}
