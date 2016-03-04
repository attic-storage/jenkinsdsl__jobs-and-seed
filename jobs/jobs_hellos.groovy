folder 'hellos'

workflowJob('hellos/hello_world') {
    definition {
        cps {
            script '''
node {
    echo 'Hello world!!'
}
'''
            sandbox()
        }
    }
}

workflowJob('hellos/hello_golo') {
    definition {
        cps {
            script '''
node {
    git 'https://github.com/rlespinasse/jenkinsdsl__project-maven.git'
    sh "mvn"
    sh "java -jar target/Golo-0.0.1-SNAPSHOT-jar-with-dependencies.jar"
}
'''
            sandbox()
        }
    }
}

def persons = ['ludovic', 'aurelien', 'antoine', 'romain', 'nicolas', 'etc...']

persons.each {

    workflowJob("hellos/hello_${it}") {
        definition {
            cps {
                script """
node {
    echo 'Hello ${it}!!'
}
"""
                sandbox()
            }
        }
    }
}