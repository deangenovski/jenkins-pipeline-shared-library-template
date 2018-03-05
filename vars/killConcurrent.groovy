#!groovy


def call() {

    def build = currentBuild.rawBuild.getPreviousBuildInProgress()

    while (build != null) {

        if (build.getEnvironment(null).BRANCH_NAME == BRANCH_NAME) {
            echo("Killing")
            build.doKill()
        } else {
            echo("not killing")
            echo(build.getEnvironment(null).toString())
            echo(BRANCH_NAME)
        }

        build = build.getPreviousBuildInProgress()
    }

}


