package com.aotter.trek.demo.trek.native_ad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.aotter.net.dto.Entity
import com.aotter.net.dto.User
import com.aotter.net.dto.trek.response.TrekNativeAd
import com.aotter.net.trek.TrekDataKey
import com.aotter.net.trek.ads.TrekAdListener
import com.aotter.net.trek.ads.TrekAdLoader
import com.aotter.net.trek.ads.TrekAdRequest
import com.aotter.net.trek.sealed.ActionType
import com.aotter.net.trek.sealed.EntityType
import com.aotter.net.trek.tracker.Tracker
import com.aotter.trek.demo.databinding.ActivityNativeAdScrollPageBinding
import com.bumptech.glide.Glide
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put


class TrekNativeAdScrollPageActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityNativeAdScrollPageBinding

    private var trekAdLoader: TrekAdLoader? = null

    private var trekAdRequest: TrekAdRequest? = null

    private var trekAdLoader2: TrekAdLoader? = null

    private var trekAdRequest2: TrekAdRequest? = null

    private var trekAdLoader3: TrekAdLoader? = null

    private var trekAdRequest3: TrekAdRequest? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityNativeAdScrollPageBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        initView()

        initTracker()

        getAd()

        getAd2()

        getAd3()

    }

    private fun initView() {

        viewBinding.refreshBtn.setOnClickListener {

            trekAdRequest?.let {
                trekAdLoader?.loadAd(it)
            }

            trekAdRequest2?.let {
                trekAdLoader2?.loadAd(it)
            }

            trekAdRequest3?.let {
                trekAdLoader3?.loadAd(it)
            }

        }

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

                        Log.e("onAdLoaded", "onAdLoaded")

                        Log.e("trekNativeAd", trekNativeAd.toString())

                        viewBinding.advertiser2.text = trekNativeAd.advertiserName

                        viewBinding.adTitle2.text = trekNativeAd.title

                        Glide.with(this@TrekNativeAdScrollPageActivity)
                            .load(trekNativeAd.imgMain.drawable)
                                .into(viewBinding.adImg2)

                        viewBinding.trekNativeAdView.setNativeAd(trekNativeAd)

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
                .Builder(this, "45419fb5-a846-4c4a-837f-3b391ec7b45a")
                .withAdListener(object : TrekAdListener {
                    override fun onAdFailedToLoad(message: String) {
                        super.onAdFailedToLoad(message)

                    }

                    override fun onAdLoaded(trekNativeAd: TrekNativeAd) {
                        super.onAdLoaded(trekNativeAd)

                        Log.e("onAdLoaded", "onAdLoaded")

                        Log.e("trekNativeAd", trekNativeAd.toString())

                        viewBinding.advertiser3.text = trekNativeAd.advertiserName

                        viewBinding.adTitle3.text = trekNativeAd.title

                        Glide.with(this@TrekNativeAdScrollPageActivity)
                            .load(trekNativeAd.imgIconHd.drawable)
                                .into(viewBinding.adImg3)

                        viewBinding.trekNativeAdView2.setNativeAd(trekNativeAd)

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

    private fun getAd3() {

        trekAdLoader3 = TrekAdLoader
                .Builder(this, "81608f91-8b2b-4f8f-86a1-539a1959f836")
                .withAdListener(object : TrekAdListener {
                    override fun onAdFailedToLoad(message: String) {
                        super.onAdFailedToLoad(message)


                    }

                    override fun onAdLoaded(trekNativeAd: TrekNativeAd) {
                        super.onAdLoaded(trekNativeAd)

                        Log.e("onAdLoaded", "onAdLoaded")

                        Log.e("trekNativeAd", trekNativeAd.toString())

                        viewBinding.advertiser4.text = trekNativeAd.advertiserName

                        viewBinding.adTitle4.text = trekNativeAd.title

                        viewBinding.trekNativeAdView3.setTrekMediaView(viewBinding.trekMediaView)

                        viewBinding.trekNativeAdView3.setNativeAd(trekNativeAd)

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

        trekAdRequest3 = TrekAdRequest.Builder()
                .setCategory("NEWS")
                .setContentUrl("https://agirls.aotter.net/")
                .setContentTitle("電獺少女")
                .build()

        trekAdRequest3?.let {
            trekAdLoader3?.loadAd(it)
        }

    }

    private fun initTracker() {

        val tracker = Tracker(this)

        val jsonObject = buildJsonObject {
            put(TrekDataKey.REFERENCE, "disp")
            put(TrekDataKey.PUBLISHED_DATE, 1438090882490L)
            put(TrekDataKey.IMG, "http://pnn.aotter.net/Media/show/cna.jpg")
            put(TrekDataKey.AUTHOR, "skybear")
            put(TrekDataKey.ADDRESS, "105台北市松山區南京東路四段2號")
            put(TrekDataKey.LAT, 25.0463684)
            put(TrekDataKey.LNG, 121.5501565)
        }

        val entity = Entity(
                "anthony", "anthony", EntityType.GAME.type, "anthony", listOf("News"),
                listOf(
                        "News",
                        "News_domestic"
                ),
                jsonObject,
        )

        val user = User("1991/10/10", "a1111111@gmail.com", "", "M", "0900000000",
                buildJsonObject { })

        tracker
                .timeSpan(1)
                .setUser(user)
                .setEntity(entity)
                .setActionType(ActionType.READ_POST)
                .sendTrackerReport()

    }

}