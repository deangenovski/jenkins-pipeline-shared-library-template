#!groovy
import com.tideaccount.android.jenkins.BuildType

def call(List<BuildType> buildTypes, String keystore, String keystorePassword, String keyAlias, String keyPassword) {
    echo "hi"

    echo(credentials('keyPassword'))
}


