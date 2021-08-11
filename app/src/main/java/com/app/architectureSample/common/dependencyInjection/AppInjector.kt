package com.app.architectureSample.common.dependencyInjection

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.app.architectureSample.common.app.ArchApp
import com.app.architectureSample.common.dependencyInjection.component.DaggerAppComponent
import dagger.android.AndroidInjection
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection

/**
 * Helper class to automatically inject fragments if they implement [Injectable].
 */
object AppInjector {

    fun init(app: ArchApp) {
        DaggerAppComponent.builder()
            .application(app)
            .build()
            .inject(app)

        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                injectActivityAndFragment(activity)
            }

            override fun onActivityStarted(activity: Activity) {}
            override fun onActivityResumed(activity: Activity) {}
            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivityDestroyed(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
        })
    }

    private fun injectActivityAndFragment(activity: Activity) {
        // Injecting Activity
        if (activity is HasAndroidInjector) {
            AndroidInjection.inject(activity)
        }

        // Injecting Fragment
        if (activity is FragmentActivity) {
            activity.supportFragmentManager.registerFragmentLifecycleCallbacks(
                object : FragmentManager.FragmentLifecycleCallbacks() {
                    override fun onFragmentAttached(
                        fragmentManager: FragmentManager,
                        fragment: Fragment,
                        context: Context
                    ) {
                        if (fragment is Injectable) {
                            AndroidSupportInjection.inject(fragment)
                        }
                    }
                }, true
            )
        }
    }
}