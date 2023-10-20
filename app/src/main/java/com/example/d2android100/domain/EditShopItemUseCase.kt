package com.example.d2android100.domain

class EditShopItemUseCase(private val repository: ShopItemRepository) {
    suspend  fun editShopItem(shopItem: ShopItem){
        repository.editShopItem(shopItem)
    }
}