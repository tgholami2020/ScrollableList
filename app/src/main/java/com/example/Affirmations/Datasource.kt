package com.example.Affirmations

import com.example.Affirmations.model.Affirmation
import com.example.scrollablelist.R

class Datasource() {
    fun loadAffirmation(): List<Affirmation>{
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.mint),
            Affirmation(R.string.affirmation2, R.drawable.argan),
            Affirmation(R.string.affirmation3, R.drawable.keratin),
            Affirmation(R.string.affirmation4, R.drawable.wheat_q10),
        )
    }
}