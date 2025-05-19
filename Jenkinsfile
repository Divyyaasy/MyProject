pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test' // or any other test command
            }
        }

        stage('Report') {
            steps {
                echo 'Publishing test results...'
                junit 'target/surefire-reports/*.xml' // This line must be here
            }
        }
    }
}
