package com.example.myunittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mainViewModel: MainViewModel

    private lateinit var edtLebar: EditText
    private lateinit var edtPanjang: EditText
    private lateinit var edtTinggi: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnHitungVolume: Button
    private lateinit var btnHitungLuas: Button
    private lateinit var btnHitungLingkar: Button
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel(CuboidModel())

        edtLebar = findViewById(R.id.edt_lebar)
        edtPanjang = findViewById(R.id.edt_panjang)
        edtTinggi = findViewById(R.id.edt_tinggi)
        tvResult = findViewById(R.id.tv_result)
        btnHitungVolume = findViewById(R.id.btn_hitung_volume)
        btnHitungLuas = findViewById(R.id.btn_hitung_luas)
        btnHitungLingkar = findViewById(R.id.btn_hitung_lingkar)
        btnSave = findViewById(R.id.btn_save)

        btnHitungVolume.setOnClickListener(this)
        btnHitungLuas.setOnClickListener(this)
        btnHitungLingkar.setOnClickListener(this)
        btnSave.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val panjang = edtPanjang.text.toString().trim()
        val lebar = edtLebar.text.toString().trim()
        val tinggi = edtTinggi.text.toString().trim()

        when {
            panjang.isEmpty() -> edtPanjang.error = "Field ini tidak boleh kosong"
            lebar.isEmpty() -> edtLebar.error = "Field ini tidak boleh kosong"
            tinggi.isEmpty() -> edtTinggi.error = "Field ini tidak boleh kosong"

            else -> {
                val l = lebar.toDouble()
                val p = panjang.toDouble()
                val t = tinggi.toDouble()

                when {
                    v.id == R.id.btn_save -> {
                        mainViewModel.save(l, p, t)
                        visible()
                    }

                    v.id == R.id.btn_hitung_volume -> {
                        tvResult.text = mainViewModel.getVolume().toString()
                        gone()
                    }

                    v.id == R.id.btn_hitung_lingkar -> {
                        tvResult.text = mainViewModel.getLingkar().toString()
                        gone()
                    }

                    v.id == R.id.btn_hitung_luas -> {
                        tvResult.text = mainViewModel.getLuas().toString()
                        gone()
                    }
                }
            }
        }
    }

    private fun visible() {
        btnHitungVolume.visibility = View.VISIBLE
        btnHitungLingkar.visibility = View.VISIBLE
        btnHitungLuas.visibility = View.VISIBLE
        btnSave.visibility = View.GONE
    }

    private fun gone() {
        btnHitungVolume.visibility = View.GONE
        btnHitungLingkar.visibility = View.GONE
        btnHitungLuas.visibility = View.GONE
        btnSave.visibility = View.VISIBLE
    }
}