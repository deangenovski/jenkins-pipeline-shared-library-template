#!groovy
import com.tideaccount.android.jenkins.BuildType
import com.tideaccount.android.jenkins.Util

def call(BuildType... buildTypes) {
    echo "hi"

    def cloj = { String keystore ->
        echo("hi from clojure")
        echo(keystore)

    }

    Util.fetchCredentials(this,cloj)
}


