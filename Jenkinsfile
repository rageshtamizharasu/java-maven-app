pipeline{
    agent any
    tools{
        maven 'Maven'
    }
    stages{
        stage("building jar file"){
            steps{
                echo "Building the jar file application"
                sh 'mvn package'
            }
        }
    }
}