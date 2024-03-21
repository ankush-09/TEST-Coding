pipeline {
    agent any
    stages {
        stage('Git checkout') {
            steps {
                checkout scm
            }
        }
        stage('Print workspace') {
            steps {
                sh "ls -a ${WORKSPACE}"
            }
        }
        stage('Grype scan') {
            steps {
                script {
                    sh "grype ${WORKSPACE}"
                }
            }
        }
    }
    post {
        always {
            // Publish HTML report
            publishHTML([
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: '.',
                reportFiles: 'grype-report.json',
                reportName: 'Grype Scan Report'
            ])
        }
    }
}
