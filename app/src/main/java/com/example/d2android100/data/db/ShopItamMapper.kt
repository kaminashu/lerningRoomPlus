package com.example.d2android100.data.db

import com.example.d2android100.data.ShopItemDbModel
import com.example.d2android100.domain.ShopItem

class ShopItamMapper(
) {
    fun mapShopDbModeltoEntitiy(shopItem: ShopItem): ShopItemDbModel {
        return ShopItemDbModel(
            id = shopItem.id,
            item_name = shopItem.item_name,
            enabled = shopItem.enabled,
            count = shopItem.count
        )
    }
    fun mapEntitytoShopDbModel(shopItemDbModel: ShopItemDbModel): ShopItem {
        return ShopItem(
            id = shopItemDbModel.id,
            item_name = shopItemDbModel.item_name,
            enabled = shopItemDbModel.enabled,
            count = shopItemDbModel.count
        )
    }
    fun mapListEntitiy(list:List<ShopItemDbModel>) =list.map {
        mapEntitytoShopDbModel(it)
    }
}