# Finance App

Aplikasi Android untuk membantu pengguna memantau pengeluaran harian dan melihat ringkasan budget dengan tampilan modern berbasis Jetpack Compose.

![Android](https://img.shields.io/badge/Platform-Android-34A853?logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-2.2.10-7F52FF?logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-UI-4285F4)
![Min SDK](https://img.shields.io/badge/Min%20SDK-24-blue)
![Target SDK](https://img.shields.io/badge/Target%20SDK-36-orange)

## Why This App?

Finance App dibuat untuk skenario pencatatan keuangan personal yang simpel:
- onboarding cepat dengan intro screen
- dashboard transaksi harian yang mudah dibaca
- halaman laporan budget dengan visual progress
- struktur kode yang cocok untuk pembelajaran Android modern

## Fitur Utama

- Intro screen dengan CTA Get Started
- Dashboard transaksi berisi daftar pengeluaran terbaru
- Card ringkasan yang mengarahkan pengguna ke halaman report
- Report screen berisi:
  - statistik utama
  - summary section
  - daftar kategori budget dan persentasenya
- Bottom navigation pada halaman utama dan report
- Arsitektur sederhana Activity + ViewModel + Repository

## Tech Stack

- Kotlin
- Android Gradle Plugin 9.1.0
- Jetpack Compose
- Material 3
- ViewModel
- ConstraintLayout Compose

## Struktur Proyek

```text
app/src/main/java/com/example/financeapp/
├── Activities/
│   ├── IntroActivity/
│   ├── DashboardActivity/
│   └── ReportActivity/
├── Domain/
│   ├── ExpenseDomain.kt
│   └── BudgetDomain.kt
├── Repository/
│   └── MainRepository.kt
├── ViewModel/
│   └── MainViewModel.kt
└── ui/theme/
```

## Alur Halaman

1. Pengguna masuk ke IntroActivity (launcher).
2. Tombol Get Started membuka MainActivity.
3. Dashboard menampilkan daftar ExpenseDomain dari MainViewModel.
4. Klik card utama membuka ReportActivity.
5. Report menampilkan data BudgetDomain dari MainViewModel.

## Menjalankan Project

### Prasyarat

- Android Studio terbaru (disarankan versi yang mendukung AGP 9.x)
- JDK 11
- Android SDK dengan API level 36

### Langkah Cepat

```bash
# clone repository
git clone <url-repository>

# masuk ke folder project
cd finance-app

# build debug
./gradlew assembleDebug

# jalankan unit test
./gradlew test
```

Jika menggunakan Windows, ganti perintah dengan gradlew.bat.

## Catatan Data

Saat ini data transaksi dan budget masih berupa hardcoded sample data pada MainRepository. Ini memudahkan eksplorasi UI sebelum integrasi database atau API.

## Ide Pengembangan Lanjutan

- Integrasi Room untuk penyimpanan lokal
- Integrasi API untuk sinkronisasi cloud
- Fitur tambah/edit/hapus transaksi
- Filter transaksi berdasarkan tanggal dan kategori
- Grafik bulanan (line/bar chart)
- Unit test dan UI test yang lebih lengkap

## Kontribusi

Pull request sangat terbuka untuk:
- perbaikan arsitektur
- peningkatan UI/UX
- penambahan fitur finansial
- peningkatan test coverage

## Lisensi

Belum ditentukan. Silakan tambahkan file LICENSE sesuai kebutuhan proyek.
