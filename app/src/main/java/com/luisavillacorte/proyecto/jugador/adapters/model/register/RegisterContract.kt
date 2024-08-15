package com.luisavillacorte.proyecto.jugador.adapters.model.register

import androidx.core.app.NotificationCompat.MessagingStyle.Message
import retrofit2.Callback

interface RegisterContract {
    interface View {
        fun showFirstSection()
        fun showSecondSection()
        fun showSuccess()
        fun showError(message: String)

    }

    interface Presenter {
        fun attachView(view: View)
        fun detachView()
        fun saveFirstSectionData(data: Map<String, String>)
        fun saveSecondSectionData(data: Map<String, String>)
        fun checkEmailExists(correo: String, callback: (Boolean) -> Unit)
        fun checkIdentificationExists(identificacion: String, callback: (Boolean) -> Unit)
        fun registerUser()

    }
}