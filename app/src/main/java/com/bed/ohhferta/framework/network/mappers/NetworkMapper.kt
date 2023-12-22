package com.bed.ohhferta.framework.network.mappers

interface NetworkMapper<in IN, out OUT> {
    operator fun invoke(data: IN): OUT
}
