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
                script{
                    gv.buildImage()
                }
            }
        }   
    }
}