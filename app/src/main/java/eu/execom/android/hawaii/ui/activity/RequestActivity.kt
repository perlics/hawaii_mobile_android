package eu.execom.android.hawaii.ui.activity


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import eu.execom.android.hawaii.R
import eu.execom.android.hawaii.ui.fragment.request.LeaveFragment
import eu.execom.android.hawaii.ui.fragment.request.BonusFragment
import kotlinx.android.synthetic.main.activity_create_leave_request.*
import kotlinx.android.synthetic.main.app_bar_main.*


class RequestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_leave_request)
        setSupportActionBar(toolbar)

        replaceFragment("vacation")

        navigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.vacation -> replaceFragment("vacation")
                R.id.sick -> replaceFragment("sickness")
                R.id.bonus -> replaceFragment("bonus")
                else -> {
                   false
                }
            }
        }
    }

    private fun replaceFragment(type: String): Boolean {

        when (type) {
            "sickness" -> {
                val detailsFragment = LeaveFragment()
                val bundle = Bundle()
                bundle.putString("typeOfLeave", type)
                detailsFragment.arguments = bundle
                fragmentManager.beginTransaction().replace(R.id.frame_layout_create_request, detailsFragment).commit()
            }
            "vacation" -> {
                val leaveFragment = LeaveFragment()
                val bundle = Bundle()
                bundle.putString("typeOfLeave", type)
                leaveFragment.arguments = bundle
                fragmentManager.beginTransaction().replace(R.id.frame_layout_create_request, leaveFragment).commit()
            }
            "bonus" -> fragmentManager.beginTransaction().replace(R.id.frame_layout_create_request, BonusFragment()).commit()
        }
        return true
    }
}
