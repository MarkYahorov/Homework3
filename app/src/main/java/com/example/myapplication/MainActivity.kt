package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlin.random.Random

interface MyInterface {
    fun startQuestions()
    fun finishQuestions()
    fun answerQuestion(position: Int, result: Boolean)
}

class MainActivity : AppCompatActivity(), MyInterface {

    var count = 0
    var array = arrayOf("1","2", "3","4","5" )
    var array2 = arrayOf(true, false,false, true,true)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    private fun initFragment() {
        replaceFragment(FirstFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    override fun finishQuestions() {
        replaceFragment(ResultFragment())
    }

    override fun startQuestions() {
        val index = 0
        replaceFragment(QuestionsFragment.newInstance(index, array[index], array2[index]))
    }

    override fun answerQuestion(position: Int, result: Boolean) {
        val index = position+1
        val index2 = position
        if (array.size > index) {
            replaceFragment(QuestionsFragment.newInstance(index, array[index], array2[index2] ));
            if (array2[index2]== result && array2[index2]==result){
                count+=1
            }else{
                count +=0
            }

        } else {
            finishQuestions()
            Toast.makeText(this,"$count", Toast.LENGTH_SHORT).show()
        }
    }






}
