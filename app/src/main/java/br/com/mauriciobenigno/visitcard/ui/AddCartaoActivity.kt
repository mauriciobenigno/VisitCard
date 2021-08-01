package br.com.mauriciobenigno.visitcard.ui

import MainViewModel
import MainViewModelFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import br.com.mauriciobenigno.visitcard.App
import br.com.mauriciobenigno.visitcard.R
import br.com.mauriciobenigno.visitcard.data.CartaoVisita
import br.com.mauriciobenigno.visitcard.databinding.ActivityAddCartaoBinding

class AddCartaoActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddCartaoBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.btnConfirmar.setOnClickListener {
            val cartaoVisita = CartaoVisita(
                nome = binding.edtNome.editText?.text.toString(),
                empresa = binding.edtEmpresa.editText?.text.toString(),
                telefone = binding.edtTelefone.editText?.text.toString(),
                email = binding.edtEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(cartaoVisita)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btnFechar.setOnClickListener {
            finish()
        }
    }
}