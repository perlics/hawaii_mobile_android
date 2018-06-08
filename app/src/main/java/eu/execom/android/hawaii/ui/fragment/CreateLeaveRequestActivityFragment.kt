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
            showDatepickerDialog(DatePickerDialogFragment.FROM)
        })
        btnPickTo.setOnClickListener({
            showDatepickerDialog(DatePickerDialogFragment.TO)
        })
    }

    override fun setFromDate(year: Int, month: Int, day: Int) {
        tvFrom.setText("From: ${day}.${month}.${year}")
    }


    override fun setToDate(year: Int, month: Int, day: Int) {
        tvTo.setText("To: ${day}.${month}.${year}")
    }


    fun showDatepickerDialog(type: Int) {
        val newFragment = DatePickerDialogFragment.newInstance(type)
        newFragment.setTargetFragment(this, 0)
        newFragment.show(activity.fragmentManager, "dialog_fragment")
    }

}
