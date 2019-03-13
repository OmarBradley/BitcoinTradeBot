package omarbradley.com.bitcointradebot.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.filter
import kotlinx.coroutines.channels.map
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

object EventBus {

    private val bus = BroadcastChannel<Any>(1)

    fun send(event: Any, context: CoroutineContext) {
        CoroutineScope(context).launch {
            bus.send(event)
        }
    }

    fun subscribe() =
        bus.openSubscription()

    inline fun <reified T> subscribeToEvent() =
        subscribe().filter { it is T }
            .map { it as T }

}
