package br.com.mauriciobenigno.visitcard

import android.app.Application
import br.com.mauriciobenigno.visitcard.data.AppDataBase
import br.com.mauriciobenigno.visitcard.data.CartaoVisitaRepository

class App : Application(){
    val database by lazy { AppDataBase.getDatabase(this) }
    val repository by lazy { CartaoVisitaRepository(database.ctVisitaDao()) }
}