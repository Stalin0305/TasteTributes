object Dependencies  {
    //versions
    private const val hiltVersion = "2.48"
    private const val firebaseBOMVersion = "33.1.2"
    private const val roomVersion = "2.6.1"
    private const val navigationVersion = "2.7.7"
    private const val hiltNavigationVersion = "1.2.0"
    private const val mockitoVersion = "5.12.0'"
    private const val mockitoInlineVersion = "5.2.0"
    private const val coroutineTestVersion = "1.9.0"

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
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:$hiltNavigationVersion"
    const val mockito = "org.mockito:mockito-core:${mockitoVersion}"
    const val mockitoInline = "org.mockito:mockito-inline:$mockitoInlineVersion"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineTestVersion"
}