package org.oxyroid.hscard

import android.app.Application
import android.content.Context

val applicationContext: Context get() = HsApplication.INSTANCE

class HsApplication : Application() {
    init {
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: HsApplication
    }
}
