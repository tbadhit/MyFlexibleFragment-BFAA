package com.tbadhit.myflexiblefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.commit

class HomeFragment : Fragment(), View.OnClickListener {

    // (1)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    // (1)
    // We can use this function for initialization view and set some action
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // (1)
        val btnCategory: Button = view.findViewById(R.id.btn_category)
        btnCategory.setOnClickListener(this)
        //-----
    }

    // (1)
    override fun onClick(v: View?) {
        // (2)
        if (v?.id == R.id.btn_category) {
            val mCategoryFragment = CategoryFragment()
            // Use kotlinX :
            val mFragmentManager = parentFragmentManager
            mFragmentManager.commit {
                addToBackStack(null)
                replace(R.id.frame_container, mCategoryFragment, CategoryFragment::class.java.simpleName)
            }

//            Before use kotlinX :
//            val mFragmentManager = parentFragmentManager
//            mFragmentManager?.beginTransaction()?.apply {
//                replace(R.id.frame_container, mCategoryFragment, CategoryFragment::class.java.simpleName)
//                // If you remove (addToBackStack(null)) the fragment will not have stack
//                // and if you klik Back button the app will close because the fragment not have stack
//                addToBackStack(null)
//                commit()
//            }
        }
    }
}