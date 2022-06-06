package com.aotter.trek.demo.trek.native_ad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aotter.net.dto.trek.response.TrekNativeAd
import com.aotter.net.trek.ads.TrekAdListener
import com.aotter.net.trek.ads.TrekAdLoader
import com.aotter.net.trek.ads.TrekAdRequest
import com.aotter.trek.demo.databinding.ActivityNativeAdRecyclerviewPageBinding
import com.aotter.trek.demo.trek.LocalNativeAdData
import com.aotter.trek.demo.trek.NativeAdAdapter

class TrekNativeAdRecyclerViewPageActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityNativeAdRecyclerviewPageBinding

    private lateinit var nativeAdAdapter: NativeAdAdapter

    private var trekAdLoader: TrekAdLoader? = null

    private var trekAdRequest: TrekAdRequest? = null

    private var trekAdLoader2: TrekAdLoader? = null

    private var trekAdRequest2: TrekAdRequest? = null

    private var list: MutableList<LocalNativeAdData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityNativeAdRecyclerviewPageBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        initView()

        getAd()

    }


    private fun initView() {

        viewBinding.refreshBtn.setOnClickListener {

            trekAdRequest?.let {
                trekAdLoader?.loadAd(it)
            }

        }


        nativeAdAdapter = NativeAdAdapter()

        val linearLayoutManager = LinearLayoutManager(this)

        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        viewBinding.nativeAdRecyclerView.layoutManager = linearLayoutManager

        viewBinding.nativeAdRecyclerView.adapter = nativeAdAdapter

        repeat(12) {
            list.add(
                    LocalNativeAdData(
                            "幸運調色盤：12星座明天穿什麼？（6/6-6/12）",
                            "電獺少女",
                            "http://pnn.aotter.net/Media/show/d8404d54-aab7-4729-8e85-64fb6b92a84e.jpg"
                    )
            )
        }

        nativeAdAdapter.update(list)


    }

    private fun getAd() {

        trekAdLoader = TrekAdLoader
                .Builder(this, "45419fb5-a846-4c4a-837f-3b391ec7b45a")
                .withAdListener(object : TrekAdListener {
                    override fun onAdFailedToLoad(message: String) {
                        super.onAdFailedToLoad(message)

                    }

                    override fun onAdLoaded(trekNativeAd: TrekNativeAd) {
                        super.onAdLoaded(trekNativeAd)

                        Log.e("trekNativeAd", trekNativeAd.toString())

                        list[4] = LocalNativeAdData(
                                "幸運調色盤：12星座明天穿什麼？（6/6-6/12）",
                                "電獺少女",
                                "http://pnn.aotter.net/Media/show/d8404d54-aab7-4729-8e85-64fb6b92a84e.jpg",
                                trekNativeAd
                        )

                        getAd2()

                    }

                    override fun onAdClicked() {
                        super.onAdClicked()

                        Log.e("onAdClicked", "onAdClicked")

                    }

                    override fun onAdImpression() {
                        super.onAdImpression()

                        Log.e("onAdImpression", "onAdImpression")

                    }
                })
                .build()

        trekAdRequest = TrekAdRequest.Builder()
                .setCategory("NEWS")
                .setContentUrl("https://agirls.aotter.net/")
                .setContentTitle("電獺少女")
                .build()

        trekAdRequest?.let {
            trekAdLoader?.loadAd(it)
        }

    }

    private fun getAd2() {

        trekAdLoader2 = TrekAdLoader
                .Builder(this, "81608f91-8b2b-4f8f-86a1-539a1959f836")
                .withAdListener(object : TrekAdListener {
                    override fun onAdFailedToLoad(message: String) {
                        super.onAdFailedToLoad(message)

                    }

                    override fun onAdLoaded(trekNativeAd: TrekNativeAd) {
                        super.onAdLoaded(trekNativeAd)

                        Log.e("trekNativeAd", trekNativeAd.toString())

                        list[9] = LocalNativeAdData(
                                "幸運調色盤：12星座明天穿什麼？（6/6-6/12）",
                                "電獺少女",
                                "http://pnn.aotter.net/Media/show/d8404d54-aab7-4729-8e85-64fb6b92a84e.jpg",
                                trekNativeAd
                        )

                        nativeAdAdapter.update(list)

                    }

                    override fun onAdClicked() {
                        super.onAdClicked()

                        Log.e("onAdClicked", "onAdClicked")

                    }

                    override fun onAdImpression() {
                        super.onAdImpression()

                        Log.e("onAdImpression", "onAdImpression")

                    }
                })
                .build()

        trekAdRequest2 = TrekAdRequest.Builder()
                .setCategory("NEWS")
                .setContentUrl("https://agirls.aotter.net/")
                .setContentTitle("電獺少女")
                .build()

        trekAdRequest2?.let {
            trekAdLoader2?.loadAd(it)
        }

    }


}