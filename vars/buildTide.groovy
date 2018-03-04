#!groovy
import com.tideaccount.android.jenkins.BuildType
import com.tideaccount.android.jenkins.Keystore

import static com.tideaccount.android.jenkins.Util.withCredentials

def call(BuildType... buildTypes) {

    echo(BUILD_NUMBER)

    withCredentials(this) { Keystore keystore ->
        echo("hi from clojure")
        echo(keystore.keystore)
    }
}


