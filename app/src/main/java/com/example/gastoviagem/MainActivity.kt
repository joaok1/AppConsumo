package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gastoviagem.databinding.ActivityMainBinding
import java.lang.Exception
import java.util.Objects

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Pegue o layout e o expanda --- Resolução do codigo faz a conexao entre o codigo e a interface
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.confirmButton.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        if (view.id == com.google.android.material.R.id.confirm_button) {
            calculate()
        }
    }

    private fun isValue( value : String ) : Float {
        if (!value.isEmpty()) {
            return value.toFloat();
        }
        return throw Exception()
    }

    private fun valueString() : Boolean {
        return (
                binding.editDistance.text.toString() != "" &&
                binding.editPrice.text.toString() != "" &&
                binding.editAutonomy.text.toString() != "" &&
                binding.editAutonomy.text.toString().toFloat() != 0f

                )
    }



    private fun calculate() {

        if (valueString()) {
            val distance = isValue(binding.editDistance.text.toString());
            val price = isValue(binding.editPrice.text.toString());
            val autonomy = isValue(binding.editAutonomy.text.toString());

            val totalValue = (distance * price) / autonomy
            val totalValueStr = "R$ ${ "%.2f".format(totalValue) }"
            //Escreve o valor no textView atualizar os preços
            binding.textValue.text = totalValueStr
            //Toast notification
            //To string converte os dados para string
            Toast.makeText(this, totalValueStr, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Digite um valor valido", Toast.LENGTH_SHORT).show()
        }

    }

    fun teste(view: View) {

    }

}