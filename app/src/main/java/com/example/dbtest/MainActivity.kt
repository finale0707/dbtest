package com.example.dbtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val insertBtn: FloatingActionButton = findViewById(R.id.insert_btn)
        insertBtn.setOnClickListener {
            val intent: Intent = Intent(this, InsertActivity::class.java)

            activityResult.launch(intent)
        }

        // RecyclerView 설정
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // UserAdapter 초기화
        adapter = UserAdapter()

        // Adapter 적용
        recyclerView.adapter = adapter

        // 사용자 조회
        loadUserList()
    }

    private val activityResult: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode== RESULT_OK){
            // 돌아온 값이 OK라면

            //사용자 조회
            loadUserList()
            }
        }


    private fun loadUserList(){
        val db: AppDatabase? = AppDatabase.getDatabase(applicationContext)

        val userList: List<User> = db?.userDao()!!.getAllUser()

        if(userList.isNotEmpty()) {

            // 데이터 적용용
           adapter.setUserList(userList)
        }
    }
}