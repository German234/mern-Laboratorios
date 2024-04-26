package com.alexisflop.labo03.model

data class Subject(
    private var Name: String,
    private var Seccion: String,

    ){
    fun getName(): String {
        return Name
    }

    fun getSeccion(): String {
        return Seccion
    }
}




/*TODO: Hace ruso de buenas praticas de POO para poder asignar o obtener valores de las properties a utilizar*/
