#!/usr/bin/env groovy
def gv 
pipeline {
    agent any 
     tools{
        maven 'Maven'
    }
    stages {
        stage('building application'){
            steps{
                script{
                    sh 'mvn clean package'
                }
            }
        }
        stage('build Docker image') {
            steps{
                script{
                    gv.buildImage()
                }
            }
        }
        stage('deploy the Ec2') {
            steps{
                script{
                    echo "deployin the application"
                }
            }
        }

    }
}
