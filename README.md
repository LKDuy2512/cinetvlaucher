# CineTV — Android TV Launcher

Launcher Android native phong cách điện ảnh tối giản, nền đen và điểm nhấn đỏ. Tối ưu cho màn hình ngang và remote D-pad.

## Có gì trong bản đầu tiên
- Quét các ứng dụng có hoạt động khởi chạy và mở chúng.
- Đồng hồ cập nhật tự động.
- Thời tiết hiện tại qua Open-Meteo (không cần API key). Tọa độ mặc định trong `MainActivity.kt` là TP.HCM; sửa `latitude` và `longitude` để đổi khu vực.
- Danh sách yêu thích lưu trên thiết bị.
- Sắp xếp thứ tự ứng dụng và lưu lại.
- Điều hướng bằng remote, focus phóng to nhẹ.
- Có intent HOME để thiết bị tương thích có thể chọn CineTV làm launcher mặc định.

## Build APK bằng Android Studio
1. Cài Android Studio bản ổn định mới.
2. Giải nén ZIP này.
3. Android Studio → **Open** → chọn thư mục `CineTV_Android` (thư mục có `settings.gradle.kts`).
4. Chờ Gradle Sync tải Android Gradle Plugin/Kotlin plugin.
5. Nếu Android Studio yêu cầu cài Android SDK Platform 35, chọn Install.
6. Chọn **Build → Build Bundle(s) / APK(s) → Build APK(s)**.
7. APK debug thường ở `app/build/outputs/apk/debug/app-debug.apk`.

## Cài lên Android TV / TV Box
- Bật Developer options và USB debugging (hoặc dùng trình cài APK từ USB).
- Chép `app-debug.apk` vào TV Box, mở bằng trình quản lý file và cài đặt. Có thể cần cho phép “Install unknown apps”.
- Mở CineTV. Nếu thiết bị hỏi chọn Home app, chọn CineTV. Một số thiết bị Google TV/nhà sản xuất chặn đổi launcher; khi đó ứng dụng vẫn có thể mở thủ công nhưng không thay được Home mặc định.

## Remote
- D-pad để di chuyển focus, OK để mở.
- Giữ OK trên một ứng dụng hoặc bấm phím Menu (nếu remote có) để thêm/bỏ yêu thích, mở hoặc sắp xếp.
- Chọn **TÙY CHỈNH** để quản lý yêu thích/thứ tự ứng dụng.

## Ghi chú / giới hạn
- Đây là mã nguồn project Android có thể build, không phải APK đã biên dịch và kiểm thử trên thiết bị thật.
- Danh sách ứng dụng phụ thuộc ứng dụng có khai báo hoạt động launcher; một số ứng dụng TV chỉ hiện trong launcher của nhà sản xuất có thể không xuất hiện.
- Thời tiết mặc định dùng tọa độ TP.HCM. Nếu muốn thời tiết nơi khác, sửa URL trong `fetchWeather()`.
- Trên Android 11+, khả năng nhìn thấy các gói ứng dụng bị giới hạn theo cơ chế package visibility; project chỉ truy vấn hoạt động launcher, không dùng quyền đọc toàn bộ gói.
- Một số remote không gửi sự kiện long-press/Menu. Trong trường hợp đó hãy dùng nút TÙY CHỈNH trên banner.
- Đây là bản nền tảng đầu tiên; cần kiểm thử trên đúng TV/TV Box trước khi dùng làm launcher chính.


## Build APK bằng điện thoại qua GitHub Actions (không cần PC)
1. Đăng nhập GitHub trên trình duyệt điện thoại và tạo repository mới, ví dụ `CineTV`.
2. Giải nén ZIP trên điện thoại. Tải các file trong thư mục project lên repository, giữ nguyên cấu trúc thư mục và nhớ bật hiển thị file ẩn để tải thư mục `.github`.
3. Mở tab **Actions** của repository. Nếu GitHub hỏi, chọn cho phép workflow chạy.
4. Chọn workflow **Build CineTV APK** → **Run workflow**.
5. Chờ workflow hoàn thành màu xanh. Mở lần chạy đó, kéo xuống **Artifacts**, tải `CineTV-debug-APK.zip`, giải nén để lấy `app-debug.apk`.
6. Chuyển APK sang TV Box và cài đặt. Không chia sẻ APK debug như bản phát hành chính thức.

Lưu ý: GitHub giao diện điện thoại có thể khó tải nhiều file/thư mục cùng lúc. Nếu gặp khó, dùng một ứng dụng quản lý Git hỗ trợ upload thư mục, hoặc dùng AIDE nếu phiên bản trên máy hỗ trợ project Gradle/Kotlin hiện tại.


## Build APK không cần máy tính (GitHub Actions trên điện thoại)
ZIP này có sẵn workflow `.github/workflows/build-apk.yml`, có thể build APK trên máy chủ GitHub.

1. Tạo/đăng nhập tài khoản tại https://github.com/ trên điện thoại.
2. Tạo repository mới, ví dụ `CineTV-Launcher`. Nếu không muốn công khai mã nguồn, chọn **Private**.
3. Giải nén ZIP trên điện thoại. Trình duyệt GitHub trên điện thoại không tiện tải cả thư mục, vì vậy có thể dùng ứng dụng GitHub hoặc trang upload file của repository để tải các file/thư mục lên, giữ nguyên cấu trúc. Phải có `app/`, `build.gradle.kts`, `settings.gradle.kts`, `gradle.properties` và `.github/workflows/build-apk.yml` ở thư mục gốc.
4. Commit các file lên nhánh `main`.
5. Mở tab **Actions** của repository. Nếu workflow chưa tự chạy, chọn **Build CineTV APK** → **Run workflow**.
6. Chờ job có dấu tích xanh. Mở lần chạy đó, kéo xuống **Artifacts**, tải `CineTV-debug-APK.zip`, giải nén để lấy `app-debug.apk`.
7. Cài APK lên TV Box qua USB hoặc tải APK bằng trình duyệt TV/ứng dụng truyền file. Cho phép cài ứng dụng từ nguồn này nếu Android hỏi.

Không cần thêm mật khẩu, signing key hay API key để tạo APK debug. Không tải keystore riêng tư lên repository.

## Lưu ý về build trên điện thoại
AndroidIDE cũng có thể mở project Gradle trực tiếp trên Android, nhưng dự án AndroidIDE gốc hiện có cảnh báo không còn được duy trì. Nếu chọn dùng IDE trên điện thoại, chỉ tải từ nguồn tin cậy và có thể gặp vấn đề tương thích. GitHub Actions là lựa chọn tránh phải cài Android SDK/Gradle nặng trên điện thoại.
