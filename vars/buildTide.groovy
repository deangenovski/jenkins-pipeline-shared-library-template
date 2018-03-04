#!groovy
import com.tideaccount.android.jenkins.BuildType

def call(BuildType... buildTypes) {
    echo "hi"

    withCredentials([file(credentialsId: 'keystore', variable: 'KEYSTORE_LOCATION'),
                     string(credentialsId: 'keystore-password', variable: 'KEYSTORE_PASSWORD'),
                     string(credentialsId: 'key-password', variable: 'KEY_PASSWORD')]) {
        sh("echo $KEYSTORE_LOCATION")
        echo(KEYSTORE_LOCATION)
    }
}


