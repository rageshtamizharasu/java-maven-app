#!/usr/bin/env groovy
@library('jenkins-shared-library')_
pipeline{
    agent any
    tools{
        maven 'Maven'
    }
    stage("Building jar file"){
            steps{
                script{
                    buildJar()
                }
            }
           
        }
    }
}