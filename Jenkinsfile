pipeline{
    agent any
    tools{
        maven 'Maven'
    }
    stages{
        stage("Building jar file"){
            steps{
                echo "Building the jar file application"
                sh 'mvn package'
            }
        }
        stage("Building Docker image"){
            steps{
                echo " Building the Docker image & Pushing into DockerHub"
                 withCredentials([usernamePassword(credentialsId: 'DockerHub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                 sh 'docker build -t ragesh2u/my-repo:jvm-2.0  .'
                 sh "echo $PASS | docker login -u $USER --password-stdin"
                 sh 'docker push ragesh2u/my-repo:jvm-2.0'
                }
            }
        }   
    }
}