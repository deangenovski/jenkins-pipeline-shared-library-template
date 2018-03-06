package com.tideaccount.android.jenkins


import com.tideaccount.android.jenkins.operations.GradleOperationBuilder

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

    static def gradleOperation(script, body) {

        def config = new GradleOperationBuilder()
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()

//        if (script.env('buildNumber') && script.hasVariable('buildName')) {
        config.buildNumber = script.env['buildNumber']
        config.buildName = script.env['buildName']
//        }

        script.sh(config.getGradleBuildString())

    }


}
