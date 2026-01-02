package com.example.week14.modeldata

// Data class utama untuk merepresentasikan entitas Siswa
data class Siswa(
    val id: Long = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = ""
)

// Data class yang digunakan khusus untuk keperluan UI atau Detail
data class DetailSiswa(
    val id: Long = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = ""
)

// Fungsi ekstensi untuk mengubah DetailSiswa menjadi Siswa
fun DetailSiswa.toDataSiswa(): Siswa = Siswa(id, nama, alamat, telpon)

// Fungsi ekstensi untuk mengubah Siswa menjadi DetailSiswa
fun Siswa.toDetailSiswa(): DetailSiswa = DetailSiswa(id, nama, alamat, telpon)

// Data class untuk mengelola State UI (biasanya digunakan di ViewModel)
data class UIStateSiswa(
    val detailSiswa: DetailSiswa = DetailSiswa(),
    val isEntryValid: Boolean = false
)

// Fungsi ekstensi untuk mengubah Siswa langsung ke UIStateSiswa
fun Siswa.toUiStateSiswa(isEntryValid: Boolean = false): UIStateSiswa = UIStateSiswa(
    detailSiswa = this.toDetailSiswa(),
    isEntryValid = isEntryValid
)