package omarbradley.com.gopax.data.remote.mapper

import omarbradley.com.common.domain.Mapper
import omarbradley.com.gopax.data.remote.json.BalanceJson
import omarbradley.com.gopax.entity.Balance

object BalanceMapper : Mapper<Balance, BalanceJson> {

    override fun mapFromEntity(entity: Balance): BalanceJson =
        BalanceJson(entity.asset, entity.avail, entity.hold, entity.pendingWithdrawal)


    override fun mapToEntity(data: BalanceJson): Balance =
            Balance(data.asset, data.avail, data.hold, data.pendingWithdrawal)

}
