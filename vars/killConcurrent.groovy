#!groovy


def call() {

    echo(currentBuild.toString())

    def myBuild = currentBuild

    while(myBuild.rawBuild.getPreviousBuildInProgress() != null) {

        echo("Build found" + myBuild.rawBuild.toString())

        myBuild = myBuild.rawBuild.getPreviousBuildInProgress()
    }

}


