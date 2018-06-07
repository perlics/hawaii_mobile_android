package eu.execom.android.hawaii.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import eu.execom.android.hawaii.R
import kotlinx.android.synthetic.main.activity_create_leave_request.*


class CreateLeaveRequestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_leave_request)
        setSupportActionBar(toolbar)

    }

}
