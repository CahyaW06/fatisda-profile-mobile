package com.example.fatisdaprofilemobile.ui.profil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fatisdaprofilemobile.R


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ProfilFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

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
        val view = inflater.inflate(R.layout.fragment_profil, container, false)
        val button: Button = view.findViewById(R.id.button)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_profilFragment_to_sejarahFragment)
        }
        val button2: Button = view.findViewById(R.id.button2)
        button2.setOnClickListener {
            findNavController().navigate(R.id.action_profilFragment_to_VisiMisiTujuanFragment)
        }
        val button3: Button = view.findViewById(R.id.button3)
        button3.setOnClickListener {
            findNavController().navigate(R.id.action_profilFragment_to_KompetensiFragment)
        }
        return view

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfilFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}