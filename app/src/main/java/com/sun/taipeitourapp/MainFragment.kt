package com.sun.taipeitourapp

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.sun.taipeitourapp.common.Language


class MainFragment : Fragment() {

    lateinit var bt_translation : Button
    lateinit var toolbar : Toolbar
    lateinit var progressBar : ProgressBar
    lateinit var rv_user : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar = view.findViewById(R.id.toolbar)
        progressBar = view.findViewById(R.id.progressBar)
        bt_translation = toolbar.findViewById(R.id.bt_translation)
        bt_translation.setOnClickListener {
            Log.e("test","test click")
            val popup = PopupMenu(requireContext(), it)
            for (lang in Language.values()) {
                popup.menu.add(lang.name)
            }
            // Set an OnMenuItemClickListener to handle menu item clicks
            popup.setOnMenuItemClickListener { item ->
                Toast.makeText(requireContext(), "You clicked: " + item.getTitle(), Toast.LENGTH_SHORT).show()
                true
            }
            popup.show()
        }
    }
}