package com.example.d2android100.domain

class AddShopItemUseCase(private val repository: ShopItemRepository) {
    suspend  fun addShopItem(shopItem: ShopItem){
        repository.addShopItem(shopItem)
    }
}