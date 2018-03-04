package com.tideaccount.android.jenkins

class Util {
    static def fetchCredentials(script, Closure cloj) {
        script.withCredentials([script.file(credentialsId: 'keystore', variable: 'KEYSTORE_LOCATION'),
                                script.string(credentialsId: 'keystore-password', variable: 'KEYSTORE_PASSWORD'),
                                script.string(credentialsId: 'key-password', variable: 'KEY_PASSWORD')]) {
            cloj(script.KEYSTORE_LOCATION)
        }
    }
}
