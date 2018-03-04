#!groovy
import com.tideaccount.android.jenkins.BuildType

def call(Closure body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    print(config.buildType)
    print(config.keyPassword)
}

