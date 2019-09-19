package com.t3h.restaurantmanager.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.t3h.restaurantmanager.Food;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface FoodDao {

    @Query("SELECT * FROM foods")
    List<Food> getAll();

//    @Query("SELECT * FROM foods WHERE isFavorite = 1")
//    List<News> getNewsFavorite();

    @Insert
    void insert(Food foods);

    @Insert
    void insertAll(Food... foods);

    @Delete
    void delete(Food... foods);

    @Query("DELETE FROM foods")
    void deleteAll();

    @Query("UPDATE foods SET isFavorite =1 WHERE id= :id")
    void updateFavorite(long id);

    @Query("SELECT * FROM foods  WHERE id= :id")
    Food getFavoritebyId(long id);

//    @Query("UPDATE news SET isFavorite =0 WHERE id= :id")
//    void delFavorite(long id);
}
