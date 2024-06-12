package com.example.fatisdaprofilemobile.ui.profil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fatisdaprofilemobile.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class SejarahFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var rvText: RecyclerView
    private val list = ArrayList<Text>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvText = view.findViewById(R.id.rv_Text)
        rvText.setHasFixedSize(true)
        rvText.layoutManager = LinearLayoutManager(context)

        list.addAll(getListMovies())
        rvText.adapter = ListTextAdapter(list)

        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getListMovies(): ArrayList<Text> {
        val dataName = resources.getStringArray(R.array.data_name2)
        val dataDesc = resources.getStringArray(R.array.data_desc2)
        val listText = ArrayList<Text>()
        for (i in dataName.indices) {
            val text = Text(dataName[i], dataDesc[i], -1)
            listText.add(text)
        }
        return listText
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SejarahFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}