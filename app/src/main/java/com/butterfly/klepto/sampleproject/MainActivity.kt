package com.butterfly.klepto.sampleproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.error_layout.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        easyNetworkView.setContentLayout(R.layout.main_activity_content_layout)
        easyNetworkView.setErrorLayout(R.layout.error_layout)
        easyNetworkView.showProgress()
        root.postDelayed({
            easyNetworkView.showContent()
        },3000)
        root.postDelayed({
            (easyNetworkView.getErrorView() as ConstraintLayout).errorMessage.text =
                    "This is an error created by you yourself"
            easyNetworkView.showError()
        },6000)

    }
}
