package com.tideaccount.android.jenkins.operations

import com.tideaccount.android.jenkins.BuildType
import com.tideaccount.android.jenkins.Keystore

class GradleOperationBuilder implements Serializable {
//Jenkins does some weird stuff and cannot handle private fields and methods correctly :(
    List<BuildType> buildTypes
    String buildName
    String buildNumber
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

        def buildScript = "./gradlew " + buildStrings.join(" ")

        if (buildName != null && buildNumber != null) {
            buildScript = buildScript +
                    " -PbuildNumber=${buildNumber} " +
                    "-PbuildName=${buildName}"
        }

        if (keystore != null) {
            buildScript = buildScript + " -Ptide.signing=true " +
                    "-PkeyStore=${keystore.keystore} " +
                    "-PkeyStorePassword=${keystore.keystorePassword} " +
                    "-Palias=tide " +
                    "-PkeyPass=${keystore.keystorePassword} "
        }
        return buildScript

    }
}
