pipeline {
    agent any
    stages {
        stage('Git checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ankush-09/TEST-Coding.git']])
            }
        }
        stage('Print workspace') {
            steps {
                sh "ls -a ${WORKSPACE}"
            }
        }
        stage('Grype scan') {
            steps {
                grypeScan scanDest: "dir:${WORKSPACE}", repName: 'ScanResult.txt', autoInstall:true
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
                reportFiles: 'ScanResult.txt',
                reportName: 'Grype Scan Report'
            ])
        }
    }
}
