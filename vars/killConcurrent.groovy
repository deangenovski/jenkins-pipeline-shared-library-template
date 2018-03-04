#!groovy


def call() {

    echo(currentBuild.toString())

    def myBuild = currentBuild

    while(myBuild.rawBuild.getPreviousBuildInProgress() != null) {

        echo("Build found" + myBuild.toString())

        myBuild.rawBuild.getPreviousBuildInProgress()
    }

}


