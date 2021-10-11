package com.lak.httpurlconnection.model.local.entities


/** this class help you to create name of the field - representation of data*/
data class BookTable(
    val title: String
)

data class AuthorTable(
    val name: String
)

data class IndustryTable(
    val type: String,
    val identifier: String
)

// this class help to identify tableName columns - we gonna use this one onCreate of the database
object TableSchema{


    val bookTableName: String = "books"
    val authorTableName:String = "author"
    val industryTableName: String = "industry"

    // name of the columns
    val bookTitleColumn: String = "book_name"
    val authorNameColumn:String = "author_name"
    val industryTypeColumn: String = "industry_type"
    val industryIdentifierColumn: String = "industry_id"
}