package com.aotter.trek.android.kotlin.demo.trek.banner_ad

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.aotter.net.dto.mftc.response.AdData
import com.aotter.net.trek.AotterTrek
import com.aotter.net.trek.ads.TrekAdRequest
import com.aotter.net.trek.ads.TrekAdStatusCallBack
import com.aotter.trek.demo.databinding.ActivityBannerAdScrollPageBinding

class TrekBannerAdScrollPageActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityBannerAdScrollPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityBannerAdScrollPageBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)


        AotterTrek.initAotterService(
            this@TrekBannerAdScrollPageActivity,
            "DNgNhOwfbUkOqcQFI+uD"
        ) {}

        loadBannerAd()

    }

    private fun loadBannerAd() {

        val bannerAd = AotterTrek.trekService(this)

        bannerAd.setTrekAdStatusListener(object : TrekAdStatusCallBack {
            override fun onAdError(message: String) {
                Log.e("onAdError", message)
            }

            override fun onAdLoaded(adData: AdData) {

                bannerAd.registerBannerAd(
                    viewBinding.trekBannerView,
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

        val trekAdRequest = TrekAdRequest().Builder()
            .setCategory("news")
            .setContentUrl("https://agirls.aotter.net/")
            .setContentTitle("電獺少女")
            .build()

        bannerAd.setPlaceUid("68856f90-83b7-4f09-98d4-7f480842cb02")
            .applyTrekAd(trekAdRequest)

    }


}