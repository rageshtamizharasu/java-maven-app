#!/usr/bin/env groovy
def gv 
pipeline {
    agent any 
     tools{
        maven 'Maven'
    }
    stages {
        stage('init'){
            steps{
                script{
                    gv = load "script.groovy"
                }
            }
        }
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
        post {
        success {
            mail to: 'rageshtamizharasu@gmail.com',
                 subject: 'Build Succeeded!',
                 body: 'The build has succeeded.'
        }
        failure {
            mail to: 'rageshtamizharasu@gmail.com',
                 subject: 'Build Failed!',
                 body: 'The build has failed.'
        }

    }
}
