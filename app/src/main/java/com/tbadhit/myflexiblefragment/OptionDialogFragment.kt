package com.tbadhit.myflexiblefragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment

// (1) Change to DialogFragment()
// (DialogFragment()) = merupakan obyek dialog yang akan tampil mengambang di layar
class OptionDialogFragment : DialogFragment() {

    // (1)
    private lateinit var btnChoose: Button
    private lateinit var btnClose: Button
    private lateinit var rgOptions: RadioGroup
    private lateinit var rbSaf: RadioButton
    private lateinit var rbMou: RadioButton
    private lateinit var rbLvg: RadioButton
    private lateinit var rbMoyes: RadioButton
    private var optionDialogListener: OnOptionDialogListener? = null
    //------

    // (1)
    // Interface adalah sebuah kelas yang terdiri kumpulan method..
    // yang hanya memuat deklarasi dan struktur method, tanpa detail implementasinya
    interface OnOptionDialogListener {
        fun onOptionChoose(text: String?)
    }

    // (1)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    // (1)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // (1)
        btnChoose = view.findViewById(R.id.btn_choose)
        btnClose = view.findViewById(R.id.btn_close)
        rgOptions = view.findViewById(R.id.rg_options)
        rbSaf = view.findViewById(R.id.rb_saf)
        rbLvg = view.findViewById(R.id.rb_lvg)
        rbMou = view.findViewById(R.id.rb_mou)
        rbMoyes = view.findViewById(R.id.rb_moyes)

        btnChoose.setOnClickListener {
            val checkRadioButtonId = rgOptions.checkedRadioButtonId
            if (checkRadioButtonId != -1) {
                var coach: String? = null
                when (checkRadioButtonId) {
                    R.id.rb_saf -> coach = rbSaf.text.toString().trim()

                    R.id.rb_mou -> coach = rbMou.text.toString().trim()

                    R.id.rb_lvg -> coach = rbLvg.text.toString().trim()

                    R.id.rb_moyes -> coach = rbMoyes.text.toString().trim()
                }
                optionDialogListener?.onOptionChoose(coach)
                dialog?.dismiss()
            }
        }

        btnClose.setOnClickListener{
            dialog?.cancel()
        }
        //-----
    }

    // (1)
    override fun onAttach(context: Context) {
        super.onAttach(context)

        val fragment = parentFragment

        if (fragment is DetailCategoryFragment) {
            // Kalo (optionDialogListener) merah biarkan dlu, karna belum di tambahkan di DetailCategoryFragmentnya
            this.optionDialogListener = fragment.optionDialogListener
        }
    }

    // (1)
    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }

}