package com.avancera.mvvmarchitectureapp.utils


object Enums {

    enum class TinyDBKeys(val key: String) {
        LOCALE("locale"),
        TOKEN_USER("auth_token_user")
    }

    enum class NavigationType {
        ACTION,
        ID
    }

    enum class BundleFragmentKeys(val key: String) {
        PAYLOAD("payload"),
        ID("id"),
        SEARCH_LIST("search_list"),
        FROM("from")
    }

    enum class ButtonType {
        EDIT,
        CANCEL
    }

    enum class SearchType {
        COUNTRY,
        STATE,
        CITY
    }

    enum class FROM {
        FROM_CREATE_ADDRESS,
        FROM_EDIT_ADDRESS,
        FROM_PROFILE,
        FROM_CHECKOUT
    }

    enum class UseWallet(val key: Int) {
        YES(1),
        NO(0)
    }

    enum class PaymentMethod(val method: String) {
        STRIPE("stripe")
    }

    enum class NotificationType {
        FOREGROUND,
        BACKGROUND,
        KILLED
    }



}