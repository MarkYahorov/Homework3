package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

private const val TEXT = "param_text"
private const val ID = "param_id"
private const val RES = "param_res"


class QuestionsFragment : Fragment() {
    private var id: Int? = null
    private var text: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt(ID)
            text = it.getString(TEXT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(
            R.layout.fragment_questions,
            container,
            false
        )
        root.findViewById<TextView>(R.id.question1).text = text
        return root
    }

    override fun onStart() {
        super.onStart()
        view?.findViewById<Button>(R.id.button_yes)?.setOnClickListener {
            (requireActivity() as MyInterface).answerQuestion(id!!, true)
        }
        view?.findViewById<Button>(R.id.button_no)?.setOnClickListener {
            (requireActivity() as MyInterface).answerQuestion(id!!, false)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(id: Int, text: String, res:Boolean) =
            QuestionsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ID, id)
                    putString(TEXT, text)
                    putBoolean(RES, res)
                }
            }
    }
}