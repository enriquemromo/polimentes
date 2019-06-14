package com.toto.testpolimentes.db;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = ApplicationDatabase.NAME, version = ApplicationDatabase.VERSION)
public class ApplicationDatabase {

    public static final String NAME = "DataBase";

    public static final int VERSION = 1;
}
