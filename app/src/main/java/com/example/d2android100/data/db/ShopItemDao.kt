package com.example.d2android100.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.d2android100.data.ShopItemDbModel

@Dao
interface ShopItemDao {
    @Query("SELECT * FROM shop")
     fun getShopList(): LiveData<List<ShopItemDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addShopItem(shopItemDbModel: ShopItemDbModel)

    @Query("DELETE FROM shop WHERE id=:id") //:::: : yoddan chiqmasin ikki nuqta bir marta yoddan chiqarding !
    suspend fun deleteShopItem(id: Int)

    @Query("select * from shop where id=:id")
    suspend fun getShopItem(id: Int): ShopItemDbModel
}