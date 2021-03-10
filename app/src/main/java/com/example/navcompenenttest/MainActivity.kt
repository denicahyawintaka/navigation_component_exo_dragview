package com.example.navcompenenttest

import android.app.PictureInPictureParams
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.navcompenenttest.motionlayout.PlayScreenFragment


class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }

    fun openMotionLayout(){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.play_screen_frame_layout, PlayScreenFragment.newInstance(), PlayScreenFragment.TAG)
            .commit()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        navHostFragment.childFragmentManager.fragments.first()?.let {
            (it as? VideoFragment)?.isVisible?.let {
                val params = PictureInPictureParams.Builder()
                enterPictureInPictureMode(params.build())
            }
        }
    }

    override fun onPictureInPictureModeChanged(
        isInPictureInPictureMode: Boolean,
        newConfig: Configuration
    ) {
        if (isInPictureInPictureMode) {
            // Hide the full-screen UI (controls, etc.) while in picture-in-picture mode.
        } else {
            // Restore the full-screen UI.
        }
    }
}
