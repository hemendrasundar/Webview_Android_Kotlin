package com.hemendra.webviewandroidkotlin

import android.app.ProgressDialog
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //Progress Dialog.
        var progresssdialog = ProgressDialog(this@MainActivity)
        progresssdialog.setTitle("Loading")
        progresssdialog.setMessage("Page is Loading...")

// Loading URL in Webview.



        btn_search.setOnClickListener {
            wview.loadUrl("https://${et_url.text.toString()}")
        }
        btn_fb.setOnClickListener {
            wview.loadUrl("https://www.facebook.com")
        }
        btn_nit.setOnClickListener {
            wview.loadUrl("https://www.nareshit.com")
        }
        btn_twitter.setOnClickListener {
            wview.loadUrl("https://www.twitter.com")
        }
        btn_html.setOnClickListener {
            wview.loadUrl("file:///android_asset/test.html")
        }

// Setting WebView Client.

        wview.webViewClient  = object :WebViewClient(){

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)

                progresssdialog.show()

            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                progresssdialog.dismiss()
            }
        }


        wview.settings.javaScriptEnabled =true
        wview.settings.builtInZoomControls = true
    }
}