package com.aotter.trek.android.kotlin.demo.trek.supr_ad

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.aotter.net.dto.mftc.response.AdData
import com.aotter.net.trek.AotterTrek
import com.aotter.net.trek.ads.TrekAd
import com.aotter.net.trek.ads.TrekAdStatusCallBack
import com.aotter.trek.android.kotlin.demo.trek.CoverPageActivity
import com.aotter.trek.demo.databinding.ActivityVastScrollPageBinding

class TrekMediaScrollPageActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityVastScrollPageBinding

    private lateinit var trekAd: TrekAd

    private lateinit var trekAd2: TrekAd

    private lateinit var trekAd3: TrekAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityVastScrollPageBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        AotterTrek.initAotterService(
            this@TrekMediaScrollPageActivity,
            "DNgNhOwfbUkOqcQFI+uD"
        ) {}

        trekAd = AotterTrek.trekService(this)
        trekAd2 = AotterTrek.trekService(this)
        trekAd3 = AotterTrek.trekService(this)

        initView()

        getVastAd()
        getVastAd2()
//            getVastAd3()


    }

    private fun initView() {

        viewBinding.refreshBtn.setOnClickListener {

            trekAd.setPlaceUid("81608f91-8b2b-4f8f-86a1-539a1959f836").setCategory("news")
                .applyTrekAd()

        }

        viewBinding.coverpageBtn.setOnClickListener {

            val intent = Intent()
            intent.setClass(this, CoverPageActivity::class.java)
            startActivity(intent)

        }

    }

    private fun getVastAd() {

        trekAd.setTrekAdStatusListener(object : TrekAdStatusCallBack {
            override fun onAdError(message: String) {
                Log.e("onAdError", message)
            }

            override fun onAdLoaded(adData: AdData) {

                trekAd.registerSuprAd(
                    viewBinding.container,
                    viewBinding.trekMediaView4,
                    adData
                )

            }

            override fun onAdClicked(adData: AdData) {
                Log.e("onAdClicked", "AdClicked success.")
            }

            override fun onAdImpression(view: View) {
                Log.e("onAdImpression", "AD Impression success.")

            }

        })

        trekAd.setPlaceUid("81608f91-8b2b-4f8f-86a1-539a1959f836").setCategory("news").applyTrekAd()

    }

    private fun getVastAd2() {

        trekAd2.setTrekAdStatusListener(object : TrekAdStatusCallBack {
            override fun onAdError(message: String) {
                Log.e("onAdError", message)
            }

            override fun onAdLoaded(adData: AdData) {

                trekAd2.registerSuprAd(
                    viewBinding.container2,
                    viewBinding.trekMediaView10,
                    adData
                )

            }

            override fun onAdClicked(adData: AdData) {
                Log.e("onAdClicked", "AdClicked success.")
            }

            override fun onAdImpression(view: View) {
                Log.e("onAdImpression", "AD2 Impression success.")

            }

        })

        trekAd2.setPlaceUid("81608f91-8b2b-4f8f-86a1-539a1959f836").setCategory("news")
            .applyTrekAd()

    }


    private fun getVastAd3() {

        trekAd3.setTrekAdStatusListener(object : TrekAdStatusCallBack {
            override fun onAdError(message: String) {
                Log.e("onAdError", message)
            }

            override fun onAdLoaded(adData: AdData) {

                trekAd.registerSuprAd(
                    viewBinding.container3,
                    viewBinding.trekMediaView5,
                    adData
                )

            }

            override fun onAdClicked(adData: AdData) {
                Log.e("onAdClicked", "AdClicked success.")
            }

            override fun onAdImpression(view: View) {
                Log.e("onAdImpression", "AD3 Impression success.")

            }

        })

        trekAd3.setPlaceUid("81608f91-8b2b-4f8f-86a1-539a1959f836").setCategory("news")
            .applyTrekAd()

    }


}