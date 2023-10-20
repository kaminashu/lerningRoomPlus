package com.example.d2android100.domain

import androidx.lifecycle.LiveData

interface ShopItemRepository {
    suspend fun addShopItem(shopItem: ShopItem)
    suspend fun editShopItem(shopItem: ShopItem)
    suspend fun deleteShopItem(shopItem: ShopItem)
    fun getShopItemList(): LiveData<List<ShopItem>>
    suspend fun getShopItemById(id: Int): ShopItem
}