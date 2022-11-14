package com.example.life

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.life.databinding.FragmentLifeBinding

class LifeFragment : Fragment() {

    private var _binding: FragmentLifeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLifeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.moneySwitch.setOnClickListener {
            checkPossibility(
                view = it
            )
        }

        binding.friendsSwitch.setOnClickListener {
            checkPossibility(
                view = it
            )
        }

        binding.loveSwitch.setOnClickListener {
            checkPossibility(
                view = it
            )
        }
    }

    private fun checkPossibility(
        view: View
    ) {
        if (binding.moneySwitch.isChecked && binding.friendsSwitch.isChecked && binding.loveSwitch.isChecked) {
            when ((1..3).random()) {
                1 -> if (view != binding.moneySwitch) {
                    binding.moneySwitch.isChecked = !binding.moneySwitch.isChecked
                }
                2 -> if (view != binding.friendsSwitch) {
                    binding.friendsSwitch.isChecked = !binding.friendsSwitch.isChecked
                }
                3 -> if (view != binding.loveSwitch) {
                    binding.loveSwitch.isChecked = !binding.loveSwitch.isChecked
                }
            }
            if (checkWhile(view)) {
                checkPossibility(view)
            }
        }
    }

    private fun checkWhile(view: View): Boolean {
        if (view == binding.moneySwitch) {
            return binding.moneySwitch.isChecked
        }
        if (view == binding.friendsSwitch) {
            return binding.friendsSwitch.isChecked
        }
        if (view == binding.loveSwitch) {
            return binding.loveSwitch.isChecked
        }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}