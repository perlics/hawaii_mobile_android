package eu.execom.android.hawaii.ui.fragment.request

import android.app.DatePickerDialog
import android.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.execom.android.hawaii.R
import eu.execom.android.hawaii.extensions.monthName
import eu.execom.android.hawaii.ui.fragment.DatePickerFragment
import kotlinx.android.synthetic.main.fragment_leave_details.*

class DetailsFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {


        return inflater.inflate(R.layout.fragment_leave_details, container, false)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startDate.setOnClickListener {
            val datePickerFragment = DatePickerFragment()
            datePickerFragment.show(fragmentManager, "datePicker")
            datePickerFragment.setDateListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                startDate.text = "$dayOfMonth/${month.monthName()}/$year"
            }
        }

        endDate.setOnClickListener {
            val datePickerFragment = DatePickerFragment()
            datePickerFragment.show(fragmentManager, "datePicker")
            datePickerFragment.setDateListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                endDate.text = "$dayOfMonth/" + month.monthName() + "/$year"
            }
        }

        next.setOnClickListener { replaceDetailsFragment() }
    }

    private fun replaceDetailsFragment() {
        fragmentManager.beginTransaction().replace(R.id.leave_details, SummaryFragment()).commit()
    }


    private fun populateSpinner(type: String) {
        when (type) {
            "vacation" -> {

            }

            "sickness" -> {

            }
        }
    }
}