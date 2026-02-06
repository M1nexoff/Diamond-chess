package uz.m1nex.diamondchess.app

import android.app.Application
import uz.m1nex.diamondchess.data.sourse.shared.MyShar

class MyApp:Application() {


    override fun onCreate() {
        super.onCreate()
        MyShar.init(this)
    }
}