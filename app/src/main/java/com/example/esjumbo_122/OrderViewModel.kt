package com.example.esjumbo_122

import android.icu.text.NumberFormat
import androidx.lifecycle.ViewModel
import com.example.esjumbo_122.data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

private const val HARGA_PER_CUP = 3000
class OrderViewModel : ViewModel(){
    private  val _stateUI = MutableStateFlow(OrderUIState())
    val stateUI:StateFlow<OrderUIState> = _stateUI.asStateFlow()

    fun setJumlah(jmlEsjumbo: Int) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                jumlah = jmlEsjumbo,
                harga = hitungHarga(jumlah = jmlEsjumbo)
            )
        }
    }

    fun setRasa(rasaPilihan: String){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(rasa = rasaPilihan)
        }
    }

    fun setOrder(){
        _stateUI.value = OrderUIState()
    }

    fun resetOrder() {
        _stateUI.value = OrderUIState()
    }

    private fun hitungHarga(
        jumlah: Int = _stateUI.value.jumlah
    ): String {
        val kalkulasiHarga = jumlah * HARGA_PER_CUP

        return NumberFormat.getNumberInstance().format(kalkulasiHarga)
    }


}