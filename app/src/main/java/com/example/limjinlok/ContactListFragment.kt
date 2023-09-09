package com.example.limjinlok

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
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
    private val adapter by lazy {
        dataList?.let {
            ContactListAdapter(it) { position, item ->
                val intent = Intent (activity, ContactDetailActivity::class.java)
                intent.putExtra("item_index", position)
                intent.putExtra("data", item)
                Log.d("test", item.toString())
                activity?.startActivity(intent)
            }
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
        val recyclerView = binding.recyclerViewContacts
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

    }

    fun updateData(newDataList: ArrayList<ContactListData>) {
        val adapter =  binding.recyclerViewContacts.adapter as ContactListAdapter
        adapter.updateData(newDataList)
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
