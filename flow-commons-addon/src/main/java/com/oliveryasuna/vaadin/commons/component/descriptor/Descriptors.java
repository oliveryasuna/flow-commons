package com.oliveryasuna.vaadin.commons.component.descriptor;

import com.vaadin.flow.dom.Element;
import elemental.json.Json;
import elemental.json.JsonValue;

import java.util.Arrays;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * Arguably better usage of {@link com.vaadin.flow.component.PropertyDescriptor}.
 *
 * @author Oliver Yasuna
 */
public final class Descriptors {

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
   * @return A new {@link Descriptor}.
   */
  public static Descriptor<Boolean, Boolean> emptyAttribute(final String name) {
    if(name == null) throw new IllegalArgumentException("An attribute must have a name.");

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
   * @return A new {@link Descriptor}.
   */
  public static <G, S> Descriptor<G, S> quotedAttribute(final String name, final Function<String, G> getterConverter,
      final Function<S, String> setterConverter) {
    if(name == null) throw new IllegalArgumentException("An attribute must have a name.");
    if(getterConverter == null) throw new IllegalArgumentException("Requires a getter converter.");
    if(setterConverter == null) throw new IllegalArgumentException("Requires a setter converter.");

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
   * @return A new {@link Descriptor}.
   */
  public static Descriptor<String, String> stringAttribute(final String name) {
    return quotedAttribute(name, raw -> raw, concrete -> concrete);
  }

  public static Descriptor<String[], String[]> stringListAttribute(final String name, final String delimiter) {
    return listAttribute(name, delimiter, raw -> raw, concrete -> concrete, String[]::new);
  }

  public static Descriptor<Boolean, Boolean> booleanProperty(final String name, final boolean defaultValue) {
    if(name == null) throw new IllegalArgumentException("A property must have a name.");

    return new DescriptorImpl<>(
        name,
        element -> element.getProperty(name, defaultValue),
        (element, concrete) -> element.setProperty(name, concrete),
        element -> element.hasProperty(name),
        element -> element.removeProperty(name)
    );
  }

  public static Descriptor<Integer, Integer> integerProperty(final String name, final int defaultValue) {
    if(name == null) throw new IllegalArgumentException("A property must have a name.");

    return new DescriptorImpl<>(
        name,
        element -> element.getProperty(name, defaultValue),
        (element, concrete) -> element.setProperty(name, concrete),
        element -> element.hasProperty(name),
        element -> element.removeProperty(name)
    );
  }

  public static Descriptor<Double, Double> doubleProperty(final String name, final double defaultValue) {
    if(name == null) throw new IllegalArgumentException("A property must have a name.");

    return new DescriptorImpl<>(
        name,
        element -> element.getProperty(name, defaultValue),
        (element, concrete) -> element.setProperty(name, concrete),
        element -> element.hasProperty(name),
        element -> element.removeProperty(name)
    );
  }

  public static Descriptor<String, String> stringProperty(final String name, final String defaultValue) {
    if(name == null) throw new IllegalArgumentException("A property must have a name.");

    return new DescriptorImpl<>(
        name,
        element -> element.getProperty(name, defaultValue),
        (element, concrete) -> element.setProperty(name, concrete),
        element -> element.hasProperty(name),
        element -> element.removeProperty(name)
    );
  }

  public static Descriptor<String, String> stringProperty(final String name) {
    if(name == null) throw new IllegalArgumentException("A property must have a name.");

    return new DescriptorImpl<>(
        name,
        element -> element.getProperty(name),
        (element, concrete) -> element.setProperty(name, concrete),
        element -> element.hasProperty(name),
        element -> element.removeProperty(name)
    );
  }

  public static Descriptor<JsonValue, JsonValue> jsonProperty(final String name) {
    if(name == null) throw new IllegalArgumentException("A property must have a name.");

    return new DescriptorImpl<>(
        name,
        element -> Json.parse(element.getProperty(name)),
        (element, concrete) -> element.setPropertyJson(name, concrete),
        element -> element.hasProperty(name),
        element -> element.removeProperty(name)
    );
  }

  public static Descriptor<String, String> styleProperty(final String name) {
    if(name == null) throw new IllegalArgumentException("A CSS property must have a name.");

    return new DescriptorImpl<>(
        name,
        element -> element.getStyle().get(name),
        (element, concrete) -> element.getStyle().set(name, concrete),
        element -> element.getStyle().has(name),
        element -> element.getStyle().remove(name)
    );
  }

  public static Descriptor<Boolean, Boolean> classProperty(final String name) {
    if(name == null) throw new IllegalArgumentException("A class must have a name.");

    return new DescriptorImpl<>(
        name,
        element -> element.getClassList().contains(name),
        (element, concrete) -> element.getClassList().set(name, concrete),
        element -> element.getClassList().contains(name),
        element -> element.getClassList().set(name, false)
    );
  }

  /**
   * A new implementation of {@link Descriptor}.
   *
   * @param <G> The type used when getting the property's value.
   * @param <S> The type used when setting the property's value.
   */
  private static final class DescriptorImpl<G, S> implements Descriptor<G, S> {

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

    /**
     * {@inheritDoc}
     *
     * @return If the element has the property, then the property's value, otherwise {@code null}.
     */
    @Override
    public final G get(final Element element) {
      if(element == null) throw new IllegalArgumentException("Argument [element] is null.");

      return has.test(element) ? getter.apply(element) : null;
    }

    /**
     * {@inheritDoc}
     * <p>
     * If the value is {@code null}, then the property is removed from the element.
     */
    @Override
    public final void set(final Element element, final S value) {
      if(element == null) throw new IllegalArgumentException("Argument [element] is null.");

      if(value != null) {
        setter.accept(element, value);
      } else {
        remover.accept(element);
      }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getPropertyName() {
      return name;
    }

  }

  private Descriptors() {
    throw new UnsupportedOperationException("Class cannot be instantiated.");
  }

}
