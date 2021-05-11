package com.example.behealthykotlinapp

//import android.R
import android.os.Bundle
import android.util.Base64
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity


class Chart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)

        val webView = findViewById<View>(R.id.webview) as WebView

        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

        val unencodedHtml =
            "<html><body><iframe width=\"100%\" height=\"480\" frameborder=\"0\" src=\"https://koronawirusunas.pl/u/polska\"></iframe> </body></html>"
        val encodedHtml: String = Base64.encodeToString(
            unencodedHtml.toByteArray(),
            Base64.NO_PADDING
        )
        webView.loadData(encodedHtml, "text/html", "base64")
    }
}