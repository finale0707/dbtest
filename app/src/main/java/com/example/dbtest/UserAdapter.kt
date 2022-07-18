package com.example.dbtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter: RecyclerView.Adapter<UserAdapter.MyViewHolder>() {
    private lateinit var userList: List<User>

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val nameText: TextView = itemView.findViewById(R.id.name_text)
        val ageText: TextView = itemView.findViewById(R.id.age_text)
    }

    // 화면 설정
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return MyViewHolder(view)
    }

    // 데이터 설정
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameText.text = userList[holder.adapterPosition].userName
        holder.ageText.text = userList[holder.adapterPosition].userAge
    }

    // 아이템 갯수
    override fun getItemCount(): Int {
        return userList.size
    }

    // 아이템 등록
    fun setUserList(userList: List<User>){
        this.userList = userList
    }
}