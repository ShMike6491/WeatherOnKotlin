package com.e.weatherkotlin.repositories

import com.e.weatherkotlin.model.CityModel
import com.e.weatherkotlin.model.WeatherModel
import com.e.weatherkotlin.room.FavoritesDAO
import com.e.weatherkotlin.utils.convertToWeatherList

class CacheRepImpl (private val localSource: FavoritesDAO) : CacheRep {
    override fun getFavorites(): List<WeatherModel> {
        return convertToWeatherList(localSource.all())
    }

    override fun saveToFavorites(model: CityModel) {
        localSource.insert(model)
    }
}