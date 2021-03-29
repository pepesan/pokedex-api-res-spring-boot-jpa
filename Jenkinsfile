pipeline { // define la pipeline
     agent any // equipo a seleccionar para ejecutar los steps
     tools {
             // instala la versión de macen "3.6.1" y añadela al path.
             maven "3.6.1"
     }
     stages { // definición de fases
         stage('Build') { // fase de construcción
             steps { // pasos
                git 'https://github.com/pepesan/pokedex-api-res-spring-boot-jpa.git'
                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean compile"
             }
         }
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
     }
}