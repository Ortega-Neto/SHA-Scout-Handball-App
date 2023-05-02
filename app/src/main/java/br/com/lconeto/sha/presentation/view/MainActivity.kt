package br.com.lconeto.sha.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.lconeto.library.domain.session.InitSession
import br.com.lconeto.sha.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instanceSession()
        instanceMainFeaturesFragment()
    }

    private fun instanceSession() {
        InitSession(applicationContext)
    }

    private fun instanceMainFeaturesFragment() {
        val mainFeaturesFragment = MainFeaturesFragment.newInstance()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentContainerViewMain, mainFeaturesFragment)
        transaction.commit()
    }
}
