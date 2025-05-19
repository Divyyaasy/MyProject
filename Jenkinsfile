pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Divyyaasy/MyProject.git'
            }
        }

        stage('Build') {
            steps {
                bat 'C:\\apache-maven-3.9.9\\bin\\mvn -Dmaven.test.failure.ignore=true clean package'
            }
        }
    }

    post {
        success {
            junit '**/target/surefire-reports/TEST-*.xml'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}
