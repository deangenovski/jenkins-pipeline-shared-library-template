#!groovy
import com.tideaccount.android.jenkins.BuildType
import com.tideaccount.android.jenkins.Keystore
import com.tideaccount.android.jenkins.operations.AssembleOperation
import com.tideaccount.android.jenkins.operations.CompileOperation
import com.tideaccount.android.jenkins.operations.DeployFabricOperation

import static com.tideaccount.android.jenkins.Util.withCredentials

def call(Integer buildNumber, String buildName, BuildType... buildTypes) {

    withCredentials(this) { Keystore keystore ->
        echo(new DeployFabricOperation(
                buildTypes.toList(),
                buildNumber,
                buildName,
                keystore).getGradleBuildString())
    }

}


