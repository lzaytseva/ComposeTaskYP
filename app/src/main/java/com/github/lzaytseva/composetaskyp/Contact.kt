package com.github.lzaytseva.composetaskyp

data class Contact(
    val name: String, //Имя
    val surname: String? = null, //Отчество
    val familyName: String, //Фамилия
    val imageRes: Int? = null,//Ресурс фотографии
    val isFavorite: Boolean = false,//Признак избранного контакта
    val phone: String, //Телефон
    val address: String, //Адрес
    val email: String? = null, //E-mail
) {
    companion object {
        val contact1 = Contact(
            name = "Евгений",
            surname = "Андреевич",
            familyName = "Лукашин",
            isFavorite = true,
            phone = "+7 495 495 95 95",
            address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12",
            email = "ELukashin@practicum.ru",
            imageRes = null
        )
        val contact2 = Contact(
            name = "Ренат",
            familyName = "Агзамов",
            isFavorite = false,
            phone = "---",
            address = "Ивановская область, дер. Крутово, д.4",
            imageRes = R.drawable.profile_pic
        )
    }
}
