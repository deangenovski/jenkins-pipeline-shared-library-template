#!groovy
import com.tideaccount.android.jenkins.BuildType

def call(BuildType... buildTypes) {
    echo "hi"

    def cloj = { String keystore ->
        echo("hi from clojure")
        echo(keystore)

    }

    withCredentials([file(credentialsId: 'keystore', variable: 'KEYSTORE_LOCATION'),
                     string(credentialsId: 'keystore-password', variable: 'KEYSTORE_PASSWORD'),
                     string(credentialsId: 'key-password', variable: 'KEY_PASSWORD')]) {
       cloj(KEYSTORE_LOCATION)
    }
}


