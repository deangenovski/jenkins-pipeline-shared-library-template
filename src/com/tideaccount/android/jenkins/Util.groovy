package com.tideaccount.android.jenkins

class Util {
    static def fetchCredentials(Closure cloj) {
        withCredentials([file(credentialsId: 'keystore', variable: 'KEYSTORE_LOCATION'),
                         string(credentialsId: 'keystore-password', variable: 'KEYSTORE_PASSWORD'),
                         string(credentialsId: 'key-password', variable: 'KEY_PASSWORD')]) {
            cloj(KEYSTORE_LOCATION)
        }
    }
}
