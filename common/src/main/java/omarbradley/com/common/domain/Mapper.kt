package omarbradley.com.common.domain

interface Mapper<ENTITY, DATA> {

    fun mapFromEntity(entity: ENTITY): DATA

    fun mapToEntity(data: DATA): ENTITY

}