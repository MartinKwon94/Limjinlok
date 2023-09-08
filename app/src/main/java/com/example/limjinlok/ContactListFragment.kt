package com.example.limjinlok

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.limjinlok.databinding.FragmentContactlistBinding
import com.example.limjinlok.model.ContactListData

class ContactListFragment : Fragment() {

    private var _binding: FragmentContactlistBinding? = null
    private val binding get() = _binding!!
    private val dataList by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelableArrayList("key", ContactListData::class.java)
        } else {
            arguments?.getParcelableArrayList("key")
        }
    }

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
        val adapter = dataList?.let {
            ContactListAdapter(it) { position, item ->
                // ToDo contactdetialacitivy로 넘어가기 position은 이게 몇번째 아이템인지 item은 해당 아이템의 data만 들어가 있습니다.
            }
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }


    companion object {

        lateinit var arguments: Bundle

        @JvmStatic
        fun newInstance(dataList: ArrayList<ContactListData>) = ContactListFragment().apply {
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
