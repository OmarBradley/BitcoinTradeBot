package omarbradley.com.bitcointradebot.util.view

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import omarbradley.com.bitcointradebot.R

class ProgressDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setView(R.layout.fragment_progress_dialog)
            .create()

    companion object {

        fun show(fragmentManager: FragmentManager): ProgressDialogFragment =
            ProgressDialogFragment().apply {
                show(fragmentManager, "ProgressDialog")
            }
    }

}
