folder 'hellos'

workflowJob('hellos/hello_world') {
    definition {
        cps {
            script(readFileFromWorkspace('resources/pipeline_hello_world.groovy'))
            sandbox()
        }
    }
}

workflowJob('hellos/hello_golo') {
    definition {
        cps {
            script(readFileFromWorkspace('resources/pipeline_hello_golo.groovy'))
            sandbox()
        }
    }
}

def persons = ['ludovic', 'aurelien', 'antoine', 'romain', 'nicolas', 'etc...']

persons.each {
    String person = it

    workflowJob("hellos/hello_${person}") {
        definition {
            cps {
                script(readFileFromWorkspace('resources/pipeline_hello_person.groovy'))
                sandbox()
            }
        }
        environmentVariables {
            env('PERSON', person)
        }
    }
}