def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    
                echo " Building the Docker image & Pushing into DockerHub"
                 withCredentials([usernamePassword(credentialsId: 'DockerHub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                 sh 'docker build -t ragesh2u/my-repo:jvm-2.0  .'
                 sh "echo $PASS | docker login -u $USER --password-stdin"
                 sh 'docker push ragesh2u/my-repo:jvm-2.0'
                 //* if docker fail /change the permission chmod 777 /var/run/docker.sock inside jenkins container using root -u 0
                }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this