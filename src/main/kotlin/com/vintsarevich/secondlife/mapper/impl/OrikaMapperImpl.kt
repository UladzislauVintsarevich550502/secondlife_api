package com.vintsarevich.secondlife.mapper.impl

import com.vintsarevich.secondlife.mapper.OrikaMapperConfigurer
import ma.glasnost.orika.MapperFacade
import ma.glasnost.orika.converter.builtin.PassThroughConverter
import ma.glasnost.orika.impl.DefaultMapperFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.util.*
import java.util.Collections.emptyList
import java.util.stream.Collectors

/**
 * Orika based mapper service implementation.
 * For adding a custom mapper implement [OrikaMapperConfigurer].
 *
 * @author Alexey Kolenchenko
 */
@Component
class OrikaMapperImpl(@Autowired(required = false) configurers: List<OrikaMapperConfigurer>) {

    private val mapper: MapperFacade

    init {
        val mapperFactory = DefaultMapperFactory.Builder().build()
        mapperFactory.converterFactory.registerConverter(PassThroughConverter(LocalDate::class.java))
        for (configurer in Optional.ofNullable(configurers).orElse(emptyList())) {
            configurer.configure(mapperFactory)
        }
        mapper = mapperFactory.mapperFacade
    }

    fun <S, D> map(source: List<S>, destinationClass: Class<D>): List<D> {
        return source.stream().map { `object` -> mapper.map(`object`, destinationClass) }.collect(Collectors.toList())
    }

}
