package com.example.mad_final_lab.Database;

import android.provider.BaseColumns;

public final class UserMaster {

    private UserMaster(){}

    protected static class Users implements BaseColumns{

        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_TYPE = "type";

    }

    protected static class Message implements BaseColumns{

        public static final String TABLE_NAME = "message";
        public static final String COLUMN_NAME_USER = "user";
        public static final String COLUMN_NAME_SUBJECT = "subject";
        public static final String COLUMN_NAME_MESSAGE = "message";

    }

}
