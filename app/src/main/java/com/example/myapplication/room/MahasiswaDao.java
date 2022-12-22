package com.example.myapplication.room;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MahasiswaDao {

    @Query("SELECT * FROM mahasiswa")
    List<Mahasiswa> getAll();

    @Query("SELECT * FROM mahasiswa")
    LiveData<List<Mahasiswa>> dataMahassiswa();

    @Query("SELECT * FROM mahasiswa WHERE nama LIKE :nama ")
    Mahasiswa findByName(String nama);

    @Query("SELECT * FROM mahasiswa WHERE id=:id ")
    Mahasiswa findById(int id);

    @Insert
    void insertAll(Mahasiswa mahasiswa);

    @Delete
    public void deleteUsers(Mahasiswa users);

    @Update
    public void update(Mahasiswa mahasiswa);

    @Delete
    public void deleteAll(Mahasiswa user1,Mahasiswa user2);

}
