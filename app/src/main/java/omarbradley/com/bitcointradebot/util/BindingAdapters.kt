package omarbradley.com.bitcointradebot.util

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("isVisible")
fun bindIsVisible(view: View, isVisibility: Boolean) {
    view.visibility = if (isVisibility) View.VISIBLE else View.GONE
}
