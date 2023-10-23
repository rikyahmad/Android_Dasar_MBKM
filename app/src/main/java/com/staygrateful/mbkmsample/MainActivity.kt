package com.staygrateful.mbkmsample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.staygrateful.mbkmsample.ui.compose.activity.ComposeActivity
import com.staygrateful.mbkmsample.ui.view.activity.ViewActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.view).setOnClickListener {
            openActivity(ViewActivity::class.java)
        }

        findViewById<View>(R.id.compose).setOnClickListener {
            openActivity(ComposeActivity::class.java)
        }

        findViewById<View>(R.id.raw_assets).setOnClickListener {
            openActivity(RawAssetsActivity::class.java)
        }

        findViewById<View>(R.id.list).setOnClickListener {
            openActivity(ListActivity::class.java)
        }

        findViewById<View>(R.id.grid).setOnClickListener {
            openActivity(GridListActivity::class.java)
        }

        findViewById<View>(R.id.list_room).setOnClickListener {
            openActivity(ListRoomActivity::class.java)
        }

        findViewById<View>(R.id.retrofit).setOnClickListener {
            openActivity(RetrofitActivity::class.java)
        }

        findViewById<View>(R.id.testing).setOnClickListener {
            openActivity(TestingActivity::class.java)
        }

        findViewById<View>(R.id.view_model).setOnClickListener {
            openActivity(ViewModelActivity::class.java)
        }

        val intent = Intent(this, JavaActivity::class.java)
        intent.putExtra("KEY_DATA", "Hallo Activity..")
        startActivity(intent)
    }

    private fun openActivity(clazz: Class<out Activity>) {
        startActivity(Intent(this, clazz))
    }
}