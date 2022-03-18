#!/usr/bin/env groovy
@library('jenkins-shared-library')_
pipeline{
    agent any
    tools{
        maven 'Maven'
    }
    stages{
        stage("building application maven"){
            steps{
                script{
                    buildJar()
                }
            }
        }
    }
}
