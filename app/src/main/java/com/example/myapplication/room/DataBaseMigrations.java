package com.example.myapplication.room;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class DataBaseMigrations {
    public static final Migration MIGRATION_1_TO_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE mahasiswa ADD COLUMN gambar TEXT DEFAULT ''");
        }
    };

    public static final Migration MIGRATION_2_TO_3 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS matkul (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nama` TEXT, `sks` TEXT, `semester` TEXT)");
        }
    };
}
