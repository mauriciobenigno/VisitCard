import br.com.mauriciobenigno.visitcard.data.CartaoVisitaRepository

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.mauriciobenigno.visitcard.data.CartaoVisita

class MainViewModel(private val cartaoVisitaRepository: CartaoVisitaRepository): ViewModel() {

    fun insert(cartaoVisita: CartaoVisita) {
        cartaoVisitaRepository.insert(cartaoVisita)
    }

    fun getAll(): LiveData<List<CartaoVisita>> {
        return cartaoVisitaRepository.getAll()
    }

}

class MainViewModelFactory(private val repository: CartaoVisitaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}