pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                bat 'echo Hello from Windows!'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                bat 'echo Running tests...'
            }
        }
        stage('Report') {
            steps {
                echo 'Generating report...'
                bat 'echo Done!'
            }
        }
    }
}
