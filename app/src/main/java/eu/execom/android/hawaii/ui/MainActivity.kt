package eu.execom.android.hawaii.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import eu.execom.android.hawaii.R
import eu.execom.android.hawaii.ui.fragment.CompanyCalendarFragment
import eu.execom.android.hawaii.ui.fragment.LeaveHistoryFragment
import eu.execom.android.hawaii.ui.fragment.OnFragmentInteractionListener
import eu.execom.android.hawaii.ui.fragment.TeamCalendarFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, OnFragmentInteractionListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { _ ->
            val intent = Intent(this, CreateLeaveRequestActivity::class.java)
            startActivity(intent)
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        nav_view.setCheckedItem(R.id.nav_leave_history)
        setView(LeaveHistoryFragment::class.java, "Leave History")
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragmentClass: Class<*>? = null
        when (item.itemId) {
            R.id.nav_leave_history -> {
                fragmentClass = LeaveHistoryFragment::class.java
            }
            R.id.nav_team_calendar -> {
                fragmentClass = TeamCalendarFragment::class.java
            }
            R.id.nav_company_calendar -> {
                fragmentClass = CompanyCalendarFragment::class.java
            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        fragmentClass?.let { setView(fragmentClass, item.title) }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun setView(fragmentClass: Class<*>?, appBarTitle: CharSequence) {
        var fragment: Fragment? = null
        try {
            fragment = fragmentClass?.newInstance() as Fragment
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val fragmentManager = supportFragmentManager
        fragment?.let {
            fragmentManager.beginTransaction().replace(R.id.content, it).commit()
        }

        title = appBarTitle

    }

    override fun onFragmentInteraction(uri: Uri) {

    }
}
