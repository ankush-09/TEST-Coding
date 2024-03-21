// vars/workspaceCleanup.groovy

def call() {
    // Get the current day of the week
    def currentDay = new Date().format('u')
    
    // Check if it's Saturday (day 6)
    if (currentDay == '5') {
        // Delete files older than 7 days
        sh 'find . -type f -mtime +7 -delete' //delete the 7 days old files
    } else {
        echo "Skipping workspace cleanup as it is not CleanUp day."
    }
}
