#!groovy
import com.tideaccount.android.jenkins.BuildType
import com.tideaccount.android.jenkins.Constants
import com.tideaccount.android.jenkins.Keystore

import static com.tideaccount.android.jenkins.Util.gradleOperation
import static com.tideaccount.android.jenkins.Util.withCredentials

def call(BuildType... buildTypesArg) {

    gradleOperation(this) {
        buildStepFormat = Constants.COMPILE_FORMAT
        buildTypes = buildTypesArg.toList()
    }

}


