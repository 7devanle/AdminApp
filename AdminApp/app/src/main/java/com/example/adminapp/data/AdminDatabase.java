package com.example.adminapp.data;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.adminapp.dao.AdminDao;
import com.example.adminapp.entities.Admin;
import com.example.adminapp.entities.Student;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Admin.class, Student.class}, version = 1, exportSchema = false)
public abstract class AdminDatabase extends RoomDatabase {
    public abstract AdminDao adminDao();
    //public abstract StudentDao studentDao();
    private static volatile AdminDatabase INSTANCE;
    private static final int NO_OF_THREADS = 4;
    public static final ExecutorService DATABASE_WRITE_EXECUTOR = Executors.newFixedThreadPool(NO_OF_THREADS);

    public static AdminDatabase getInstance(final Context CONTEXT) {
        if (INSTANCE == null) {
            synchronized (AdminDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(CONTEXT.getApplicationContext()
                                    , AdminDatabase.class, "admin_database")
                            .createFromAsset("database/admin_database.db")
                            .build();
                }
            }
        }
        return INSTANCE;

    }

//    private static RoomDatabase.Callback aRoomDatabaseCallBack = new RoomDatabase.Callback(){
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//
//            DATABASE_WRITE_EXECUTOR.execute(()->{
//
//                AdminDao adminDao = INSTANCE.adminDao();
//
//                adminDao.deleteAllAdmins();
//
//                Admin admin1 = new Admin("Adeniran", "ade1234");
//                Admin admin2 = new Admin("Bashorun Ga", "bashorun1234");
//                Admin admin3 = new Admin("Rehoboth", "hack123");
//                Admin admin = new Admin("uu", "pp");
//
//                adminDao.insert(admin1);
//                Log.d("ADMIN1_TAG", "Admin1 was added sucessfully");
//                adminDao.insert(admin2);
//                adminDao.insert(admin3);
//                adminDao.insert(admin1);
//
//            });
//        }
//    };

}

