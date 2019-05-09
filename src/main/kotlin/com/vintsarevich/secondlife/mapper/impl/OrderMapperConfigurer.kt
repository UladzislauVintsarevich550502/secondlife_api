package com.vintsarevich.secondlife.mapper.impl

import com.vintsarevich.secondlife.dto.OrderDto
import com.vintsarevich.secondlife.mapper.OrikaMapperConfigurer
import com.vintsarevich.secondlife.model.Order
import ma.glasnost.orika.CustomMapper
import ma.glasnost.orika.MapperFactory
import ma.glasnost.orika.MappingContext
import org.springframework.stereotype.Component

@Component
class OrderMapperConfigurer : OrikaMapperConfigurer {

    override fun configure(factory: MapperFactory) {
        factory.classMap(Order::class.java, OrderDto::class.java).byDefault()
            .customize(
                object : CustomMapper<Order, OrderDto>() {
                    override fun mapAtoB(order: Order, orderDto: OrderDto, context: MappingContext?) {
                        orderDto.status = order.status.name
                    }
                }).register()
    }
}
