package com.example.lab_week_4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coffeeList = listOf<View>(
            view.findViewById(R.id.affogato),
            view.findViewById(R.id.americano),
            view.findViewById(R.id.latte),
            view.findViewById(R.id.cappuccino),
            view.findViewById(R.id.coldbrew)
        )

        coffeeList.forEach { coffee ->
            coffee.setOnClickListener {
                // Mengirimkan ID kopi sebagai argumen
                val fragmentBundle = Bundle().apply {
                    putInt(COFFEE_ID, coffee.id)
                }
                Navigation.findNavController(it).navigate(R.id.coffeeDetail, fragmentBundle)
            }
        }
    }

    companion object {
        const val COFFEE_ID = "COFFEE_ID"
    }
}