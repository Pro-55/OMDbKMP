package com.papslabs.omdb_kmp.util

object Constants {
    internal const val OMDB_KMP_SHARED_PREFS = "omdb_kmp_shared.preferences_pb"
    internal const val OMDB_KMP_DB = "omdb.db"

    const val KEY_SIGN_UP_STATUS = "sign_up_status"
    const val KEY_USER_ID = "user_id"

    private const val EMOJI_EXPLODING_HEAD = "\uD83E\uDD2F"
    private const val THINKING_EMOJI = "\uD83E\uDD14"
    const val REQUEST_FAILED_MESSAGE = "Something went wrong... $THINKING_EMOJI"
    const val ERROR_MESSAGE_UNKNOWN = "Something went wrong... $EMOJI_EXPLODING_HEAD"
}