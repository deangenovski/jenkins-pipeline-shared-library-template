#!groovy


def call() {

    echo(currentBuild.toString())
    while(currentBuild.rawBuild.getPreviousBuildInProgress() != null) {
        currentBuild.rawBuild.getPreviousBuildInProgress().doKill()
    }
}


