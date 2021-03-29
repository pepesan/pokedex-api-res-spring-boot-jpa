pipeline { // define la pipeline
     agent any // equipo a seleccionar para ejecutar los steps
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