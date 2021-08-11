package com.tbadhit.myflexiblefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class CategoryFragment : Fragment(), View.OnClickListener {

    // (1)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }
    // (1)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // (1)
        val btnDetailCategory: Button = view.findViewById(R.id.btn_detail_category)
        btnDetailCategory.setOnClickListener(this)
        //-----
    }

    // (1)
    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_detail_category) {
            // (2)
            val mDetailCategoryFragment = DetailCategoryFragment()

            // Bundle = Merupakan kelas map data string untuk object" parcelable.
            val mBundle = Bundle()
            mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "Tubagus Adhitya Permana")
            val description = "Tubagus Adhitya Permana adalah makhluk hidup yang selalu bernafas"

            mDetailCategoryFragment.arguments = mBundle
            mDetailCategoryFragment.description = description

            val mFragmentManager = parentFragmentManager
            mFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_container, mDetailCategoryFragment, DetailCategoryFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
            //-----
        }
    }


}