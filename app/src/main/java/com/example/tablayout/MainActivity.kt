package com.example.tablayout

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.local.BookSqlite
import com.lak.httpurlconnection.model.local.entities.TableSchema

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //SQLITE
        insertBookProcess()
        Thread.sleep(1000)
        readBookProcess()
    }

    private fun insertBookProcess() {
        // get a SQLite Database object for writing
        // create the content value
        // insert in the DB

        val writingDB = BookSqlite(this).writableDatabase
        val bookContentValues = ContentValues()
        bookContentValues.put(
            TableSchema.bookTitleColumn, "The name of your favourite book"
        )

        // return -1 operation fail
        // return index position
        val position =
            writingDB.insert(
                TableSchema.bookTableName,
                null,
                bookContentValues
            )
        if (position == -1L){
            Toast.makeText(this, "error inserting data", Toast.LENGTH_SHORT).show()
        }
    }

    private fun readBookProcess(){

        // get the readable DB object
        //construct SQL statement
        // iterate the Cursor
        // display data

        val readingDB = BookSqlite(this).readableDatabase
        //readingDB.execSQL("SELECT * FROM BOOK_TABLE")
        val cursor =
            readingDB.query(
                TableSchema.bookTableName,
                arrayOf(TableSchema.bookTitleColumn),
                null,
                null,
                null,
                null,
                null

            )
        while (cursor.moveToNext()){
            val title = cursor.getString(
                cursor.getColumnIndexOrThrow(
                    TableSchema.bookTitleColumn))
            Toast.makeText(this, title, Toast.LENGTH_SHORT).show()
        }

        readingDB.close()
    }

}