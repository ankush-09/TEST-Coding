pipeline {
    agent any
    
    environment {
        GITHUB_REPO = 'ankush-09/TEST-Coding' // Specify the GitHub repository to scan
    }
    
    stages {
        stage('Clone Repository') {
            steps {
                script {
                    // Clone the public GitHub repository
                    git url: "https://github.com/${env.GITHUB_REPO}.git"
                }
            }
        }
        
        stage('Scan for Vulnerabilities') {
            steps {
                script {
                    // Run Grype to scan the repository for vulnerabilities
                    sh "grype ${env.GITHUB_REPO} > ScanResult.txt"
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
                reportFiles: 'ScanResult.txt',
                reportName: 'Grype Scan Report'
            ])
        }
    }
}
