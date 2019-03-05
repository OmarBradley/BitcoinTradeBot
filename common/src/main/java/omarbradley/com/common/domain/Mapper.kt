package omarbradley.com.common.domain

interface Mapper<ENTITY, DATA> {

    fun toData(entity: ENTITY): DATA

    fun toEntity(data: DATA): ENTITY

}