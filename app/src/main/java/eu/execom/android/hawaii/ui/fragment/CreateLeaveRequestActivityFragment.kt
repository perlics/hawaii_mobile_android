package eu.execom.android.hawaii.ui.fragment

import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.execom.android.hawaii.R
import kotlinx.android.synthetic.main.fragment_create_leave_request.*

/**
 * A placeholder fragment containing a simple view.
 */
class CreateLeaveRequestActivityFragment : Fragment(), DatePickerDialogFragment.OnDialogFragmentInteractionListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_create_leave_request, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnPickFrom.setOnClickListener({
            showDatepickerDialog()
        })
        btnPickTo.setOnClickListener({
            showDatepickerDialog()
        })
    }

    override fun setDate(year: Int, month: Int, day: Int) {
        tvFrom.setText("${day}.${month}.${year}")
    }


    fun showDatepickerDialog() {
        val newFragment = DatePickerDialogFragment()
        newFragment.setTargetFragment(this, 0)
        newFragment.show(activity.fragmentManager, "dialog_fragment")
    }

}
