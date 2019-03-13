package omarbradley.com.bitcointradebot.gopax.recyclerview.authkeyitem

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.itemview_auth_key.view.*
import omarbradley.com.bitcointradebot.databinding.ItemviewAuthKeyBinding
import omarbradley.com.gopax.entity.resopnse.AuthKey

class AuthKeyItemAdapter(
    private val onLongClick: (AuthKeyItem) -> Unit,
    private val onClickDelete: (AuthKeyItem) -> Unit
) : ListAdapter<AuthKeyItem, AuthKeyItemView>(
    AuthKeyItemDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthKeyItemView =
        AuthKeyItemView(
            ItemviewAuthKeyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: AuthKeyItemView, position: Int) {
        holder.bind(getItem(position), onLongClick, onClickDelete)
    }
}

private class AuthKeyItemDiffCallback : DiffUtil.ItemCallback<AuthKeyItem>() {

    override fun areItemsTheSame(oldItem: AuthKeyItem, newItem: AuthKeyItem): Boolean =
        oldItem.apiKey == newItem.apiKey

    override fun areContentsTheSame(oldItem: AuthKeyItem, newItem: AuthKeyItem): Boolean =
        oldItem == newItem

}


data class AuthKeyItem(
    val apiKey: String,
    val secretKey: String
)

fun AuthKey.toAuthKeyItem() = AuthKeyItem(apiKey, secretKey)

class AuthKeyItemView(
    private val binding: ItemviewAuthKeyBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: AuthKeyItem, onLongClick: (AuthKeyItem) -> Unit, onClickDelete: (AuthKeyItem) -> Unit) {
        with(binding) {
            this.item = item
            executePendingBindings()
        }

        with(itemView) {
            setOnLongClickListener {
                onLongClick(item)
                false
            }

            iconicsTextView_delete.setOnClickListener {
                onClickDelete(item)
            }
        }
    }
}

