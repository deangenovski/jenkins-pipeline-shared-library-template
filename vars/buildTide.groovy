#!groovy
import com.tideaccount.android.jenkins.BuildType

def call(BuildType... buildTypes) {

    if (buildTypes == null || buildTypes.length == 0) {
        throw new IllegalStateException("Need atleast one buildType to run this command")
    }

    def buildStrings = []

    for (BuildType build : buildTypes) {
        buildStrings.add(buildGradleArgFor(build))
    }
    sh("./gradlew" + buildStrings.join(" "))
}

static def buildGradleArgFor(BuildType buildType) {
    return String.format("compile%s%sReleaseSources", buildType.env.capitalize(), buildType.user.capitalize())
}