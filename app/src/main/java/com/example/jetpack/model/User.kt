package com.example.lesstion_1.model

class User(val id:Int,val name:String, val old:Int) {
    override fun toString(): String {
        return "User(id=$id, name='$name', old=$old)"
    }
}