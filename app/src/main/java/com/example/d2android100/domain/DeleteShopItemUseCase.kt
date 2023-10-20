package com.example.d2android100.domain

class DeleteShopItemUseCase(private val repository: ShopItemRepository) {
    suspend  fun deleteShopItem(shopItem: ShopItem){
        repository.deleteShopItem(shopItem)
    }
}