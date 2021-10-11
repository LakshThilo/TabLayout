package com.example.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.lak.httpurlconnection.model.local.entities.TableSchema

// This is the implementation of Sqlite open helper

/**
 *  Help to create the SQLite database
 *  @param Context, Database Name, Database version
 *  Database version define the current schema
 * */
class BookSqlite(private val context: Context)  : SQLiteOpenHelper(
    context,
    "book_sqlite",
    null, // this factory is used to create multiple databases
    1
){

    // Create tables for the database
    override fun onCreate(p0: SQLiteDatabase?) {

        p0?.execSQL("CREATE TABLE "+
                "${TableSchema.bookTableName} "+
                "(${TableSchema.bookTitleColumn} VARCHAR(255));")

        p0?.execSQL("CREATE TABLE "+
                        "${TableSchema.authorTableName} "+
                        "(${TableSchema.authorNameColumn} VARCHAR(255));")

        p0?.execSQL("CREATE TABLE "+
                "${TableSchema.industryTableName} "+
                "(${TableSchema.industryTypeColumn} VARCHAR(255), " +
                "${TableSchema.industryIdentifierColumn} VARCHAR(255));")
    }

    // Used when the schema changes, to migrate the previous data to the new schema impl
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}