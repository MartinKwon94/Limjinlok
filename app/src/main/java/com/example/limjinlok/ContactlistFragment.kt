package com.example.limjinlok

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.limjinlok.databinding.FragmentContactlistBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ContactlistFragment : Fragment() {

    private var _binding: FragmentContactlistBinding? = null
    private val binding get() = _binding!!
    private var dataList: List<ContactlistData>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactlistBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // RecyclerView를 찾아서 어댑터와 레이아웃 매니저를 설정합니다.
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewContacts)
        val adapter = ContactlistAdapter(requireContext() as MainActivity,
            (dataList ?: emptyList()) as MutableList<ContactlistData>
        )
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }


    companion object {

        lateinit var arguments: Bundle

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ContactlistFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
