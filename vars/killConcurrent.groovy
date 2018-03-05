#!groovy


def call() {

    def build = currentBuild.rawBuild.getPreviousBuildInProgress()

    while (build != null) {

        if (build.getEnvironment(null).BRANCH_NAME == BRANCH_NAME) {
            echo("Killing")
            build.doKill()
        }

        build = build.getPreviousBuildInProgress()
    }

}


