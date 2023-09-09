package com.example.limjinlok

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.limjinlok.databinding.FragmentMyPageBinding
import com.example.limjinlok.model.ContactListData

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MyPageFragment : Fragment() {

    private var _binding: FragmentMyPageBinding? = null
    private val binding get() = _binding!!
    private val dataList by lazy {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            arguments?.getParcelableArrayList("key", ContactListData::class.java)
        } else {
            arguments?.getParcelableArrayList("key")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyPageBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewContacts)
        val adapter = dataList?.let { ContactListAdapter(it) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        val binding = FragmentMyPageBinding.bind(view)

//        binding.asdasd.setOnClickListenr {
//            val name = binding.text.toString()
//            val number = binding.text.toString()
//            val email = binding.text.toString()
//            val comment = binding.text.toString()
//        }
    }
    lateinit var arguments : Bundle


    companion object {

        @JvmStatic
        fun newInstance(dataList: ArrayList<ContactListData>) = MyPageFragment().apply {
            arguments = Bundle().apply {
                putParcelableArrayList("key", dataList)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}