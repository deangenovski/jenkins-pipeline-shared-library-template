#!groovy
import com.tideaccount.android.jenkins.BuildType

def call(List<BuildType> buildTypes, String keystore, String keystorePassword, String keyAlias, String keyPassword) {
    echo "hi"

    withCredentials([file(credentialsId: 'keystore', variable: 'KEYSTORE_LOCATION'),
                     string(credentialsId: 'keystore-password', variable: 'KEYSTORE_PASSWORD'),
                     string(credentialsId: 'key-password', variable: 'KEY_PASSWORD')]) {
        echo("works")
    }
}


