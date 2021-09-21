package com.tbadhit.myflexiblefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit

// Update code in activity_main.xml (1)
// Create HomeFragment class (new/Fragment/Fragment(blank))
// Update code in fragment_home.xml (1)
// Update code in HomeFragment (1)
// Update code in MainActivity (1)

// #Flexible Fragment
// Create CategoryFragment class (new/Fragment/Fragment(blank))
// Update code in fragment_category.xml (1)
// Update code in CategoryFragment (1)
// Add some code in HomeFragment (2)

// Create DetailCategoryFragment class (new/Fragment/Fragment(blank))
// Update code in fragment_detail_category.xml (1)
// Update code in DetailCategoryFragment (1)
// Add some code in CategoryFragment (2)

// Create OptionDialogFragment class (new/Fragment/Fragment(blank))
// Update code in fragment_option_dialog.xml (1)
// Update code in OptionDialogFragment (1)
// Add some code in DetailCategoryFragment (2)

// #CALL ACTIVITY FROM FRAGMENT
// Create ProfileActivity (new/Activity/Empty Activity)
// Update code in activity_profile.xml (1)
// Add some code in DetailCategoryFragment (3)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // (1) Add Fragment (Required!)
        val mFragmentManager = supportFragmentManager
        val mHomeFragment = HomeFragment()
        val fragment = mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (fragment !is HomeFragment) {
            Log.d("MyFlexibleFragment", "Fragment Name :" + HomeFragment::class.java.simpleName)
            // Use kotlinX :
            mFragmentManager.commit {
                add(R.id.frame_container, mHomeFragment, HomeFragment::class.java.simpleName)
            }

//            Before use KotlinX:
//            mFragmentManager
//                .beginTransaction()
//                .add(R.id.frame_container, mHomeFragment, HomeFragment::class.java.simpleName)
//                .commit()
        }
        // ---End Add Fragment---
    }
}