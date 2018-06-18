package eu.execom.android.hawaii.ui.fragment.request

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import eu.execom.android.hawaii.R


class BonusFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_bonus, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fragmentManager.beginTransaction().replace(R.id.bonus_fragment_details, BonusFragmentDetails()).commit()
    }
}