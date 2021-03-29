pipeline { // define la pipeline
     agent any // equipo a seleccionar para ejecutar los steps
     tools {
             // Install the Maven version configured as "M3" and add it to the path.
             maven "3.6.1"
     }
     stages { // definición de fases
         stage('Build') { // fase de construcción
             steps { // pasos
                git 'https://github.com/pepesan/pokedex-api-res-spring-boot-jpa.git'
                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
             }
         }
         stage('Test') {// fase de construcción
             steps {// pasos
                 // Run Maven on a Unix agent.
                 sh "mvn test"
             }
         }
         stage('Deploy') {// fase de construcción
             steps {// pasos
                // Run Maven on a Unix agent.
                sh "mvn install"
             }
         }
     }
}