package com.vintsarevich.secondlife.mapper

import ma.glasnost.orika.MapperFactory

interface OrikaMapperConfigurer {

    fun configure(factory: MapperFactory)
}
