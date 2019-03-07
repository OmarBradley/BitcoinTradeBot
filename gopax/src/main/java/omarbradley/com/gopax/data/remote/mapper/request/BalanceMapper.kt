package omarbradley.com.gopax.data.remote.mapper.request

import omarbradley.com.common.domain.Mapper
import omarbradley.com.gopax.data.remote.json.resopnse.BalanceJson
import omarbradley.com.gopax.entity.resopnse.Balance

object BalanceMapper : Mapper<Balance, BalanceJson> {

    override fun toData(entity: Balance): BalanceJson =
        BalanceJson(
            entity.asset,
            entity.avail,
            entity.hold,
            entity.pendingWithdrawal
        )


    override fun toEntity(data: BalanceJson): Balance =
        Balance(data.asset, data.avail, data.hold, data.pendingWithdrawal)

}
