package com.avancera.bogocanada.constants

class AppConstant {



    companion object{

        const val MIN_TIME_INTERVAL_FOR_SPLASH = 3000
        const val SELECT_IMAGE_COUNT = 1

    }


    object regex{

        val PASSWORD = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*#?&.])[A-Za-z\\d@\$!%*#?&]{8,}\$".toRegex()


    }



    object TRANSITION_TYPES {


        // in millis
        const val NONE = 2000
        const val FADE = 20001
        const val SLIDE = 20002



    }

    object TOAST_TYPES {


        const val INFO = 1101
        const val SUCCESS = 1102
        const val ERROR = 1103


    }

    object ServerAPICalls {

        //testing url
        // const val BASE_URL = "http://192.168.18.85:3000/v1/"

        // development url v1
         const val BASE_URL = "https://core.bogocanada.ca/v1/"

        // development url v2
       // const val BASE_URL = "https://corev2.bogocanada.ca/v2/"
        const val STORAGE_URL = "https://assets.bogocanada.ca/"
        //authentication api
        const val LOGIN_USER = "user/login"
        const val SOCIAL_LOGIN = "user/social-login"
        const val REGISTER_USER = "user/signup"
        const val CHANGE_PASSWORD = "user/change-password"
        const val VERIFY_OTP_CODE = "user/verify-otp"
        const val RESENT_OTP_CODE = "user/resend-otp"
        const val RESET_CODE = "user/reset-password"
        const val RESET_PASSWORD = "user/confirm-password"
        const val GET_SUBSCRIPTION = "subscriptions"
        const val POST_SUBSCRIPTION = "subscribe"
        const val SUBSCRIPTION_HISTORY = "history/subscription"
        const val AVAILABLE_BALANCE = "user/wallet"
        const val UPDATE_PROFILE = "user/profile"
        const val LOYALTY_POINTS = "user/loyalty-points"
        //home api
        const val CATEGORY = "variants"
        const val FEATURED_DEALS = "product/featured"
        const val NEAR_YOU_RESTAURANT = "category"
        const val GET_ID_CATEGORY = "{id}/category"
        const val PRODUCT_REDEEM = "product/reserve"
        const val PRODUCT_REDEEM_VERIFY = "product/verify"
        const val COUPON_HISTORY = "history/coupon"
        const val ADD_BANK_ACCOUNT = "accouts"
        const val DELETE_BANK_ACCOUNT = "{id}/accouts"
        const val GET_BANK_ACCOUNTS = "accouts"
        const val UPLOAD_FILE = "upload"
        const val CASH_OUT_HISTORY = "checkout-request-history"
        const val CASH_OUT_REQUEST = "checkout-request"
        const val COUPON_VERIFY = "product/verify"
        const val GET_VOUCHER_DISCOUNT = "subscription/{id}/discount"
        const val CITIES = "get-cities"
        //pages
        const val GET_PAGES = "pages"
        //settings
        const val GET_SETTINGS = "settings"





    }




}
