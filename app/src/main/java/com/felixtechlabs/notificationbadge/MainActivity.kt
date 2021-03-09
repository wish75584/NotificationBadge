package com.felixtechlabs.notificationbadge

import android.R
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var textCartItemCount: TextView
    val mCartItemCount = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item)

        val menuItem: MenuItem = menu!!.findItem(R.id.action_cart)

        val actionView: View = menuItem.getActionView()
        textCartItemCount = actionView.findViewById(R.id.cart_badge)

        setupBadge()

        actionView.setOnClickListener(object : View.OnClickListener() {
            override fun onClick(v: View?) {
                onOptionsItemSelected(menuItem)
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_cart -> {

                // Do something
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupBadge() {
        if (textCartItemCount != null) {
            if (mCartItemCount == 0) {
                if (textCartItemCount.getVisibility() != View.GONE) {
                    textCartItemCount.setVisibility(View.GONE);
                }
            } else {
                textCartItemCount.setText(String.valueOf(Math.min(mCartItemCount, 99)));
                if (textCartItemCount.getVisibility() != View.VISIBLE) {
                    textCartItemCount.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}