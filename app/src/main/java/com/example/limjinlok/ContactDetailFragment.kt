package com.example.limjinlok

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.limjinlok.databinding.FragmentContactDetailBinding


class ContactDetailFragment : Fragment() {
    private var adapter = ContactDetailAdapter()

    private var _binding: FragmentContactDetailBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactDetailBinding.inflate(inflater, container, false)

        binding.cdRecyclerview.adapter = adapter
        binding.cdRecyclerview.layoutManager = LinearLayoutManager(context)

        val args = arguments
        if (args != null) {

            val ctPic = args.getInt("image", 0)
            val aName = args.getString("name")
            val aNumber = args.getString("number")
            val aNickname = args.getString("nickname")

            binding.ctPic.setImageResource(ctPic)
            binding.aName.text = arguments?.getString("name")
            binding.aNumber.text = arguments?.getString("number")
            binding.aNickname.text = arguments?.getString("nickname")
        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
