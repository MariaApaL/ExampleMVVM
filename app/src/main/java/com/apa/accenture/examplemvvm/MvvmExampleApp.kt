package com.apa.accenture.examplemvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
//Esta clase será la primera en llamarse, hay que añadir un atributo nuevo en manifest
class MvvmExampleApp: Application()