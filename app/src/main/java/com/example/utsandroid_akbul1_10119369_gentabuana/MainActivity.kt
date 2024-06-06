package com.example.uts_akbul1_10119369_gentab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.wear.activity.ConfirmationActivity
import com.example.utsandroid_akbul1_10119369_gentabuana.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to UI elements
        val jenisTesRadioGroup: RadioGroup = findViewById(R.id.jenisTesRadioGroup)
        val tanggalTerkonfirmasiEditText: EditText = findViewById(R.id.tanggalTerkonfirmasiEditText)
        val nikEditText: EditText = findViewById(R.id.nikEditText)
        val namaEditText: EditText = findViewById(R.id.namaEditText)
        val tanggalLahirEditText: EditText = findViewById(R.id.tanggalLahirEditText)
        val jenisKelaminRadioGroup: RadioGroup = findViewById(R.id.jenisKelaminRadioGroup)
        val hubunganDenganAndaRadioGroup: RadioGroup = findViewById(R.id.hubunganDenganAndaRadioGroup)
        val agreementCheckBox: CheckBox = findViewById(R.id.agreementCheckBox)
        val selanjutnyaButton: Button = findViewById(R.id.selanjutnyaButton)

        // Set up button click listener
        selanjutnyaButton.setOnClickListener {
            // Validate inputs
            if (!validateInput()) {
                return@setOnClickListener
            }

            // Get selected values
            val jenisTes = getRadioButtonValue(jenisTesRadioGroup)
            val tanggalTerkonfirmasi = tanggalTerkonfirmasiEditText.text.toString()
            val nik = nikEditText.text.toString()
            val nama = namaEditText.text.toString()
            val tanggalLahir = tanggalLahirEditText.text.toString()
            val jenisKelamin = getRadioButtonValue(jenisKelaminRadioGroup)
            val hubunganDenganAnda = getRadioButtonValue(hubunganDenganAndaRadioGroup)
            val agreement = agreementCheckBox.isChecked

            // Pass data to the next activity
            val intent = Intent(this, ConfirmationActivity::class.java)
            intent.putExtra("jenisTes", jenisTes)
            intent.putExtra("tanggalTerkonfirmasi", tanggalTerkonfirmasi)
            intent.putExtra("nik", nik)
            intent.putExtra("nama", nama)
            intent.putExtra("tanggalLahir", tanggalLahir)
            intent.putExtra("jenisKelamin", jenisKelamin)
            intent.putExtra("hubunganDenganAnda", hubunganDenganAnda)
            intent.putExtra("agreement", agreement)
            startActivity(intent)
        }
    }

    // Function to validate inputs
    private fun validateInput(): Boolean {
        val jenisTesRadioGroup: RadioGroup = findViewById(R.id.jenisTesRadioGroup)
        val tanggalTerkonfirmasiEditText: EditText = findViewById(R.id.tanggalTerkonfirmasiEditText)
        val nikEditText: EditText = findViewById(R.id.nikEditText)
        val namaEditText: EditText = findViewById(R.id.namaEditText)
        val tanggalLahirEditText: EditText = findViewById(R.id.tanggalLahirEditText)
        val jenisKelaminRadioGroup: RadioGroup = findViewById(R.id.jenisKelaminRadioGroup)
        val hubunganDenganAndaRadioGroup: RadioGroup = findViewById(R.id.hubunganDenganAndaRadioGroup)
        val agreementCheckBox: CheckBox = findViewById(R.id.agreementCheckBox)

        if (jenisTesRadioGroup.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Pilih jenis tes.", Toast.LENGTH_SHORT).show()
            return false
        }
        if (tanggalTerkonfirmasiEditText.text.toString().isEmpty()) {
            Toast.makeText(this, "Masukkan tanggal terkonfirmasi.", Toast.LENGTH_SHORT).show()
            return false
        }
        if (nikEditText.text.toString().isEmpty()) {
            Toast.makeText(this, "Masukkan NIK.", Toast.LENGTH_SHORT).show()
            return false
        }
        if (namaEditText.text.toString().isEmpty()) {
            Toast.makeText(this, "Masukkan nama.", Toast.LENGTH_SHORT).show()
            return false
        }
        if (tanggalLahirEditText.text.toString().isEmpty()) {
            Toast.makeText(this, "Masukkan tanggal lahir.", Toast.LENGTH_SHORT).show()
            return false
        }
        if (jenisKelaminRadioGroup.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Pilih jenis kelamin.", Toast.LENGTH_SHORT).show()
            return false
        }
        if (hubunganDenganAndaRadioGroup.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Pilih hubungan dengan Anda.", Toast.LENGTH_SHORT).show()
            return false
        }
        if (!agreementCheckBox.isChecked) {
            Toast.makeText(this, "Setujui persyaratan.", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    // Function to get selected value from RadioGroup
    private fun getRadioButtonValue(radioGroup: RadioGroup): String {
        val radioButtonId = radioGroup.checkedRadioButtonId
        val radioButton: RadioButton = findViewById(radioButtonId)
        return radioButton.text.toString()
    }
}