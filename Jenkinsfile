#!/usr/bin/env groovy
@library('jenkins-shared-library')
def gv
pipeline{
    agent any
    tools{
        maven 'Maven'
    }
    stages{
        stage("init"){
            steps{
                script{
                    gv = load "script.groovy"
                }
            }
        }     
        stage("Building jar file"){
            steps{
                script{
                    buildJar()
                }
            }
           
        }
        stage("Building Docker image"){
            steps{
                script{
                    gv.buildImage()
                }
            }
        }   
    }
}