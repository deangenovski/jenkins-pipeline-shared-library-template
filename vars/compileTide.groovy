#!groovy
import com.tideaccount.android.jenkins.BuildType

def call(Integer buildNumber, String buildName, BuildType... buildTypes) {
    echo(new CompileOperation(
            buildTypes.toList(),
            buildNumber,
            buildName).getGradleBuildString())
}


