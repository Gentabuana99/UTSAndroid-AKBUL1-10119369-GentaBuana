package com.example.uts_akbul1_10119369_gentabuana

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.utsandroid_akbul1_10119369_gentabuana.R

class DataConfirmationActivity : AppCompatActivity() {

    private lateinit var etJenisTes: EditText
    private lateinit var etTanggalTerkonfirmasi: EditText
    private lateinit var etNIK: EditText
    private lateinit var etNama: EditText
    private lateinit var etTanggalLahir: EditText
    private lateinit var etJenisKelamin: EditText
    private lateinit var etHubunganDenganAnda: EditText

    private lateinit var btnCekHasilTes: Button
    private lateinit var btnUbah: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        etJenisTes = findViewById(R.id.et_jenis_tes)
        etTanggalTerkonfirmasi = findViewById(R.id.et_tanggal_terkonfirmasi)
        etNIK = findViewById(R.id.et_nik)
        etNama = findViewById(R.id.et_nama)
        etTanggalLahir = findViewById(R.id.et_tanggal_lahir)
        etJenisKelamin = findViewById(R.id.et_jenis_kelamin)
        etHubunganDenganAnda = findViewById(R.id.et_hubungan_dengan_anda)

        btnCekHasilTes = findViewById(R.id.btn_cek_hasil_tes)
        btnUbah = findViewById(R.id.btn_ubah)

        // Set the data from the previous activity
        val data = intent.extras
        if (data != null) {
            etJenisTes.setText(data.getString("jenis_tes"))
            etTanggalTerkonfirmasi.setText(data.getString("tanggal_terkonfirmasi"))
            etNIK.setText(data.getString("nik"))
            etNama.setText(data.getString("nama"))
            etTanggalLahir.setText(data.getString("tanggal_lahir"))
            etJenisKelamin.setText(data.getString("jenis_kelamin"))
            etHubunganDenganAnda.setText(data.getString("hubungan_dengan_anda"))
        }

        btnCekHasilTes.setOnClickListener {
            // TODO: Handle button click to check results
        }

        btnUbah.setOnClickListener {
            // TODO: Handle button click to go back to the previous activity to edit data
        }
    }
}
