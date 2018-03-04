package com.tideaccount.android.jenkins

class Keystore {

    String keystore
    String keystorePassword
    String keyPassword

    Keystore(keystore, keystorePassword, keyPassword) {
        this.keystore = keystore
        this.keystorePassword = keystorePassword
        this.keyPassword = keyPassword
    }
}
