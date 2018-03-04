#!groovy
import com.tideaccount.android.jenkins.BuildType

def call(Integer buildNumber, String buildName, BuildType... buildTypes) {

    echo(new TestOperation(
            buildTypes.toList(),
            buildNumber,
            buildName,
    ).getGradleBuildString())

}


