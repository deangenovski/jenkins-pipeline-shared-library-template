package com.tideaccount.android.jenkins

class Util {
    static def withCredentials(script, Closure cloj) {
        script.withCredentials([script.file(credentialsId: 'keystore', variable: 'KEYSTORE_LOCATION'),
                                script.string(credentialsId: 'keystore-password', variable: 'KEYSTORE_PASSWORD'),
                                script.string(credentialsId: 'key-password', variable: 'KEY_PASSWORD')]) {


            def keystore = new Keystore(
                    script.KEYSTORE_LOCATION,
                    script.KEYSTORE_PASSWORD,
                    script.KEY_PASSWORD)
            cloj(keystore)
        }
    }
}
