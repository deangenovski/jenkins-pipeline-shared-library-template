package com.tideaccount.android.jenkins.operations

import com.tideaccount.android.jenkins.BuildType
import com.tideaccount.android.jenkins.Keystore

class GradleOperationBuilder implements Serializable {
//Jenkins does some weird stuff and cannot handle private fields and methods correctly :(
    List<BuildType> buildTypes
    String buildName
    Integer buildNumber
    Keystore keystore
    String buildStepFormat

    def generateGradleArgumentFor(BuildType type) {
        return String.format(buildStepFormat, type.env.capitalize(), type.user.capitalize())
    }


    String getGradleBuildString() {

        def buildStrings = []

        for (BuildType build : buildTypes) {
            buildStrings.add(generateGradleArgumentFor(build))
        }

        def defaultBuildScript = "./gradlew " + buildStrings.join(" ") +
                " -PbuildNumber=${buildNumber} " +
                "-PbuildName=${buildName}"

        if (keystore != null) {
            return defaultBuildScript + " -Ptide.signing=true " +
                    "-PkeyStore=${keystore.keystore} " +
                    "-PkeyStorePassword=${keystore.keystorePassword} " +
                    "-Palias=tide " +
                    "-PkeyPass=${keystore.keystorePassword} "
        } else {
            return defaultBuildScript
        }

    }
}
