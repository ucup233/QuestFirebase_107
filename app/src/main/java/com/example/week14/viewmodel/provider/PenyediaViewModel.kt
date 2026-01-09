package com.example.week14.viewmodel.provider

import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import com.example.week14.repositori.AplikasiDataSiswa
import com.example.week14.viewmodel.DetailViewModel
import com.example.week14.viewmodel.EditViewModel
import com.example.week14.viewmodel.EntryViewModel
import com.example.week14.viewmodel.HomeViewModel

fun CreationExtras.aplikasiDataSiswa(): AplikasiDataSiswa = (
        this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiDataSiswa
        )

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(aplikasiDataSiswa().container.repositorySiswa) }
        initializer { EntryViewModel(aplikasiDataSiswa().container.repositorySiswa) }
        initializer {
            DetailViewModel(
                this.createSavedStateHandle(),
                aplikasiDataSiswa().container.repositorySiswa
            )
        }
        initializer {
            EditViewModel(
                this.createSavedStateHandle(),
                aplikasiDataSiswa().container.repositorySiswa
            )
        }
    }
}