package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.lab_week_4.ListFragment
import com.example.lab_week_4.R

class DetailFragment : Fragment() {

    private val coffeeTitle: TextView?
        get() = view?.findViewById(R.id.coffee_title)
    private val coffeeDesc: TextView?
        get() = view?.findViewById(R.id.coffee_desc)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mendapatkan ID kopi dari argumen
        val coffeeId = arguments?.getInt(ListFragment.COFFEE_ID)
        coffeeId?.let {
            // Menampilkan detail kopi yang sesuai
            setCoffeeData(it)
        }

        // Set up the back button
        val backButton = view.findViewById<Button>(R.id.back_button)
        backButton.setOnClickListener {
            // Navigate back to ListFragment
            Navigation.findNavController(view).navigateUp()
        }
    }

    // Method to update coffee details
    private fun setCoffeeData(id: Int) {
        when (id) {
            R.id.affogato -> {
                coffeeTitle?.text = getString(R.string.affogato_title)
                coffeeDesc?.text = getString(R.string.affogato_desc)
            }

            R.id.americano -> {
                coffeeTitle?.text = getString(R.string.americano_title)
                coffeeDesc?.text = getString(R.string.americano_desc)
            }

            R.id.latte -> {
                coffeeTitle?.text = getString(R.string.latte_title)
                coffeeDesc?.text = getString(R.string.latte_desc)
            }

            R.id.cappuccino -> {
                coffeeTitle?.text = getString(R.string.cappuccino_title)
                coffeeDesc?.text = getString(R.string.cappuccino_desc)
            }

            R.id.coldbrew -> {
                coffeeTitle?.text = getString(R.string.coldbrew_title)
                coffeeDesc?.text = getString(R.string.coldbrew_desc)
            }

            R.id.tes -> {
                coffeeTitle?.text = getString(R.string.coldbrew_title)
                coffeeDesc?.text = getString(R.string.coldbrew_desc)
            }

            else -> {
                // Menangani jika ID kopi tidak dikenal
            }
        }
    }

    companion object {
        private const val COFFEE_ID = "COFFEE_ID"
    }
}