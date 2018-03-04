#!groovy
import com.tideaccount.android.jenkins.BuildType
import com.tideaccount.android.jenkins.Keystore

import static com.tideaccount.android.jenkins.Util.withCredentials

def call(BuildType... buildTypes) {
    echo "hi"

    def cloj = { Keystore keystore ->
        echo("hi from clojure")
        echo(keystore.keystore)

    }

    withCredentials(this) {

    }
}


