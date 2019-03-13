package omarbradley.com.common.data

interface Mapper<ENTITY, DATA> {

    fun toData(entity: ENTITY): DATA

    fun toEntity(data: DATA): ENTITY

}