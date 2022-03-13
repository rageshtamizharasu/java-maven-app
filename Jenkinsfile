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
                    gv.buildJar()
                }
            }
           
        }
        stage("Building Docker image"){
            steps{
                echo " Building the Docker image & Pushing into DockerHub"
                 withCredentials([usernamePassword(credentialsId: 'DockerHub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                 sh 'docker build -t ragesh2u/my-repo:jvm-2.0  .'
                 sh "echo $PASS | docker login -u $USER --password-stdin"
                 sh 'docker push ragesh2u/my-repo:jvm-2.0'
                 //* if docker fail make sure to change the permission chmod 777 /var/run/docker.sock
                }
            }
        }   
    }
}