#!/usr/bin/env groovy
pipeline {
    agent any 
    tools {
        maven 'Maven'
    }
    stages {
        stage('increment version') {
            steps{
                script{
                    echo "increment the appication"
                    sh 'mvn build-helper:parse-version:set -Dnewversion=\\\${ParsedVersion.majorVersion}.\\\${ParsedVersion.minorVersion}.\\\${ParsedVersion.NextIncrementVersion} version:commit'
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
                    echo "Building the Docker image & Pushing into DockerHub"
                     withCredentials([usernamePassword(credentialsId: 'DockerHub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                     sh 'docker build -t ragesh2u/my-repo:jvm-2.0  .'
                     sh "echo $PASS | docker login -u $USER --password-stdin"
                     sh 'docker push ragesh2u/my-repo:jvm-2.0'
                      //* if docker fail /change the permission chmod 777 /var/run/docker.sock inside jenkins container using root -u 0
                    }
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
