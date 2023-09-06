package com.example.limjinlok

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.limjinlok.databinding.FragmentContactDetailBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ContactDetailFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentContactDetailBinding? = null
    private val binding get() = _binding!!

    //데이터 원본 필요
//    private val data: 어댑터? by lazy {
//        arguments?.getParcelable<어댑터>
//    }
//    lateinit var receiveData: 어댑터


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactDetailBinding.inflate(inflater, container, false)

//        arguments?.getInt(image)
//        binding.Name.text =
//        binding.Number.text =
//        binding.Nickname.text =
//            //어댑터에서 받아오기?

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ContactDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }


        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }
}