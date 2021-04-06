pipeline { // define la pipeline
    environment {
        DOCKER_IMAGE_NAME = "pepesan/pokedex-microservice"
        DOCKERHUB_CREDS = credentials('dockerhub')
    }
    agent any // equipo a seleccionar para ejecutar los steps
    tools {
             // instala la versión de maven "3.6.1" y añadela al path.
             maven "3.6.1"
    }
    stages { // definición de fases
         stage('Build') { // fase de construcción
             steps { // pasos
                git 'https://github.com/pepesan/pokedex-api-res-spring-boot-jpa.git'
                sh "mvn -Dmaven.test.failure.ignore=true clean compile install"
             }
         }
         stage("build Docker image"){
            steps{
                            sh "echo $BUILD_NUMBER"
                            //sh "docker build -t $DOCKER_IMAGE_NAME:latest ."
                            //sh "docker build -t $DOCKER_IMAGE_NAME:$BUILD_NUMBER ."
                            //sh "echo $BUILD_NUMBER $DOCKERHUB_CREDS $DOCKERHUB_CREDS_USR $DOCKERHUB_CREDS_PSW"
                            //sh "docker login -u $DOCKERHUB_CREDS_USR -p $DOCKERHUB_CREDS_PSW"
                            //sh "docker push $DOCKER_IMAGE_NAME:$BUILD_NUMBER"
                            //sh "docker push $DOCKER_IMAGE_NAME:latest"
                            //sh "docker-compose up -d"
                            //sh "docker-compose down"

            }
         }
         stage("development"){
            when {
                branch 'development'
            }
            steps{
                sh "echo development"
            }
         }
         stage("staging"){
            when {
                branch 'staging'
            }
            steps{
                sh "echo staging"
            }
        }
        // Documento proceso de producción
        stage("production"){
            steps{
                sh "echo production"
            }
        }
         /*
         stage('Test') {// fase de construcción
             steps {// pasos
                 parallel(
                  unit: {
                    // Run Maven on a Unix agent.
                    sh "mvn test"
                  },
                  integration: {
                    sh "mvn integration-test"
                  }
                 )
             }
         }
         stage('Deploy') {// fase de construcción
             steps {// pasos
                // Run Maven on a Unix agent.
                sh "mvn install"
             }
         }
         */
    }
}