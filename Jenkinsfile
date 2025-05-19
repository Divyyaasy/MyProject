pipeline {
    agent any

    tools {
        maven 'Maven 3.9.9'   // Replace with the name configured in Jenkins Global Tool Configuration C:\apache-maven-3.9.9
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'e69f9622-72e9-463a-9c21-84a414c1ee15', url: 'https://github.com/Divyyaasy/MyProject.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
