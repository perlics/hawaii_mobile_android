package eu.execom.android.hawaii.ui.fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import android.widget.DatePicker
import java.util.*


/**
 * Created by sjugurdzija on 6/7/18
 */
class DatePickerDialogFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    private lateinit var calendar: Calendar
    private var listener: OnDialogFragmentInteractionListener? = null

    private var type: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            type = arguments!!.getInt(TYPE)
        }
        // check if parent Fragment implements listener
        try {
            listener = targetFragment as OnDialogFragmentInteractionListener
        } catch (e: ClassCastException) {
            throw ClassCastException("Calling Fragment must implement OnDialogFragmentInteractionListener")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Initialize a calendar instance
        calendar = Calendar.getInstance()

        // Get the system current date
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Initialize a new date picker dialog and return it
        return DatePickerDialog(
                activity,
                this,
                year,
                month,
                day
        )
    }

    // When date set and press ok button in date picker dialog
    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        when (type) {
            FROM -> listener?.setFromDate(year, month, day)
            TO -> listener?.setToDate(year, month, day)
        }
    }

    interface OnDialogFragmentInteractionListener {
        fun setFromDate(year: Int, month: Int, day: Int)
        fun setToDate(year: Int, month: Int, day: Int)
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        val TYPE = "type"
        val FROM = 0
        val TO = 1

        fun newInstance(type: Int): DatePickerDialogFragment {
            val fragment = DatePickerDialogFragment()
            val args = Bundle()
            args.putInt(TYPE, type)
            fragment.arguments = args
            return fragment
        }
    }
}