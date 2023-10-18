package com.example.d2android100.data.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.d2android100.data.ShopItemDbModel

@Database(entities = [ShopItemDbModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun shopItemDao(): ShopItemDao

    companion object {
        /*
        * #INCTANCE DATABASE TIPIDAGI MALUMOT SAQAYDI VA FUNKSIYA ICHIDA MALUMOTGA
        * EGA BO`LSA SHU MA`LUMOTNI QAYTAARDI
        *
        * SYNXRONIZED NIMAGA KERAK ?
        * LOCK NIMAGA KERAK ?
        *  2 HIL PATOC DAN DATABASE GA MUROJAT QILINIB TURILGAN BO`LSA
        * MASALAN THRED VA MAIN PATOCLAR FUNKSIYANI ICHIGA IKKALASI HAM BIR VAQTDA KIRADI
        * BIZ 1 DONA DB OCHSHIMIZ KERAK SHUNING UCHUN  BIZGA 2 VA UNDAN ORTIQ PATOCLAR KELGAMDA KETMAKETLIKDA
        * ISH BAJARSIN IKKALASI HAM BURNINI TIQMAY
        *
        * SHUNING UCHUN SYNCHRONIZED ISHLATDIK BU ASINXRON KOD  QANCHA PATOCDAN MUROJAT KELSA HAM BIR BIRDAN KIRITADI
        * TABIKI 1 MAROTABA KIRGANDAN KEGIN INSTANCE QIYMATGA EGA BO`LIB KEGINGILARIGA SYNCHRONIZED NASIB QILMAYDI !
        *
        * LOOK() ESA HAR QANDAY SO`ROVNI USHLAB SYSNCHRONIZED GA UZATADI 
        * */
        private var INSTACE: AppDatabase? = null
        private val LOCK = Any() //
        const val DB_NAME = "praduct.db"
        fun getInstanse(application: Application): AppDatabase {
            INSTACE?.let {
                return it
            }
            synchronized(LOCK) { //
                INSTACE?.let {
                    return it
                }
                val db = Room.databaseBuilder(application, AppDatabase::class.java, DB_NAME).build()// allowMainThreadQueries() nu ishni qilish xato main patoq bilan ishlidi  caraotines dan foydalan
                INSTACE = db
                return db
            }
        }
    }
}