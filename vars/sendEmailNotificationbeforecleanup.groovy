def call() {
    def currentDayOfWeek = new Date().format('EEEE')
    if (currentDayOfWeek == 'Friday'){
                    echo '-----------sending mail for workspaceCleanup Approval-------------'
                    mail body: "<b>workspaceCleanup Approval</b><br>Project: ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br> URL of build: ${env.BUILD_URL} ", 
                        cc: '', 
                        charset: 'UTF-8', 
                        from: 'shabnambeas5@gmail.com', 
                        mimeType: 'text/html', 
                        replyTo: 'vishalsadar75@gmail.com', 
                        subject: "Job: '${env.JOB_NAME} [${env.BUILD_NUMBER}]'", 
                        to: 'vishalsadar75@gmail.com'; 
                    }
                    else{
                        echo "skipping the stage as today is not cleanup day"
                    }
}
