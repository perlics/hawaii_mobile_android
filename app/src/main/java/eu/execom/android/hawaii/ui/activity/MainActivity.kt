package eu.execom.android.hawaii.ui.activity

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
import android.view.View
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.google.firebase.auth.FirebaseAuth
import eu.execom.android.hawaii.R
import eu.execom.android.hawaii.domain.User
import eu.execom.android.hawaii.extensions.toUser
import eu.execom.android.hawaii.ui.fragment.drawer.CompanyCalendarFragment
import eu.execom.android.hawaii.ui.fragment.drawer.DashboardFragment
import eu.execom.android.hawaii.ui.fragment.OnFragmentInteractionListener
import eu.execom.android.hawaii.ui.fragment.drawer.TeamCalendarFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, OnFragmentInteractionListener {

    lateinit var firebaseAuth : FirebaseAuth
    lateinit var displayName: TextView
    lateinit var email: TextView
    lateinit var image: SimpleDraweeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        firebaseAuth = FirebaseAuth.getInstance()

        fab.setOnClickListener { _ ->
            val intent = Intent(this, RequestActivity::class.java)
            startActivity(intent)
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        nav_view.setCheckedItem(R.id.nav_leave_history)
        val headerView: View = nav_view.getHeaderView(0)
        setView(DashboardFragment::class.java, getString(R.string.dashboard))

        email = headerView.findViewById(R.id.email)
        displayName = headerView.findViewById(R.id.displayName)
        image = headerView.findViewById(R.id.image)

        if (firebaseAuth.currentUser == null) {
            val intent = Intent(this, LoginActivity::class.java); startActivity(intent)
        }
        else {
            updateUI(firebaseAuth.currentUser?.toUser()!!)
        }


    }

    private fun updateUI(user: User) {
        email.text = user.email
        displayName.text = user.name
        image.setImageURI(user.photoUri.toString())
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
            R.id.action_settings -> logout()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun logout(): Boolean {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragmentClass: Class<*>? = null
        when (item.itemId) {
            R.id.nav_leave_history -> fragmentClass = DashboardFragment::class.java

            R.id.nav_team_calendar -> fragmentClass = TeamCalendarFragment::class.java

            R.id.nav_company_calendar -> fragmentClass = CompanyCalendarFragment::class.java

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
