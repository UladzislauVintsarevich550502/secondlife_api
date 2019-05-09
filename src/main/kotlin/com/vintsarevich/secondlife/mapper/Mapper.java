package com.vintsarevich.secondlife.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Service for objects mapping.
 *
 * @author Anton Klimansky
 */
public interface Mapper {

    /**
     * Maps passed object to the target class by going through all the available mappers.
     *
     * @param source           to map
     * @param destinationClass the object needs to be mapped to
     * @param <S>              type of the source object
     * @param <D>              type of the destination object
     * @return object mapped by an appropriate mapper
     */
    <S, D> D map(S source, Class<D> destinationClass);

    /**
     * Maps the properties of <code>source</code> object onto
     * <code>destination</code> object.
     *
     * @param source      the object from which to read the properties
     * @param destination the object onto which the properties should be mapped
     * @param <S>         type of the source object
     * @param <D>         type of the destination object
     */
    <S, D> void map(S source, D destination);

    /**
     * Maps list of passed objects to the target class by going through all the available mappers.
     *
     * @param objects          list of objects to map
     * @param destinationClass the object needs to be mapped to
     * @param <S>              type of the source value
     * @param <D>              type of the destination value
     * @return list of objects mapped by an appropriate mapper
     */
    default <S, D> List<D> map(List<S> objects, Class<D> destinationClass) {
        return map(objects.stream(), destinationClass).collect(Collectors.toList());
    }

    /**
     * Maps set of passed objects to the target class by going through all the available mappers.
     *
     * @param objects          set of objects to map
     * @param destinationClass the object needs to be mapped to
     * @param <S>              type of the source value
     * @param <D>              type of the destination value
     * @return set of objects mapped by an appropriate mapper
     */
    default <S, D> Set<D> map(Set<S> objects, Class<D> destinationClass) {
        return map(objects.stream(), destinationClass).collect(Collectors.toSet());
    }

    /**
     * Maps collection of passed objects to the target class by going through all the available mappers.
     *
     * @param objects          collection of objects to map
     * @param destinationClass the object needs to be mapped to
     * @param <S>              type of the source value
     * @param <D>              type of the destination value
     * @return collection of objects mapped by an appropriate mapper
     */
    default <S, D> List<D> map(Collection<S> objects, Class<D> destinationClass) {
        return map(objects.stream(), destinationClass).collect(Collectors.toList());
    }

    /**
     * Maps stream of passed objects to the target class by going through all the available mappers.
     *
     * @param objects          stream of objects to map
     * @param destinationClass the object needs to be mapped to
     * @param <S>              type of the source value
     * @param <D>              type of the destination value
     * @return stream of objects mapped by an appropriate mapper
     */
    default <S, D> Stream<D> map(Stream<S> objects, Class<D> destinationClass) {
        return objects.map(object -> map(object, destinationClass));
    }
}
