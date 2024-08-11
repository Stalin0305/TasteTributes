object Dependencies  {
    //versions
    private const val hiltVersion = "2.48"
    private const val firebaseBOMVersion = "33.1.2"
    private const val roomVersion = "2.6.1"
    private const val navigationVersion = "2.7.7"

    //Dependencies
    const val hilt = "com.google.dagger:hilt-android:$hiltVersion"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$hiltVersion"
    const val firebaseBom = "com.google.firebase:firebase-bom:$firebaseBOMVersion"
    const val firebaseAuth = "com.google.firebase:firebase-auth"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics"
    const val room = "androidx.room:room-runtime:$roomVersion"
    const val roomCompiler = "androidx.room:room-compiler:$roomVersion"
    const val roomKtx = "androidx.room:room-ktx:$roomVersion"
    const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"


}