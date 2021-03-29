pipeline { // define la pipeline
     agent any // equipo a seleccionar para ejecutar los steps
     stages { // definición de fases
         stage('Build') { // fase de construcción
             steps { // pasos
                mvn clean compile
             }
         }
         stage('Test') {// fase de construcción
             steps {// pasos
                 mvn test
             }
         }
         stage('Deploy') {// fase de construcción
             steps {// pasos
                mvn install
             }
         }
     }
}