package vn.cinevn.cinetv

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Khởi tạo WebView trực tiếp làm giao diện chính cho app TV
        webView = WebView(this)
        setContentView(webView)

        // Cấu hình các thiết lập tối ưu cho WebView & Web App
        val webSettings: WebSettings = webView.settings.apply {
            javaScriptEnabled = true          // Cho phép chạy JS
            domStorageEnabled = true          // Cho phép lưu trữ dữ liệu web (LocalStorage)
            loadWithOverviewMode = true       // Co dãn vừa màn hình
            useWideViewPort = true
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW // Cho phép tải cả nội dung HTTP lẫn HTTPS
        }

        webView.webViewClient = WebViewClient()

        // 👉 [LƯU Ý]: Hãy thay đổi đường dẫn bên dưới thành link trang web/server của bạn (Ví dụ: link Vercel, Render hoặc IP mạng nội bộ)
        webView.loadUrl("https://your-cinevn-app.vercel.app")
    }

    // Xử lý nút Back trên Remote Android TV: bấm lùi trang web trước đó thay vì thoát app ngay lập tức
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
