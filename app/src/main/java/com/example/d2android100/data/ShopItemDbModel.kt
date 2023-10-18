package com.example.d2android100.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.d2android100.domain.ShopItem

@Entity(tableName = "shop")
class ShopItemDbModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int= ShopItem.UNDEFINED_ID,
    val item_name:String,
    val count:Int,
    val enabled:Boolean
)