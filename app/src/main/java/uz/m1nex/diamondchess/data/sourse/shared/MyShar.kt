package uz.m1nex.diamondchess.data.sourse.shared

import android.content.Context
import android.content.SharedPreferences
import uz.m1nex.diamondchess.app.MyApp
import uz.m1nex.diamondchess.data.model.User
import kotlin.jvm.java

class MyShar private constructor(context: Context): SharedPreference(context = context){


    companion object{
        private var _sharedPreference:SharedPreferences?=null
        private val sharedPreference:SharedPreferences
            get() = _sharedPreference!!
        private var initializer:MyShar?=null
//        fun init(context: Context){
//            if (initializer==null){
//                initializer=MyShar(context)
//                _sharedPreference=context.getSharedPreferences("MyShar",Context.MODE_PRIVATE)
//            }
//        }
        fun getInstance():MyShar{
            return initializer!!
        }

        @JvmStatic
        fun init(context: MyApp) {
            if (initializer==null){
                initializer=MyShar(context)
                _sharedPreference=context.getSharedPreferences("MyShar",Context.MODE_PRIVATE)
            }
        }
    }
//    var themeType by objects(ThemeType::class.java,ThemeType.SYSTEM)

    var isLogin by booleans(false)

    var userData by objects(User::class.java,null)
    var accessToken by strings("")


//    fun getCountries():List<String>{
//        return userData?.country?.split(", ")?: emptyList()
//    }
//
//    fun getLanguages():List<String>{
//
//        return userData?.userLang?.split(", ")?: emptyList()
//    }

    fun clear(){
        isLogin=false
        userData=null
        accessToken=""
    }
}