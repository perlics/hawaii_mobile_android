package eu.execom.android.hawaii.ui.fragment.request

import android.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.execom.android.hawaii.R
import kotlinx.android.synthetic.main.fragment_leave.*
import kotlinx.android.synthetic.main.fragment_leave_details.*

/**
 * A placeholder fragment containing a simple view.
 */
class LeaveFragment : Fragment() {

    lateinit var typeOfLeave : String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        typeOfLeave = arguments.getString("typeOfLeave")


        return inflater.inflate(R.layout.fragment_leave, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        new_leave.text = "New $typeOfLeave request"
        inflateDetailsFragment()
    }

    private fun inflateDetailsFragment() {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("typeOfLeave", typeOfLeave)
        detailsFragment.arguments = bundle
        fragmentManager.beginTransaction().add(R.id.leave_details, detailsFragment).commit()
    }

}



