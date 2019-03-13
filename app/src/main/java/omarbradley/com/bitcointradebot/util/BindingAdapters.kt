package omarbradley.com.bitcointradebot.util

import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("isVisible")
fun bindIsVisible(view: View, isVisibility: Boolean) {
    Log.e("isVisibility", isVisibility.toString())
    view.visibility = if (isVisibility) View.VISIBLE else View.GONE
}
