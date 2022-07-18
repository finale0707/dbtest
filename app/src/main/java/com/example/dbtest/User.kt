package com.example.dbtest

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(

    @PrimaryKey(autoGenerate = true)
    val id:Int?,

    @ColumnInfo(name="userName")
    val userName: String?,

    @ColumnInfo(name = "userAge")
    val userAge: String?,
/*
    @ColumnInfo(name="userSex")
    val userSex: String?,

    @ColumnInfo(name = "userRegion")
    val userLocal: String?,

    @ColumnInfo(name = "userBirthYear")
    val userBirthYear: Int?,

    @ColumnInfo(name = "userPhoneNumber")
    val userPhoneNumber: String?,

    @ColumnInfo(name = "userEmail")
    val userEmail: String?,

    @ColumnInfo(name = "userId")
    val userId: String?,

    @ColumnInfo(name = "userPw")
    val userPw: String?,
*/
    )
