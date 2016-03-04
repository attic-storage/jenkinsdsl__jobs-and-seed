job('seed') {
    scm {
        git {
            remote {
                name('origin')
                url('https://github.com/rlespinasse/jenkinsdsl__jobs-and-seed.git')
            }
            createTag(false)
        }
    }
    triggers {
        scm 'H/5 * * * *'
    }
    steps {
        gradle 'clean test'
        dsl {
            external 'jobs/jobs_*.groovy'
            additionalClasspath 'src/main/groovy'
        }
    }
    publishers {
        archiveJunit 'build/test-results/**/*.xml'
    }
}