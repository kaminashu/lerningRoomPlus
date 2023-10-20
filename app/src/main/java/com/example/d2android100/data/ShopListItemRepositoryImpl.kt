package com.example.d2android100.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.d2android100.data.db.AppDatabase
import com.example.d2android100.data.db.ShopItamMapper
import com.example.d2android100.domain.ShopItem
import com.example.d2android100.domain.ShopItemRepository
import java.util.Random

class ShopListItemRepositoryImpl(application: Application) : ShopItemRepository {
    val shopItemDao = AppDatabase.getInstanse(application).shopItemDao()
    val mapper = ShopItamMapper()
    override suspend fun addShopItem(shopItem: ShopItem) {
        shopItemDao.addShopItem(mapper.mapShopDbModeltoEntitiy(shopItem))
    }

    override suspend fun editShopItem(shopItem: ShopItem) {
        shopItemDao.addShopItem(mapper.mapShopDbModeltoEntitiy(shopItem))
    }

    override suspend fun deleteShopItem(shopItem: ShopItem) {
        shopItemDao.deleteShopItem(shopItem.id)
    }

    override fun getShopItemList(): LiveData<List<ShopItem>> = MediatorLiveData<List<ShopItem>>().apply {
        addSource(shopItemDao.getShopList()){
            value=mapper.mapListEntitiy(it)
    }
    }

    override suspend fun getShopItemById(id: Int): ShopItem {
        val shopitemModel = shopItemDao.getShopItem(id)
        return mapper.mapEntitytoShopDbModel(shopitemModel)
    }

}