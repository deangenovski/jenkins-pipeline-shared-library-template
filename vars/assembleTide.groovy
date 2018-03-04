#!groovy
import com.tideaccount.android.jenkins.BuildType
import com.tideaccount.android.jenkins.Keystore

import static com.tideaccount.android.jenkins.Util.gradleOperation
import static com.tideaccount.android.jenkins.Util.withCredentials

def call(Integer buildNumberArg, String buildNameArg, BuildType... buildTypesArg) {

    withCredentials(this) { Keystore keystoreArg ->
        gradleOperation(this) {
            buildTypes = buildTypesArg.toList()
            buildNumber = buildNumberArg
            buildName = buildNameArg
            keystore = keystoreArg
        }
        
    }

}


