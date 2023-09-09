package com.example.limjinlok

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.limjinlok.model.ContactListData

class ContactListAdapter(
    val mItems: ArrayList<ContactListData>,
    val actions: (Int, ContactListData) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_EVEN = 0
    private val TYPE_ODD = 1
    private val TYPE_GRID = 2

    override fun getItemViewType(position: Int): Int {
        return when (position % 2) {
            0 -> TYPE_EVEN
            1 -> TYPE_ODD
            else -> TYPE_GRID
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_EVEN -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_contactlist, parent, false)
                ContactViewHolder(view, actions)
            }

            TYPE_ODD -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_contactlist_odd, parent, false)
                ContactViewHolderOdd(view, actions)
            }

            TYPE_GRID -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_contactlist_grid, parent, false)
                ContactViewHolderGrid(view, actions)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item: ContactListData = mItems[position]
        when (holder) {
            is ContactViewHolder -> {
                holder.profileImage.setImageResource(item.userImage)
                holder.tv_name.text = item.userData[0].content
                holder.tv_nickname.text = item.userData[1].content
                holder.favBut.setOnClickListener {
                    item.isFavorite = !item.isFavorite
                    if (item.isFavorite)
                        holder.favBut.setImageResource(R.drawable.staron)
                    else
                        holder.favBut.setImageResource(R.drawable.staroff)
                }
                if (item.userData[1].content.length > 4) {
                    val shortenedText = item.userData[1].content.substring(0, 4) + "..."
                    holder.tv_nickname.text = shortenedText

                    // 클릭 이벤트 핸들러를 설정하여 전체 내용을 보이게 함
                    holder.tv_nickname.setOnClickListener {
                        holder.tv_nickname.text = item.userData[1].content
                        holder.tv_nickname.setOnClickListener(null)
                    }
                } else {
                    holder.tv_nickname.text = item.userData[1].content
                }
                if (item.userData[0].content.length > 3) {
                    val shortenedText = item.userData[0].content.substring(0, 3) + "..."
                    holder.tv_name.text = shortenedText

                    // 클릭 이벤트 핸들러를 설정하여 전체 내용을 보이게 함
                    holder.tv_name.setOnClickListener {
                        holder.tv_name.text = item.userData[0].content
                        holder.tv_name.setOnClickListener(null)
                    }
                } else {
                    holder.tv_name.text = item.userData[0].content
                }
            }

            is ContactViewHolderOdd -> {
                holder.Od_profileImage.setImageResource(item.userImage)
                holder.Od_tv_name.text = item.userData[0].content
                holder.Od_tv_nickname.text = item.userData[1].content
                holder.Od_favBut.setOnClickListener {
                    item.isFavorite = !item.isFavorite
                    if (item.isFavorite)
                        holder.Od_favBut.setImageResource(R.drawable.staron)
                    else
                        holder.Od_favBut.setImageResource(R.drawable.staroff)
                }
                if (item.userData[1].content.length > 4) {
                    val shortenedText = item.userData[1].content.substring(0, 4) + "..."
                    holder.Od_tv_nickname.text = shortenedText

                    // 클릭 이벤트 핸들러를 설정하여 전체 내용을 보이게 함
                    holder.Od_tv_nickname.setOnClickListener {
                        holder.Od_tv_nickname.text = item.userData[1].content
                        holder.Od_tv_nickname.setOnClickListener(null)
                    }
                } else {
                    holder.Od_tv_nickname.text = item.userData[1].content
                }
                if (item.userData[0].content.length > 3) {
                    val shortenedText = item.userData[0].content.substring(0, 3) + "..."
                    holder.Od_tv_name.text = shortenedText

                    // 클릭 이벤트 핸들러를 설정하여 전체 내용을 보이게 함
                    holder.Od_tv_name.setOnClickListener {
                        holder.Od_tv_name.text = item.userData[0].content
                        holder.Od_tv_name.setOnClickListener(null)
                    }
                } else {
                    holder.Od_tv_name.text = item.userData[0].content
                }
            }

            is ContactViewHolderGrid -> {
                holder.gr_profileImage.setImageResource(item.userImage)
                holder.gr_tv_name.text = item.userData[0].content
                holder.gr_tv_nickname.text = item.userData[1].content
                if (item.userData[1].content.length > 4) {
                    val shortenedText = item.userData[1].content.substring(0, 4) + "..."
                    holder.gr_tv_nickname.text = shortenedText

                    // 클릭 이벤트 핸들러를 설정하여 전체 내용을 보이게 함
                    holder.gr_tv_nickname.setOnClickListener {
                        holder.gr_tv_nickname.text = item.userData[1].content
                        holder.gr_tv_nickname.setOnClickListener(null)
                    }
                } else {
                    holder.gr_tv_nickname.text = item.userData[1].content
                }
                if (item.userData[0].content.length > 3) {
                    val shortenedText = item.userData[0].content.substring(0, 3) + "..."
                    holder.gr_tv_name.text = shortenedText

                    // 클릭 이벤트 핸들러를 설정하여 전체 내용을 보이게 함
                    holder.gr_tv_name.setOnClickListener {
                        holder.gr_tv_name.text = item.userData[0].content
                        holder.gr_tv_name.setOnClickListener(null)
                    }
                } else {
                    holder.gr_tv_name.text = item.userData[0].content
                }
            }
        }
    }


    override fun getItemCount(): Int {
        return mItems.size
    }

    class ContactViewHolder(itemView: View, val actions: (Int, ContactListData) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView = itemView.findViewById(R.id.ProfileImg)
        val tv_name: TextView = itemView.findViewById(R.id.tv_name)
        val tv_nickname: TextView = itemView.findViewById(R.id.tv_nickname)
        val favBut: ImageButton = itemView.findViewById(R.id.btn_fav)
    }

    class ContactViewHolderGrid(itemView: View, val actions: (Int, ContactListData) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        val gr_profileImage: ImageView = itemView.findViewById(R.id.ProfileImggrid)
        val gr_tv_name: TextView = itemView.findViewById(R.id.tv_namegrid)
        val gr_tv_nickname: TextView = itemView.findViewById(R.id.tv_nicknamegrid)
    }

    class ContactViewHolderOdd(itemView: View, val actions: (Int, ContactListData) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        val Od_profileImage: ImageView = itemView.findViewById(R.id.ProfileImgodd)
        val Od_tv_name: TextView = itemView.findViewById(R.id.tv_nameodd)
        val Od_tv_nickname: TextView = itemView.findViewById(R.id.tv_nicknameodd)
        val Od_favBut: ImageButton = itemView.findViewById(R.id.btn_favodd)
    }

}


