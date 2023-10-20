package com.example.d2android100.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.d2android100.data.ShopListItemRepositoryImpl
import com.example.d2android100.domain.DeleteShopItemUseCase
import com.example.d2android100.domain.EditShopItemUseCase
import com.example.d2android100.domain.GetShopItemListUseCase
import com.example.d2android100.domain.ShopItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MyViewModel(application: Application):AndroidViewModel(application) {

    val repository = ShopListItemRepositoryImpl(application)
    val getShopItemListUseCase  = GetShopItemListUseCase(repository)
    val editShopItemUseCase = EditShopItemUseCase(repository)
    val deleteShopItemUseCase = DeleteShopItemUseCase(repository)

    val shopList = getShopItemListUseCase.getShopItemList()
    val myScope= CoroutineScope(Dispatchers.IO)
     fun deleteShopItem(shopItem: ShopItem){
         myScope.launch {
             deleteShopItemUseCase.deleteShopItem(shopItem)
         }

    }
     fun enabled(shopItem: ShopItem){
         myScope.launch {
             val newValue = shopItem.copy(enabled = !shopItem.enabled)
             editShopItemUseCase.editShopItem(newValue)
         }
    }

    override fun onCleared() {
        super.onCleared()
        myScope.cancel()
    }
}